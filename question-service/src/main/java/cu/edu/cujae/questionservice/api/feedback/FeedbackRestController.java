package cu.edu.cujae.questionservice.api.feedback;


import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.FeedbackDto;
import cu.edu.cujae.questionservice.services.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static cu.edu.cujae.questionservice.constants.WebResourceKeyConstants.FeedbackUrls.*;

@RestController
@RequestMapping(WebResourceKeyConstants.FEEDBACK_API)
@Api(value = "This is a feedback controller",tags = "FeedbackController")
public class FeedbackRestController {

    @Autowired
    FeedbackService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<FeedbackResponse> getALlFeedbacks(){
        return service.getAllFeedback().stream().map(dto->mapper.map(dto, FeedbackResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(value = GET_FEEDBACK_BY_ID,params = "id")
    public ResponseEntity getOne(@RequestParam long id){
        return ResponseEntity.ok().body(mapper.map(service.getOne(id), FeedbackResponse.class));
    }

    @PostMapping(SAVE_FEEDBACK)
    @ResponseBody
    @ApiOperation("Save new feedback")
    public ResponseEntity<?> saveFeedback(@Valid @RequestBody FeedbackRequest request) {
       FeedbackResponse response = mapper.map(
                service.save(mapper.map(request, FeedbackDto.class))
                , FeedbackResponse.class
        );
       return ResponseEntity.ok(response);
    }

    @PostMapping(UPDATE_FEEDBACK)
    public ResponseEntity<?> updateFeedback(@RequestBody FeedbackResponse request){
        return ResponseEntity.ok().body(mapper.map(
                service.save(mapper.map(request, FeedbackDto.class))
                , FeedbackResponse.class
        ));
    }

    @DeleteMapping(value = DELETE_FEEDBACK_BY_ID,params = "id")
    public FeedbackResponse deleteFeedbackById(@RequestParam long id){
        return mapper.map(service.delete(id), FeedbackResponse.class);
    }


}
