package cu.edu.cujae.scholarManagement.service;


import cu.edu.cujae.scholarManagement.dto.SemestreDto;

import java.util.List;

public interface SemestreService {
    SemestreDto getSemestreById(int id);
    SemestreDto getSemestreByName(String semestre);
    SemestreDto getActiveSemestre();
    List<SemestreDto> findAllSemestre();
    SemestreDto saveSemestre(SemestreDto dto);
    SemestreDto updateSemestreDto(SemestreDto dto);
    SemestreDto deleteById(int id);
    SemestreDto deleteBySemestreName(String name);
}
