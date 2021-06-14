package cu.edu.cujae.userservice.service;

import cu.edu.cujae.userservice.domain.Role;

import java.util.List;

public interface RoleService {

     List<Role> getAllRols();
     int saveRol(Role role);
     int deleteRole(long id);
     int assignRoleToUser(Long idRol,Long idUser);
     int removeRoleToUser(Long idRol,Long idUser);
}
