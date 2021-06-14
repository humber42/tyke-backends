package cu.edu.cujae.userservice.api;

import cu.edu.cujae.userservice.domain.Role;
import cu.edu.cujae.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cu.edu.cujae.userservice.constants.WebResourceKeyConstants.*;

@RestController
@RequestMapping(BASE_API+ROLE_BASE)
public class RoleRestController {

    @Autowired
    private RoleService service;

    @GetMapping(FETCH_ALL_ROLE)
    public List<Role> getAllRols(){
        return service.getAllRols();
    }

    @PostMapping(SAVE_ROLE)
    public int saveRole(@RequestBody Role role){
        return service.saveRol(role);
    }

    @PostMapping(ASSIGN_ROLE)
    public int assignRole(@RequestBody UserRoleRequest request){
        return service.assignRoleToUser(request.getIdRole(),request.getIdUser());
    }

    @DeleteMapping(DELETE_ROLE)
    public int deleteRole(@PathVariable("id") long id){
        return service.deleteRole(id);
    }

    @DeleteMapping(REMOVE_ROLE)
    public int removeRole(@RequestBody UserRoleRequest request){
        return service.removeRoleToUser(request.getIdRole(), request.getIdUser());
    }
}
