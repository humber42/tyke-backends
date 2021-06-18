package cu.edu.cujae.userservice.service;

import cu.edu.cujae.userservice.api.UserRegister;
import cu.edu.cujae.userservice.api.UserRequest;
import cu.edu.cujae.userservice.api.UserResponse;
import cu.edu.cujae.userservice.domain.LoginClass;
import cu.edu.cujae.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public int count();

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public User findByFullname(String fullname);

    public User findByUsername(String username);

    public int save(UserRequest user);

    public int update(UserResponse user);

    public int delete(Long id);

    public int changePassword(User user);
    public int register(UserRegister userRegister);
    public String login(LoginClass loginClass);

    public boolean saveStudentInsideSchool(UserRegister register);

    public List<User> findByAttribute(String username, String full_name, String email);
    List<User> getAllUserWithRolProfesors();
}
