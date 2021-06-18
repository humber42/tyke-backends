package cu.edu.cujae.questionservice.services;


import cu.edu.cujae.questionservice.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {

    List<FeedbackDto> getAllFeedback();
    FeedbackDto getOne(long id);
    FeedbackDto delete(long id);
    int save(FeedbackDto feedbackDto);
    FeedbackDto update(FeedbackDto dto);

}
