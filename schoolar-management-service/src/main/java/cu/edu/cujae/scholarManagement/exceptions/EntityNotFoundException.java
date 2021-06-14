package cu.edu.cujae.scholarManagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {

    private ErrorResponse response;

    public EntityNotFoundException(String message,String developerMessagge){
        super(message);
        this.getResponse().setDeveloperMessage(developerMessagge);
        this.getResponse().setErrorMessage(message);
        this.getResponse().setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
