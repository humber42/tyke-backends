package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo.BonificacionPreguntaTiempoRequest;
import cu.edu.cujae.questionservice.api.pista.PistaRequestForQuestion;
import cu.edu.cujae.questionservice.api.pregunta.PreguntaRequestWithRespuestasCluesBonifications;
import cu.edu.cujae.questionservice.api.respuesta.RespuestaRequestToPregunta;
import cu.edu.cujae.questionservice.domain.PistaEntity;
import cu.edu.cujae.questionservice.domain.PreguntaEntity;
import cu.edu.cujae.questionservice.dto.*;
import cu.edu.cujae.questionservice.feingInterface.AsignaturaInterface;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.PistaRepository;
import cu.edu.cujae.questionservice.repository.PreguntaRepository;
import cu.edu.cujae.questionservice.services.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    PreguntaRepository repository;

    @Autowired
    AsignaturaInterface asignaturaInterface;

    @Autowired
    RespuestaService respuestaService;

    @Autowired
    TipoPreguntaService tipoPreguntaService;

    @Autowired
    JdbcRepository jdbcRepository;
    @Autowired
    TipoPistaService tipoPistaService;

    @Autowired
    PistaService pistaService;

    @Autowired
    Mapper mapper;

    @Autowired
    PistaRepository pistaRepository;

    @Autowired
    BonificacionPreguntaTiempoService bonificacionPreguntaTiempoService;

    @Autowired
    FeedbackService feedbackService;


    @Autowired
    ProfileRespuestaPreguntaService profileRespuestaPreguntaService;

    @Override
    public List<PreguntaDto> getAllPreguntas() {
        return repository.findAll().stream().map(this::mappearAsignatura).collect(Collectors.toList());
    }

