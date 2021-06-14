package cu.edu.cujae.userservice.service;

import cu.edu.cujae.userservice.domain.Role;
import cu.edu.cujae.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAllRols() {
        return repository.getAllRols();
    }

    @Override
    public int deleteRole(long id) {
        return repository.deleteRole(id);
    }

    @Override
    public int removeRoleToUser(Long idRol, Long idUser) {
        return repository.removeRoleToUser(idRol, idUser);
    }

    @Override
    public int assignRoleToUser(Long idRol, Long idUser) {
        return repository.assignRoleToUser(idRol, idUser);
    }

    @Override
    public int saveRol(Role role) {
        return repository.saveRole(role);
    }


}
