package cu.edu.cujae.questionservice.api.feedback;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FeedbackRequest {
    private String feedback;
    private Long idPregunta;
    private String username;
}
