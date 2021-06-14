package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.ProfesorEntity;
import cu.edu.cujae.scholarManagement.dto.ProfesorDto;
import cu.edu.cujae.scholarManagement.dto.UsuarioDto;
import cu.edu.cujae.scholarManagement.feignInterface.UserInterface;
import cu.edu.cujae.scholarManagement.repository.ProfesorRepository;
import cu.edu.cujae.scholarManagement.service.ProfesorService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository repository;
    @Autowired
    Mapper mapper;
    @Autowired
    UserInterface getUser;

    @Override
    public List<ProfesorDto> findAllProfesors() {
        return repository.findAll().stream().map(profesorEntity -> mapper.map(profesorEntity, ProfesorDto.class)).collect(Collectors.toList());
    }



    @Override
    public ProfesorDto deleteById(int id) {
        ProfesorDto dto = getProfesorById(id);
        repository.deleteById(id);
        return dto;
    }




    @Override
    public ProfesorDto getProfesorById(int id) {
        return repository.findById(id).map(this::mappear).get();
    }

    @Override
    public ProfesorDto saveProfesor(ProfesorDto dto) {
        return mappear(repository.save(mapper.map(dto, ProfesorEntity.class)));
    }

    @Override
    public ProfesorDto updateProfesor(ProfesorDto dto) {
        return mappear(repository.saveAndFlush(mapper.map(dto, ProfesorEntity.class)));
    }

    private ProfesorDto mappear(ProfesorEntity entity){
        UsuarioDto dto = getUser.searchById(entity.getId_usuario());
        ProfesorDto profesorDto = mapper.map(entity, ProfesorDto.class);
        profesorDto.setUsuario(dto);
        return profesorDto;
    }
}
