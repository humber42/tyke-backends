package cu.edu.cujae.tykenotifications.service.impl;

import cu.edu.cujae.tykenotifications.domain.MessageEntity;
import cu.edu.cujae.tykenotifications.dto.Messages;
import cu.edu.cujae.tykenotifications.feing_interface.UserInterface;
import cu.edu.cujae.tykenotifications.repository.MessageRepository;
import cu.edu.cujae.tykenotifications.service.MessageService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserInterface userService;

    @Override
    public List<Messages> getAllMessageFromUser(long idUser) {
        return repository.findAllByIdFromUser(idUser)
                .stream()
                .map(this::mappingMessage)
                .collect(Collectors.toList());
    }

    @Override
    public List<Messages> getAllMessageFromUserToUser(long idFromUser, long idtoUser) {
        return repository.findAllByIdFromUserAndIdToUser(idFromUser, idtoUser)
                .stream()
                .map(this::mappingMessage)
                .collect(Collectors.toList());
    }

    @Override
    public List<Messages> getAllMessageMyMessage(long idUser) {
        return repository.findAllByIdToUser(idUser)
                .stream()
                .map(this::mappingMessage)
                .collect(Collectors.toList());
    }

    @Override
    public List<Messages> getAllMessageNotReceived(long idUser) {
        List<Messages> messages= repository.findAllByIdToUserAndReceivedIsFalse(idUser)
                .stream()//.filter(entity -> !entity.getReceived())
                .map(this::mappingMessage)
                .collect(Collectors.toList());
        return messages;
    }

    @Override
    public Messages markAsRead(long id) {
        Optional<Messages> messages = getMessageById(id);
        if (messages.isPresent()) {
            messages.get().setReaded(true);
            repository.saveAndFlush(mapper.map(messages.get(), MessageEntity.class));
            return messages.get();
        } else return null;
    }

    @Override
    public Messages markAsReceived(long id) {
        Optional<Messages> message = getMessageById(id);
        if (message.isPresent()) {
            message.get().setReceived(true);
            repository.saveAndFlush(mapper.map(message.get(), MessageEntity.class));
            return message.get();
        } else return null;
    }

    @Override
    public Messages saveMessage(Messages messages) {
        return mappingMessage(repository.save(mapper.map(messages, MessageEntity.class)));
    }

    @Override
    public Optional<Messages> getMessageById(long id) {
        return repository.findById(id).map(this::mappingMessage);
    }

    @Override
    public void deleteMessageJustForMe(long id, boolean receiver) {
        Messages messages = repository.findById(id).map(this::mappingMessage).get();
        if (receiver)
            messages.setIdToUser(Integer.toUnsignedLong(0));
        else
            messages.setIdFromUser(Integer.toUnsignedLong(0));
        repository.saveAndFlush(mapper.map(messages, MessageEntity.class));

    }

    @Override
    public void deletMessageById(long id) {
        repository.deleteById(id);
    }

    private Messages mappingMessage(MessageEntity entity) {
        Messages message = mapper.map(entity, Messages.class);
        if(Objects.nonNull(message.getIdFromUser()))
            message.setFromUser(userService.searchById(message.getIdFromUser()));
        if(Objects.nonNull(message.getIdToUser()))
            message.setToUser(userService.searchById(message.getIdToUser()));
        return message;
    }


}
