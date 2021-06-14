package cu.edu.cujae.userservice.repository;

import cu.edu.cujae.userservice.domain.Role;
import cu.edu.cujae.userservice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    int count();
    Optional<User> findById(Long id);
    User findByUsername(String name);
    int save(User user);
    int update(User user);
    int changePassword(User user);
    int deleteById(Long id);
    List<User> findAll();
    List<Role> findRolesByUserId(Long id);
    List<User> findByAttribute(String username,String fullname,String email);


}
