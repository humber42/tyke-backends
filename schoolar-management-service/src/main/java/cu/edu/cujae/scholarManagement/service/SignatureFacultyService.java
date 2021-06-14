package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.SignatureCarreraDto;

public interface SignatureFacultyService{
    int saveSignatureFaculty (SignatureCarreraDto signatureFacultyDto);
    int deleteSignatureFaculty (long id);
}
