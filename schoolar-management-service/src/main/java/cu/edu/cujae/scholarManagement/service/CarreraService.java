package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.CarreraDto;

import java.util.List;

public interface CarreraService {

    List<CarreraDto> findAllCarreras();
    CarreraDto getCarreraById(int id);
    CarreraDto getCarreraByName(String name);
    CarreraDto getCarreraBySiglas(String siglas);
    CarreraDto saveCarrera(CarreraDto carreraDto);
    CarreraDto updateCarrera(CarreraDto carreraDto);
    CarreraDto deleteCarreraByName(String name);
    CarreraDto deleteCarreraById(int id);
    List<CarreraDto>findAllCarreraByFacultad(String facultad);
}
