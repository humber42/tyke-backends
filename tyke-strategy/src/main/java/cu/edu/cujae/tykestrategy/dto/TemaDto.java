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
    private long id;
    private String nombre;
}
