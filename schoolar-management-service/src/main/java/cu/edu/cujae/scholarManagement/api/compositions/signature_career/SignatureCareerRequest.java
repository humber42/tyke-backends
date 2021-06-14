package cu.edu.cujae.scholarManagement.api.compositions.signature_career;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureCareerRequest {
    private Integer idFaculty;
    private Integer idSignature;
}
