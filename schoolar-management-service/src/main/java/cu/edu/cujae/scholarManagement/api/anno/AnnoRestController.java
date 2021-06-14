package cu.edu.cujae.scholarManagement.api.anno;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AnnoDto;
import cu.edu.cujae.scholarManagement.service.AnnoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.ANNO_URL)
public class AnnoRestController {

    @Autowired
    AnnoService service;

    @Autowired
    Mapper mapper;

    @GetMapping
    public List<AnnoResponse> findAllAnno(){
        return service.findAllAnno().stream().map(annoDto -> mapper.map(annoDto,AnnoResponse.class)).collect(Collectors.toList());
    }

    @DeleteMapping(value = WebResourceKeyConstants.AnnoUrls.ANNO_DELETE_ANNO_BY_ANNO,params = "anno")
    public AnnoResponse deleteByAnno(@RequestParam String anno){
        return mapper.map(service.deleteAnnoByName(anno), AnnoResponse.class);
    }

    @PostMapping(value = WebResourceKeyConstants.AnnoUrls.ANNO_SAVE)
    public AnnoResponse saveAnno(@RequestBody AnnoRequest request){
        return mapper.map(service.saveAnno(AnnoDto.builder().anno(request.getAnno()).build()), AnnoResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.AnnoUrls.ANNO_GET_ONE_BY_ANNO,params = "anno")
    public AnnoResponse getOneAnno(@RequestParam String anno){
        return mapper.map(service.findAnnoByName(anno), AnnoResponse.class);
    }

    @PostMapping(value = WebResourceKeyConstants.AnnoUrls.ANNO_UPDATE)
    public AnnoResponse updateAnnoDto(@RequestBody AnnoDto dto){
        return mapper.map(service.update(dto), AnnoResponse.class);
    }



}
