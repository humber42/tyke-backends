package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends JpaRepository<SemestreEntity,Integer> {

    SemestreEntity getSemestreEntityBySemestre(String semestre);
    SemestreEntity getSemestreEntityByActivoIsTrue();
}
