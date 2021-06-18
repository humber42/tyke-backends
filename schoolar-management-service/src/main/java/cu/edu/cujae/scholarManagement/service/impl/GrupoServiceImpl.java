package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.api.estudiante.EstudianteResponse;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoRequest;
import cu.edu.cujae.scholarManagement.domain.GrupoEntity;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorGrupoDto;
import cu.edu.cujae.scholarManagement.dto.EstudianteGrupoDto;
import cu.edu.cujae.scholarManagement.dto.GrupoDto;
import cu.edu.cujae.scholarManagement.repository.GrupoRepository;
import cu.edu.cujae.scholarManagement.service.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    GrupoRepository repository;
    @Autowired
    Mapper mapper;
    @Autowired
    EstudianteGrupoService estudianteGrupoService;
    @Autowired
    CursoService cursoService;
    @Autowired
    CarreraService carreraService;
    @Autowired
    ProfesorService profesorService;


    @Override
    public GrupoDto deleteGrupoById(int id) {
        GrupoDto dto = getGrupoById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public GrupoDto deleteGrupoByName(String name) {
        GrupoDto dto = getGrupoByName(name);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public GrupoDto getGrupoById(int id) {
        return mapper
                .map(
                        repository.getOne(Long.valueOf(String.valueOf(id))
                        ), GrupoDto.class);
    }

    @Override
    public GrupoDto getGrupoByName(String name) {
        return mapper.map(repository.getGrupoEntityByGrupo(name), GrupoDto.class);
    }

    @Override
    public GrupoDto saveGrupo(GrupoRequest dto) {
        int idCarrera = carreraService.getCarreraByName(dto.getCarrera()).getId();

        GrupoEntity grupoEntity = mapper.map(dto, GrupoEntity.class);
        grupoEntity.setIdCarrera(idCarrera);
        grupoEntity.setGrupo(dto.getGrupo());
        Long idGrupo = repository.save(grupoEntity).getId();
        int idCurso = cursoService.getCursoByName(dto.getCurso()).getId();
        for (EstudianteResponse response : dto.getEstudiantes()
        ) {
            EstudianteGrupoDto estudianteGrupoDto = EstudianteGrupoDto.builder()
                    .idAnno(dto.getAnno())
                    .idGrupo(idGrupo.intValue())
                    .idEstudiante(response.getId())
                    .idCurso(idCurso).build();
            estudianteGrupoService.saveEstudianteGrupo(estudianteGrupoDto);
        }
        return getGrupoById(idGrupo.intValue());
    }

    @Override
    public GrupoDto updateGrupo(GrupoDto dto) {
        return mapper.map(repository.saveAndFlush(mapper.map(dto, GrupoEntity.class)), GrupoDto.class);
    }

    @Override
    public List<GrupoDto> findAllGrupo() {
        return repository.findAll().stream().map(grupoEntity -> mapper.map(grupoEntity, GrupoDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<GrupoDto> findAllGrupoByCarrera(String carrera, int idProfesor) {
        int idCarrera = carreraService.getCarreraByName(carrera).getId();
        Collection<AsignaturaProfesorGrupoDto> asignaturaProfesorGrupoDto = profesorService
                .getProfesorById(idProfesor).getAsignaturaProfesorGruposById();


        return repository.findAllByIdCarrera(idCarrera)
                .stream()
                .map(entity -> mapper.map(entity, GrupoDto.class))
                .filter(entity -> {
                            boolean notAsigned = true;
                            for (AsignaturaProfesorGrupoDto dto : asignaturaProfesorGrupoDto) {
                                if(dto.getIdGrupo()==entity.getId().intValue()){
                                    notAsigned=false;
                                }
                            }
                            return notAsigned;
                        }
                )
                .collect(Collectors.toList());
    }

}