//    @Override
//    public List<PreguntaDto> getAllPreguntasByTipo(String tipo) {
//        return repository.getAllByTipoPreguntaByIdTipoPregunta_Tipo(tipo).stream().map(this::mappearAsignatura).collect(Collectors.toList());
//    }

    @Override
    public Optional<PreguntaDto> findOnePregunta(long id) {
        Optional<PreguntaDto> pregunta = repository.findById(id).map(map->mapper.map(map, PreguntaDto.class));
        List<AsignaturaDto> lisdto = asignaturaInterface.getAllAsign();
        AsignaturaDto dto = asignaturaInterface.fetchByAsignaturaName(pregunta.get().getAsignatura());
        pregunta.get().setAsignaturaObject(dto);
        return pregunta;
    }

    @Override
    public PreguntaDto deletePregunta(long id) {
        PreguntaDto dto = this.findOnePregunta(id).get();
        repository.deleteById(id);
        return dto;
    }

    @Override
    public int savePregunta(PreguntaDto dto) {
        return jdbcRepository.savePregunta(dto);
    }

    @Override
    public PreguntaDto updatePregunta(PreguntaDto dto) {
        return mappearAsignatura(
                repository.saveAndFlush(mapper.map(dto, PreguntaEntity.class))
        );
    }


    @Override
    public PreguntaDto savePreguntaWithCluesAndBonifications(PreguntaRequestWithRespuestasCluesBonifications request) {
        long idTipoPregunta = tipoPreguntaService.getByName(request.getTipoPregunta()).getId();
        PreguntaEntity entityPregunta  = repository.save(mapper.map(PreguntaDto.builder()
                .asignatura(request.getAsignatura())
                .idTipoPregunta(idTipoPregunta)
                .tituloPregunta(request.getTituloPregunta())
                .tiempoEnSegundos(request.getTiempoMenor())
                .cantPuntosCompletarCorrectamente(request.getPuntuacion())
                        .build(),
                PreguntaEntity.class));

        if(request.getTipoPregunta().equalsIgnoreCase("ordenar")){
            savePreguntaRespuestaOrdenar(entityPregunta.getId(),request.getRespuestas());
        }
        else if(request.getTipoPregunta().equalsIgnoreCase("enlazar")){
            savePreguntaRespuestaEnlazar(entityPregunta.getId(),request.getRespuestas());
        }
        else if(request.getTipoPregunta().equalsIgnoreCase("completar")){
            savePreguntaRespuestaCompletar(entityPregunta.getId(),request.getRespuestas());
        }
       else{
           savePreguntaRespuestaMarcar(entityPregunta.getId(),request.getRespuestas());
        }
        this.saveBonificationOfQuestiosn(request.getBonificaciones(),entityPregunta.getId());
        this.saveCluesOfQuestions(request.getPistas(),entityPregunta.getId());

        return findOnePregunta(entityPregunta.getId()).get();
    }

    /**
     * Mehtod that save bonifications to a questions
     * @param bonificaciones
     */
    private void saveBonificationOfQuestiosn(List<BonificacionPreguntaTiempoRequest> bonificaciones,long idPregunta){
        for (BonificacionPreguntaTiempoRequest bonificacion: bonificaciones
             ) {
                      jdbcRepository.saveBonificacion(BonificacionPreguntaTiempoDto
                              .builder().bonificacion(bonificacion.getBonificacion())
                      .idPregunta(idPregunta).tiempoMenor(bonificacion.getTiempoMenor()).build());
        }
    }

    private void saveCluesOfQuestions(List<PistaRequestForQuestion> pistas, Long idPregunta){
        for (PistaRequestForQuestion pista:pistas
             ) {
            Long idTipoPista = tipoPistaService.getByName(pista.getTipoPistaSelected()).getId();
            PistaEntity pistaEntity = mapper.map(PistaDto.builder()
                    .idTipoPista(idTipoPista.intValue())
                    .textoAyuda(pista.getPistaName())
                    .idPregunta(idPregunta).build(), PistaEntity.class);

            pistaRepository.save(pistaEntity).getId();
        }
    }

    /**
     * Salva el tipo de pregunta de marcar
     * @param idPregunta ID de la pregunta
     * @param request Lista de respuestas
     * @return
     */
    private int savePreguntaRespuestaMarcar(long idPregunta,List<RespuestaRequestToPregunta> request){
        for (RespuestaRequestToPregunta respuesta:
                request
             ) {
            this.saveRespuesta(RespuestaDto.builder()
                    .puntuacion(respuesta.getPuntuacion())
                    .texto(respuesta.getRespuesta())
                    .correcta(respuesta.isCorrecta())
                    .idPregunta(idPregunta)
                    .build()
            );

        }
        return 0;
    }


    /**
     * Metod que salva el tipo de respuesta ordenar
     * @param idPregunta ID de la pregunta
     * @param respuestas lista de respuestas a ordenar
     * @return
     */
    private int savePreguntaRespuestaOrdenar(long idPregunta,List<RespuestaRequestToPregunta> respuestas){
        for (RespuestaRequestToPregunta respuesta:
             respuestas) {
            long idRespuesta = saveRespuesta(RespuestaDto.builder()
                    .idPregunta(idPregunta)
                    .orden(respuesta.getOrden())
                    .texto(respuesta.getRespuesta())
                    .puntuacion(respuesta.getPuntuacion())
                    .build());
                    }
        return 0;
    }

    /**
     * Metodo que salva las respuestas del tipo de preunta Completar
     * @param idPregunta ID pregunta
     * @param respuestas lista de posibles palabras a completar
     * @return
     */
    private int savePreguntaRespuestaCompletar(long idPregunta, List<RespuestaRequestToPregunta> respuestas){
        for (RespuestaRequestToPregunta respuesta: respuestas
             ) {
            long idRespuesta = saveRespuesta(RespuestaDto.builder()
                    .puntuacion(respuesta.getPuntuacion())
                    .texto(respuesta.getRespuesta())
                    .textoEnlazar(respuesta.getFraseFinal())
                    .correcta(respuesta.isCorrecta())
                    .idPregunta(idPregunta)
                    .build());

        }
        return 0;
    }

    /**
     * Metodo que salva el tipo de respuestas para la pregunta enlazar
     * @param idPreguntaPadre pregunta original
     * @param respuestas listas de enlazas
     * @return
     */
   private int savePreguntaRespuestaEnlazar(long idPreguntaPadre,List<RespuestaRequestToPregunta> respuestas){
       for (RespuestaRequestToPregunta respuesta: respuestas
            ) {
           long idRespuesta = saveRespuesta(RespuestaDto.builder()
                   .idPregunta(idPreguntaPadre)
                   .textoEnlazar(respuesta.getRespuesta())
                   .texto(respuesta.getPregunta())
                   .puntuacion(respuesta.getPuntuacion())
                   .build());
       }
        return 0;
   }

    @Override
    public List<PreguntaDto> getAllPreguntaByAsignatura(String asignatura) {
        return repository.findAllByAsignatura(asignatura)
                .stream()
                .map(this::mappearAsignatura)
                .collect(Collectors.toList());
    }

    /**
     * This method make a mapping for every @class PreguntaEntity
     * @param entity PreguntaEntity
     * @return PreguntaDto
     */
    private PreguntaDto mappearAsignatura(PreguntaEntity entity) {
        PreguntaDto dto = mapper.map(entity, PreguntaDto.class);
        dto.setBonificacionPreguntaTiemposById(bonificacionPreguntaTiempoService
                .getAll()
                .stream()
                .filter(entity2->entity2.getIdPregunta()==dto.getId())
                .collect(Collectors.toList()));
        dto.setFeedbacksById(feedbackService
                .getAllFeedback()
                .stream()
                .filter(feedback->feedback.getIdPregunta()==dto.getId())
                .collect(Collectors.toList()));
        dto.setPistasById(pistaService
                .getAllPistas()
                .stream()
                .filter(pistaPreguntaDto -> pistaPreguntaDto.getIdPregunta()==dto.getId())
                .collect(Collectors.toList()));
        dto.setProfileRespuestaPreguntasById(profileRespuestaPreguntaService
                .getAllProfileRespuestaPregunta()
                .stream()
                .filter(predicate->predicate.getIdPregunta()==dto.getId())
                .collect(Collectors.toList()));
        dto.setRespuestasById(respuestaService.getAllRespuesta()
                .stream()
                .filter(predicate->predicate.getIdPregunta()==dto.getId())
                .collect(Collectors.toList())
        );
        AsignaturaDto asignatura = asignaturaInterface.fetchByAsignaturaName(entity.getAsignatura());
        TipoPreguntaDto tipoPreguntaDto = tipoPreguntaService.getOneTipoPregunta(dto.getIdTipoPregunta()).get();
        dto.setTipoPreguntaByIdTipoPregunta(tipoPreguntaDto);
        dto.setAsignaturaObject(asignatura);
        return dto;
    }
    private long saveRespuesta(RespuestaDto dto){
        return respuestaService.save(dto).getId();
    }

}
