package cu.edu.cujae.userservice.repository;


import cu.edu.cujae.userservice.domain.Role;

import java.util.List;

public interface RoleRepository {

    int saveRole(Role role);
    int deleteRole(long id);
    List<Role> getAllRols();

    int assignRoleToUser(Long idRole,Long idUser);
    int removeRoleToUser(Long idRole,Long idUser);
}
