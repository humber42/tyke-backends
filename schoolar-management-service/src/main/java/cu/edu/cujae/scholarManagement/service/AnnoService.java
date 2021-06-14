package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.AnnoDto;

import java.util.List;

public interface AnnoService {

    AnnoDto getAnnoById(int id);
    List<AnnoDto> findAllAnno();
    AnnoDto saveAnno(AnnoDto annoDto);
    AnnoDto findAnnoByName(String name);
    void deleteAnno(int id);
    AnnoDto deleteAnnoByName(String name);
    AnnoDto update(AnnoDto dto);

}
