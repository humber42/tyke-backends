package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloRequest;
import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloRequestWithId;
import cu.edu.cujae.tykestrategy.domain.RegaloEntity;
import cu.edu.cujae.tykestrategy.dto.OtorgamientoDto;
import cu.edu.cujae.tykestrategy.dto.RegaloDto;
import cu.edu.cujae.tykestrategy.dto.TipoRegaloDto;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.RegaloRepository;
import cu.edu.cujae.tykestrategy.service.OtorgamientoService;
import cu.edu.cujae.tykestrategy.service.RegaloService;
import cu.edu.cujae.tykestrategy.service.TipoRegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegaloServiceImpl implements RegaloService {

    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    RegaloRepository repository;
    @Autowired
    Mapper mapper;
    @Autowired
    TipoRegaloService tipoRegaloService;
    @Autowired
    OtorgamientoService otorgamientoService;


    @Override
    public int saveRegalo(RegaloRequest request) {
        Long tipoRegaloDto = tipoRegaloService.getByName(request.getIdTipoRegalo()).get().getIdTipoRegalo();
        Long otorgamiento = otorgamientoService.getByName(request.getIdOtorgamiento()).get().getIdOtorgamiento();
        return saveRepository.saveRegalo(RegaloDto.builder().idOtorgamiento(otorgamiento)
                .idTipoRegalo(tipoRegaloDto)
                .descripcion(request.getDescripcion())
                .build());
    }

    @Override
    public List<RegaloDto> findAllRegalo() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RegaloDto> getRegaloById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<RegaloDto> updateRegalo(RegaloRequestWithId request) {
        long idTipoRegalo = tipoRegaloService.getByName(request.getIdTipoRegalo()).get().getIdTipoRegalo();
        long idOtorgamiento = otorgamientoService.getByName(request.getIdOtorgamiento()).get().getIdOtorgamiento();
        RegaloDto dto = RegaloDto.builder()
                .descripcion(request.getDescripcion())
                .idRegalo(request.getIdRegalo())
                .otorgamiento(OtorgamientoDto.builder().idOtorgamiento(idOtorgamiento).build())
                .tipoRegalo(TipoRegaloDto.builder().idTipoRegalo(idTipoRegalo).build())
                .build();
        RegaloEntity entity=mapper.map(dto, RegaloEntity.class);
        return Optional
                .of(repository.saveAndFlush(entity))
                .map(this::mapperDto);
    }

    @Override
    public void deleteRegalo(RegaloDto dto) {
        repository.delete(mapper.map(dto, RegaloEntity.class));
    }

    @Override
    public void deleteRegaloById(long id) {
        repository.deleteById(id);
    }

    private RegaloDto mapperDto(RegaloEntity entity) {
        return mapper.map(entity, RegaloDto.class);
    }
}

