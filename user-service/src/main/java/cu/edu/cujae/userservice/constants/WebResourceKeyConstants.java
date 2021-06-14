package cu.edu.cujae.userservice.constants;

public class WebResourceKeyConstants {

    public static final String BASE_API = "/api";

    //User resources
    public static final String USER_BASE = "/user";
    public static final String FETCH_USER_BY_USERNAME = "/fetch-user/{username}";
    public static final String FETCH_ALL_USERS = "/fetch-all-users";
    public static final String SAVE ="/save";
    public static final String SEARCH = "/search";
    public static final String UPDATE = "/update";
    public static final String FETCH_BY_ID="/fetch-user-by-id/{id}";
    public static final String CHANGE_PASSWORD="/change-password";
    public static final String DELETE_USER="/delete-user";
    public static final String REGISTER="/register";

    //Role resources
    public static final String ROLE_BASE = "/role";
    public static final String FETCH_ALL_ROLE="/get-rols";
    public static final String SAVE_ROLE="/save";
    public static final String DELETE_ROLE="/delete/{id}";
    public static final String ASSIGN_ROLE="/assign-role";
    public static final String REMOVE_ROLE="/remove-role";

}
