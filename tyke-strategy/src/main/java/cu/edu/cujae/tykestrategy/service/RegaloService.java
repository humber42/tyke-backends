package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloRequest;
import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloRequestWithId;
import cu.edu.cujae.tykestrategy.dto.RegaloDto;

import java.util.List;
import java.util.Optional;

public interface RegaloService {
    Optional<RegaloDto> getRegaloById(long id);
    List<RegaloDto> findAllRegalo();
    int saveRegalo(RegaloRequest dto);
    Optional<RegaloDto> updateRegalo(RegaloRequestWithId dto);
    void deleteRegaloById(long id);
    void deleteRegalo(RegaloDto dto);
}
