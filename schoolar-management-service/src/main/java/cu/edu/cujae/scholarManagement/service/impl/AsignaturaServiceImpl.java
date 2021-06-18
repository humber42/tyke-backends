package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaRequest;
import cu.edu.cujae.scholarManagement.domain.AsignaturaEntity;
import cu.edu.cujae.scholarManagement.dto.AsignaturaDto;
import cu.edu.cujae.scholarManagement.dto.SemestreAsignaturaDto;
import cu.edu.cujae.scholarManagement.dto.SignatureCarreraDto;
import cu.edu.cujae.scholarManagement.repository.AsignaturaRepository;
import cu.edu.cujae.scholarManagement.service.AsignaturaService;
import cu.edu.cujae.scholarManagement.service.SemestreAsignaturaService;
import cu.edu.cujae.scholarManagement.service.SemestreService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository repository;

    @Autowired
    Mapper mapper;

    @Autowired
    SemestreAsignaturaService serviceSemestre;
    @Autowired
    SemestreService service;

    @Override
    public AsignaturaDto saveAsignatura(AsignaturaRequest dto) {

        AsignaturaEntity entity = mapper.map(dto, AsignaturaEntity.class);
        int idAsignatura = mapper.map(repository.save(entity),AsignaturaDto.class).getId();
        int idSemestre=service.getSemestreByName(dto.getSemestre()).getId();
        serviceSemestre.saveSemestreAsignatura(SemestreAsignaturaDto
                .builder().idAsignatura(idAsignatura).idSemestre(idSemestre)
                .build());
        return findByNameAsignatura(dto.getNombre());
    }

    @Override
    public long countAsignaturas() {
        return repository.count();
    }

    @Override
    @Transactional
    public List<AsignaturaDto> getAllAsignaturas() {
        return repository.findAll().stream().map(entity -> mapper.map(entity,AsignaturaDto.class)).collect(Collectors.toList());
    }

    @Override
    public AsignaturaDto findByNameAsignatura(String name) {
        AsignaturaDto dto = mapper.map(repository.findByNombre(name),AsignaturaDto.class);
        return dto;
    }

    @Override
    public AsignaturaDto findOne(int id) {
        return mapper.map(repository.getOne(id),AsignaturaDto.class);
    }

    @Override
    public AsignaturaDto updateAsignatura(AsignaturaDto dto) {
        return mapper.map(repository.save(mapper.map(dto,AsignaturaEntity.class)),AsignaturaDto.class);
    }

    @Override
    public AsignaturaDto deleteByAsignaturaName(String asignatura) {
        AsignaturaDto asignaturaDto = findByNameAsignatura(asignatura);
        repository.deleteById(asignaturaDto.getId());
        return asignaturaDto;
    }

    @Override
    public List<AsignaturaDto> activeAsignatura() {
        return repository.findAllByActivoIsTrue().stream().map(entity -> mapper.map(entity,AsignaturaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AsignaturaDto> getAllByCareers(String carrera){
        List<AsignaturaDto> response = getAllAsignaturas().stream().filter(entity->{
            boolean asignar = false;
            for (SignatureCarreraDto signatureCareer: entity.getSignatureCareersById()
                 ) {
                if(signatureCareer.getCarreraByIdCareer().getNombre().equalsIgnoreCase(carrera)){
                    asignar=true;
                }
            }
            return asignar;
        }).collect(Collectors.toList());
        return response;
    }


}
