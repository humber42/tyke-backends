package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.SignatureCarreraDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.SignatureFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignatureFacultyServiceImpl implements SignatureFacultyService {

    @Autowired
    private JdbcRepository repository;

    @Override
    public int saveSignatureFaculty(SignatureCarreraDto signatureFacultyDto) {
        return repository.saveSignatureFaculty(signatureFacultyDto);
    }

    @Override
    public int deleteSignatureFaculty(long id) {
        return repository.deleteSignatureFaculty(id);
    }
}
