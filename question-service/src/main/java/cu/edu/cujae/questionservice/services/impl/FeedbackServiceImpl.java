package cu.edu.cujae.questionservice.services.impl;


import cu.edu.cujae.questionservice.domain.FeedbackEntity;
import cu.edu.cujae.questionservice.dto.FeedbackDto;
import cu.edu.cujae.questionservice.feingInterface.UserInterface;
import cu.edu.cujae.questionservice.repository.FeedbackRepository;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.services.FeedbackService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository repository;

    @Autowired
    JdbcRepository jdbcrepository;

    @Autowired
    UserInterface userInterface;

    @Autowired
    Mapper mapper;

    @Override
    public FeedbackDto delete(long id) {
        FeedbackDto dto = getOne(id);
        repository.deleteById(id);
        return addingUserToResponse(dto);
    }

    @Override
    public FeedbackDto getOne(long id) {
        return addingUserToResponse(repository.getOne(id));
    }

    @Override
    public int save(FeedbackDto feedbackDto) {
        return jdbcrepository.saveFeedback(feedbackDto);
    }

    @Override
    public FeedbackDto update(FeedbackDto dto) {
        return addingUserToResponse(repository.saveAndFlush(mapper.map(dto,FeedbackEntity.class)));
    }

    @Override
    public List<FeedbackDto> getAllFeedback() {
        return repository.findAll().stream().map(this::addingUserToResponse).collect(Collectors.toList());
    }

    private FeedbackDto addingUserToResponse(FeedbackDto feedbackDto){
        FeedbackDto feedback = feedbackDto;
        feedback.setUser(userInterface.searchById(feedback.getUsername()));
        return feedback;
    }

    private FeedbackDto addingUserToResponse(FeedbackEntity feedbackDto){
        FeedbackDto feedback = mapper.map(feedbackDto, FeedbackDto.class);
        return addingUserToResponse(feedback);
    }
}
