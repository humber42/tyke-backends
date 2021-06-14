package cu.edu.cujae.authservice.service;

import cu.edu.cujae.authservice.domain.LogsEntity;
import cu.edu.cujae.authservice.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private LogsRepository repository;

    public void saveLog(LogsEntity entity) {
        repository.save(entity);
    }

}
