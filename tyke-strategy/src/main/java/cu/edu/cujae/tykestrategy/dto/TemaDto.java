package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TemaDto {
    private int id;
    private String nombre;
    private String desc;
    private Collection<Object> asignaturasTemasById;
}
