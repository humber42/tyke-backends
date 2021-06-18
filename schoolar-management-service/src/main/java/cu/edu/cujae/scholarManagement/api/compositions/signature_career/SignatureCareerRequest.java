package cu.edu.cujae.scholarManagement.api.compositions.signature_career;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureCareerRequest {
    private Integer idCareer;
    private Integer idSignature;
}
