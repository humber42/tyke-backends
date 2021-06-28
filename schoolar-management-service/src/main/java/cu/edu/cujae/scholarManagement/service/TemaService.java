package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.TemaDto;

import java.util.List;

public interface TemaService {

    TemaDto getTemaByNombre(String nombre);
    TemaDto getTemaById(int id);
    List<TemaDto> findAlltema();
    TemaDto saveTema(TemaDto dto);
    TemaDto updateTema(TemaDto dto);
    TemaDto deleteTemaById(int id);
    TemaDto deleteTemaByNombre(String nombre);
    List<TemaDto> getAllTemasByAsignatura(String asignatura);
}
