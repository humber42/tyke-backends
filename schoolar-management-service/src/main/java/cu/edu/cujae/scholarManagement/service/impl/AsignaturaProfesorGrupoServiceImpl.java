package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo.AsignaturaProfesorListGroupRequest;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponse;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorGrupoDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.AsignaturaProfesorGrupoService;
import cu.edu.cujae.scholarManagement.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaProfesorGrupoServiceImpl implements AsignaturaProfesorGrupoService {

    @Autowired
    JdbcRepository repository;
    @Autowired
    AsignaturaService asignaturaService;


    @Override
    public int saveAsignaturaProfesorGrupo(AsignaturaProfesorGrupoDto dto) {
        return repository.saveAsignaturaProfesorGrupo(dto);
    }

    @Override
    public int saveByListGrupoAsignaturaProfesor(AsignaturaProfesorListGroupRequest request) {
        int value=0;
        int idAsignatura = asignaturaService.findByNameAsignatura(request.getAsingnatura()).getId();
        for (GrupoResponse response: request.getGruposList()){
           value= repository.saveAsignaturaProfesorGrupo(AsignaturaProfesorGrupoDto
                    .builder()
                    .idAsignatura(idAsignatura)
                    .idProfesor(request.getIdProfesor())
                    .idGrupo(response.getId().intValue())
                    .build());
        }
        return value;
    }
}
