package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.RolProfesionalDto;

import java.util.List;
import java.util.Optional;

public interface RolProfesionalService {
    Optional<RolProfesionalDto> getRolProfesionalById(long id);
    List<RolProfesionalDto> findAllRolProfesional();
    Optional<RolProfesionalDto> saveRolProfesional(RolProfesionalDto dto);
    Optional<RolProfesionalDto> updateRolProfesional(RolProfesionalDto dto);
    void deleteRolProfesionalById(long id);
    void deleteRolProfesional(RolProfesionalDto dto);
}
