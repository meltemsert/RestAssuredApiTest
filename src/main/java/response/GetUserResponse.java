package response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetUserResponse {
    String userName;
    String password;
}
