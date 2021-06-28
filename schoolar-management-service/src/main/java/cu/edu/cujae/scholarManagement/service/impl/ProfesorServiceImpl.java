package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.api.profesor.ProfesorRequest;
import cu.edu.cujae.scholarManagement.api.profesor.ProfesorRequestToUpdate;
import cu.edu.cujae.scholarManagement.domain.ProfesorEntity;
import cu.edu.cujae.scholarManagement.dto.*;
import cu.edu.cujae.scholarManagement.feignInterface.UserInterface;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.repository.ProfesorRepository;
import cu.edu.cujae.scholarManagement.service.FacultadService;
import cu.edu.cujae.scholarManagement.service.ProfesorService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
    @Autowired
    FacultadService facultadService;
    @Autowired
    JdbcRepository jdbcRepository;

    @Override
    public List<ProfesorDto> findAllProfesors() {
        return repository.findAll().stream().map(this::mappear).collect(Collectors.toList());
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
    public ProfesorDto saveProfesor(ProfesorRequest dto) {
        int idfacultad = facultadService.getFacultadByFacultad(dto.getFacultad()).getId();
        int idUsuario = getUser.searchByFullname(dto.getUsuario()).getId().intValue();
        ProfesorDto profe =ProfesorDto.builder()
                .idUsuario(idUsuario)
                .gradoCientifico(dto.getGradoCientifico())
                .gradoDocente(dto.getGradoDocente())
                .idFacultad(idfacultad)
                .telefono(dto.getTelefono()).build();
        return mappear(repository.save(mapper.map(profe, ProfesorEntity.class)));
    }

    @Override
    public ProfesorDto updateProfesor(ProfesorRequestToUpdate dto) {
        int facultadId= facultadService.getFacultadByFacultad(dto.getFacultad()).getId();
        jdbcRepository.updateProfesor(dto,facultadId);
        return getProfesorById(dto.getId());
    }

    private ProfesorDto mappear(ProfesorEntity entity){
        UsuarioDto dto = getUser.searchById(entity.getIdUsuario());
        ProfesorDto profesorDto = mapper.map(entity, ProfesorDto.class);
        profesorDto.setUsuario(dto);
        return profesorDto;
    }


    @Override
    public ProfesorAsignaturas getProfesorAndSignatures(int idUsuario) {
        //Se recupera el profesor
        ProfesorDto profesorDto = repository.findByIdUsuario(idUsuario).map(this::mappear).get();
        //Se obtiene la lista de los nombres de las asignaturas
        LinkedList<String> asignaturas = profesorDto.getAsignaturaProfesorGruposById().stream()
                .map(AsignaturaProfesorGrupoDto::getAsignaturaByIdAsignatura)
                .map(AsignaturaDto::getNombre).collect(Collectors.toCollection(LinkedList::new));

        return ProfesorAsignaturas.builder()
                .idProfesor(profesorDto.getId())
                .asignaturas(asignaturas).build();
    }
}
