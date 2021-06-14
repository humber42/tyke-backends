package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.CursoDto;

import java.util.List;

public interface CursoService {

    List<CursoDto> findAllCursos();
    CursoDto getCursoById(int id);
    CursoDto getCursoByName(String curso);
    CursoDto getCursoActive();
    CursoDto saveCurso(CursoDto curso);
    CursoDto updateCurso(CursoDto curso);
    CursoDto deleteCursoByCurso(String curso);
    CursoDto deleteCursoById(int id);

}
