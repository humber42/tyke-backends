package cu.edu.cujae.userservice.service;

import cu.edu.cujae.userservice.api.UserRegister;
import cu.edu.cujae.userservice.api.UserRequest;
import cu.edu.cujae.userservice.api.UserResponse;
import cu.edu.cujae.userservice.domain.*;
import cu.edu.cujae.userservice.feignClient.LoginMicroservice;
import cu.edu.cujae.userservice.feignClient.SchoolarMicroservice;
import cu.edu.cujae.userservice.repository.RoleRepository;
import cu.edu.cujae.userservice.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    LoginMicroservice loginMicroservice;
    @Autowired
    SchoolarMicroservice schoolarMicroservice;

    @Override
    public int changePassword(User user) {
        return userRepository.changePassword(user);
    }

    @Override
    public int count() {
        int count = userRepository.count();
        return count;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        Optional<User> usuario = userRepository.findById(id);
        return usuario;
    }

    @Override
    @Transactional
    public User findByFullname(String fullname) {
        return userRepository.findByFullname(fullname);
    }

    @Override
    public int save(UserRequest user) {
        User userDomain = new User();
        userDomain.setGender(user.getGender());
        userDomain.setLang(user.getLang());
        userDomain.setDob(user.getDob());
        userDomain.setEmail(user.getEmail());
        userDomain.setFullname(user.getFullname());
        userDomain.setUsername(user.getUsername());
        userDomain.setPassword(user.getPassword());
        int valorRetorno=userRepository.save(userDomain);
        Long idUser = findByUsername(user.getUsername()).getId();
        for(int i =0;i<user.getRoles().size();i++){
            long idRol = user.getRoles().get(i).getId();
            roleRepository.assignRoleToUser(idRol,idUser);
        }
        return valorRetorno;
    }

    @Override
    public int update(UserResponse user) {
        User usuarioActualizar = userRepository.findByUsername(user.getUsername());
        usuarioActualizar.setDob(user.getDob());
        usuarioActualizar.setEmail(user.getEmail());
        usuarioActualizar.setFullname(user.getFullname());
        usuarioActualizar.setGender(user.getGender());
        usuarioActualizar.setStatus(user.getStatus());
        int valueToReturn = userRepository.update(usuarioActualizar);
        for (int i = 0; i<usuarioActualizar.getRoles().size(); i++){
            roleRepository.removeRoleToUser(usuarioActualizar.getRoles().get(i).getId(),usuarioActualizar.getId());
        }
        for(int i = 0; i<user.getRoles().size();i++){
            roleRepository.assignRoleToUser(user.getRoles().get(i).getId(),user.getId());
        }

        return valueToReturn;
    }

    @Override
    public boolean saveStudentInsideSchool(UserRegister register) {
        boolean valueToReturn = true;
        try {
            FacultadDto facultadDto = schoolarMicroservice.getFacultyByName(register.getFaculty());
            User user = findByUsername(register.getUsername());
            SaveStudent saveStudent = SaveStudent.builder()
                    .idFacultad(facultadDto.getId())
                    .idUsuario(user.getId().intValue())
                    .build();
            schoolarMicroservice.saveStudent(saveStudent);
        }catch (Exception e){
            e.printStackTrace();
            valueToReturn=false;
        }
        return valueToReturn;
    }

    @Override
    public List<User> getAllUserWithRolProfesors(){
        List<User> listaProfesores = new LinkedList<>();
        for (User user:findAll()){
            List<String>roles = user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
            int i = 0;
            boolean found = false;
            while(i<roles.size()&&!found){
                if(roles.get(i).equalsIgnoreCase("Profesor")){
                    found=true;
                    listaProfesores.add(user);
                }
                i++;
            }
        }
        return listaProfesores;
    }

    @Override
    public int delete(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        List<User> listUsers= userRepository.findAll();
        return listUsers;
    }

    @Override
    public List<User> findByAttribute(String username, String fullName, String email) {
        List<User> listUsers= userRepository.findByAttribute(username, fullName, email);
        return listUsers;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
	public String login(LoginClass loginClass){
        return loginMicroservice.login(loginClass);
	}

    @Override
    public int register(UserRegister userRegister) {
        User user = mapper.map(userRegister,User.class);
        user.setLang("es");
        user.setGender("u");
        int userSaved =userRepository.save(user);
        User userRegistrado = findByUsername(userRegister.getUsername());
        roleRepository.assignRoleToUser(Integer.toUnsignedLong(1),userRegistrado.getId());
        return userSaved;
    }
}
