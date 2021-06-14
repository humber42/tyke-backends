package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.FacultadDto;

import java.util.List;

public interface FacultadService {

    List<FacultadDto> findAllFaculties();
    FacultadDto getFacultadByFacultad(String facultad);
    FacultadDto getFacultadBySiglas(String siglas);
    FacultadDto getFacultadById(int id);
    FacultadDto saveFacultad(FacultadDto dto);
    FacultadDto updateFacultad(FacultadDto dto);
    FacultadDto deleteFacultadByName(String name);
    FacultadDto deleteFacultadById(int id);


}
