package cu.edu.cujae.tykestrategy.api.models.jugador_desafio;

import cu.edu.cujae.tykestrategy.dto.UserDto;

public class JugadorDesafioWithoutEstrategia {
    private long idJugadorDesafio;
    //Usuarios
    private UserDto jugadorDesafiante;
    private UserDto jugadorDesafiado;
    //Valores de estado
    private Boolean desafioEntregado;
    private Boolean desafioConfirmado;
}
