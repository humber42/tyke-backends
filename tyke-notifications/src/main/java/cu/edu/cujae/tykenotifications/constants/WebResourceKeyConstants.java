package cu.edu.cujae.tykenotifications.constants;

public class WebResourceKeyConstants {

    public static final String BASE_API_NOTIFICATIONS = "/api/notifications";
    public static final String BASE_API_MESSAGE = "/api/message";

    public interface MessageUrls {
        String GET_ALL_MY_MESSAGE = "/get-my-messages/{id}";
        String GET_ALL_MESSAGE_FROM_USER_TO_USER = "/get-all-message-from-user-to-user";
        String GET_ALL_MESSAGE_FROM_USER = "/get-all-message-from-user/{id}";
        String GET_ALL_MESSAGE_NOT_RECEIVED = "/get-all-message-not-received/{id}";
        String GET_MESSAGE_BY_ID = "/get-message-by-id/{id}";
        String DELETE_MESSAGE_BY_ID = "/delete-message/{id}";
        String DELETE_MESSAGE_JUST_FOR_ME = "/delete-message-just-for-me";

        String SAVE_MESSAGE = "/send-message";
        String MARK_AS_RECEIVED = "/message-received/{id}";
        String MARK_AS_READ = "/message-read/{id}";
    }

    public interface NotificationsUrls {
        String FIND_ALL_MY_NEW_NOTIFICATIONS = "/find-all-new-notifications/{id}";
        String FIND_ALL_MY_NOTIFICATIONS = "/find-all-my-notifications/{id}";
        String MARK_AS_READ = "/mark-as-read/{id}";
        String NEW_NOTIFICATIONS = "/new-notification";
        String DELETE_NOTIFICATION = "/delete-notification/{id}";
    }

}
