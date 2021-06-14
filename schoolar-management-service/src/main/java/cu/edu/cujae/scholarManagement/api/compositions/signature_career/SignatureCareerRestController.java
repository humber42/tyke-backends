package cu.edu.cujae.scholarManagement.api.compositions.signature_career;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.SignatureCarreraDto;
import cu.edu.cujae.scholarManagement.service.SignatureFacultyService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(WebResourceKeyConstants.SIGNATURE_CAREER)
public class SignatureCareerRestController {

    @Autowired
    private SignatureFacultyService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.SignatureFacultyUrls.SIGNATURE_FACULTY_SAVE)
    public int save(@RequestBody SignatureCareerRequest request){
        return service.saveSignatureFaculty(mapper.map(request, SignatureCarreraDto.class));
    }

    @PostMapping(WebResourceKeyConstants.SignatureFacultyUrls.SIGNATURE_FACULTY_DELETE)
    public int delete(@PathVariable("id") long id){
        return service.deleteSignatureFaculty(id);
    }

}
