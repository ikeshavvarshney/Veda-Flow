package vedaflow.vedaflow.DTO;

import lombok.Data;

@Data
public class RegisterBody {
    private String username;
    private String email;
    private String password;
    private String role="User";

}
