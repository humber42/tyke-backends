package cu.edu.cujae.tykenotifications.api.messages;


import cu.edu.cujae.tykenotifications.constants.WebResourceKeyConstants;
import cu.edu.cujae.tykenotifications.dto.Messages;
import cu.edu.cujae.tykenotifications.service.MessageService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.BASE_API_MESSAGE)
public class MessageRestController {

    @Autowired
    MessageService service;

    @Autowired
    Mapper mapper;

    @GetMapping(WebResourceKeyConstants.MessageUrls.GET_ALL_MY_MESSAGE)
    public List<MessageResponse> getAllMyMessage(@PathVariable("id") long id) {
        return service.getAllMessageMyMessage(id)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.MessageUrls.GET_ALL_MESSAGE_FROM_USER_TO_USER, params = {"from_user", "to_user"})
    public List<MessageResponse> getAllMesssageFromUserToUser(@RequestParam("from_user") long from_user, @RequestParam("to_user") long to_user) {
        return service.getAllMessageFromUserToUser(from_user, to_user)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.MessageUrls.GET_ALL_MESSAGE_FROM_USER)
    public List<MessageResponse> getAllMessageFromUser(@PathVariable("id") long id) {
        return service.getAllMessageFromUser(id)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.MessageUrls.GET_ALL_MESSAGE_NOT_RECEIVED)
    public List<MessageResponse> getAllMessageNotReceived(@PathVariable("id") long id) {
        return service.getAllMessageNotReceived(id)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.MessageUrls.GET_MESSAGE_BY_ID)
    public MessageResponse getMessageById(@PathVariable("id") long id) {
        return service.getMessageById(id).map(this::mapping).get();
    }

    @DeleteMapping(WebResourceKeyConstants.MessageUrls.DELETE_MESSAGE_BY_ID)
    public void deleteMessageById(@PathVariable("id") long id) {
        service.deletMessageById(id);
    }

    @DeleteMapping(value = WebResourceKeyConstants.MessageUrls.DELETE_MESSAGE_JUST_FOR_ME, params = {"id_msg", "receiver"})
    public void deleteMessageJustForMe(@RequestParam("id_msg") long id, @RequestParam("receiver") boolean receiver) {
        service.deleteMessageJustForMe(id, receiver);
    }

    @PostMapping(WebResourceKeyConstants.MessageUrls.SAVE_MESSAGE)
    public MessageResponse sendMessage(@RequestBody MessageRequest request) {
        return mapping(
                service.saveMessage(mapper.map(request, Messages.class))
        );
    }

    @PutMapping(WebResourceKeyConstants.MessageUrls.MARK_AS_READ)
    public MessageResponse markAsRead(@PathVariable("id") long id) {
        return mapping(service.markAsRead(id));
    }

    @PutMapping(WebResourceKeyConstants.MessageUrls.MARK_AS_RECEIVED)
    public MessageResponse markAsReceived(@PathVariable("id") long id) {
        return mapping(service.markAsReceived(id));
    }

    private MessageResponse mapping(Messages messages) {
        return mapper.map(messages, MessageResponse.class);
    }

}
