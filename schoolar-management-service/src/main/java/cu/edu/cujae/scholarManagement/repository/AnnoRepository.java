package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.AnnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnoRepository extends JpaRepository<AnnoEntity,Integer> {

    AnnoEntity findAnnoEntityByAnno(String anno);


}
