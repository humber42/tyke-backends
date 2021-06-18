package cu.edu.cujae.questionservice.api.profileRespuestaPregunta;


import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.ProfileRespuestaPreguntaDto;
import cu.edu.cujae.questionservice.services.ProfileRespuestaPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.PROFILE_RESPUESTA_PREGUNTA_API)
public class ProfileRespuestaPreguntaRestController {

    @Autowired
    ProfileRespuestaPreguntaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<ProfileRespuestaPreguntaResponse> getAll() {
        return service.getAllProfileRespuestaPregunta().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.ProfileRespuestaPreguntaUrls.PROFILE_RESPUESTA_PREGUNTA_GET_BY_ID, params = "id")
    public ProfileRespuestaPreguntaResponse getById(@RequestParam long id) {
        return service.getOneProfileRespuestaPregunta(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.ProfileRespuestaPreguntaUrls.PROFILE_RESPUESTA_PREGUNTA_DELETE_BY_ID, params = "id")
    public ProfileRespuestaPreguntaResponse delete(@RequestParam long id) {
        return convertir(service.delete(id));
    }

    @PostMapping(WebResourceKeyConstants.ProfileRespuestaPreguntaUrls.PROFILE_RESPUESTA_PREGUNTA_SAVE)
    public int save(@RequestBody ProfileRespuestaPreguntaRequest request) {
        return service.save(mapper.map(request, ProfileRespuestaPreguntaDto.class));
    }

    @PostMapping(WebResourceKeyConstants.ProfileRespuestaPreguntaUrls.PROFILE_RESPUESTA_PREGUNTA_UPDATE)
    public ProfileRespuestaPreguntaResponse update(@RequestBody ProfileRespuestaPreguntaResponse request) {
        return convertir(service.update(mapper.map(request, ProfileRespuestaPreguntaDto.class)));
    }

    private ProfileRespuestaPreguntaResponse convertir(ProfileRespuestaPreguntaDto dto) {
        return mapper.map(dto, ProfileRespuestaPreguntaResponse.class);
    }

}
