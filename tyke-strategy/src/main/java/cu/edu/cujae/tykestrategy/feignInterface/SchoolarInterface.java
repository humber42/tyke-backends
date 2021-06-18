package cu.edu.cujae.tykestrategy.feignInterface;

import cu.edu.cujae.tykestrategy.constants.MicroservicesConstants;
import cu.edu.cujae.tykestrategy.dto.CarreraDto;
import cu.edu.cujae.tykestrategy.dto.GrupoDto;
import cu.edu.cujae.tykestrategy.dto.TemaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = MicroservicesConstants.CarreraMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroservicesConstants.BASE_SCHOOLAR)
public interface SchoolarInterface {

    @RequestMapping(value = MicroservicesConstants.CarreraMicroserviceConstants.FETCH_CARRERA_BY_ID,params = "id")
    CarreraDto searchCarreraById(@RequestParam("id")int id);

    @RequestMapping(value = MicroservicesConstants.TemaMicroserviceConstants.FETCH_TEMA_BY_ID,params = "id")
    TemaDto seatchTemaById(@RequestParam("id") int id);

    @RequestMapping(value = MicroservicesConstants.GrupoMicroserviceConstants.FETCH_GRUPO_BY_ID,params = "id")
    GrupoDto searchGrupoById(@RequestParam("id") int id);

}
