package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.AsignaturaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface AsignaturaService {

    AsignaturaDto saveAsignatura(AsignaturaDto dto);

    List<AsignaturaDto> getAllAsignaturas();

    long countAsignaturas();

    AsignaturaDto findOne(int id);

    AsignaturaDto findByNameAsignatura(String name);

    AsignaturaDto updateAsignatura(AsignaturaDto dto);

    AsignaturaDto deleteByAsignaturaName(String asignatura);

    List<AsignaturaDto> activeAsignatura();

}
