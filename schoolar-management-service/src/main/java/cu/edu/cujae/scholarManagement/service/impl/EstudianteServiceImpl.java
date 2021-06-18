package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.EstudianteEntity;
import cu.edu.cujae.scholarManagement.dto.EstudianteDto;
import cu.edu.cujae.scholarManagement.dto.UsuarioDto;
import cu.edu.cujae.scholarManagement.feignInterface.UserInterface;
import cu.edu.cujae.scholarManagement.repository.EstudianteRepository;
import cu.edu.cujae.scholarManagement.service.EstudianteService;
import cu.edu.cujae.scholarManagement.service.FacultadService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository repository;

    @Autowired
    Mapper mapper;

    @Autowired
    UserInterface getUser;

    @Autowired
    FacultadService facultyService;

    @Override
    public EstudianteDto deleteEstudianteById(int id) {
        EstudianteDto dto = getEstudianteById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public List<EstudianteDto> getAllStudentsByFacultad(String nameFacultad) {
        int id = facultyService.getFacultadByFacultad(nameFacultad).getId();
        return repository.findAll()
                .stream().filter(estudianteEntity -> estudianteEntity.getIdFacultad()==id)
                .map(this::mappear)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteDto getEstudianteById(int id) {
        return repository.findById(id).map(this::mappear).get();
    }



    @Override
    public EstudianteDto saveEstudiante(EstudianteDto estudianteDto) {
        EstudianteEntity entity = mapper.map(estudianteDto, EstudianteEntity.class);
        return mappear(repository.saveAndFlush(entity));
    }

    @Override
    public EstudianteDto updateEstudiante(EstudianteDto estudianteDto) {
        EstudianteEntity entity = mapper.map(estudianteDto, EstudianteEntity.class);
        return mappear(repository.saveAndFlush(entity));
    }

    @Override
    public List<EstudianteDto> findAllEstudents() {
        return repository.findAll().stream().map(this::mappear).collect(Collectors.toList());
    }

    private EstudianteDto mappear(EstudianteEntity entity){
        UsuarioDto usuarioDto = getUser.searchById(entity.getIdUsuario());
        EstudianteDto estudianteDto = mapper.map(entity, EstudianteDto.class);
        estudianteDto.setUsuario(usuarioDto);
        return estudianteDto;
    }
}
