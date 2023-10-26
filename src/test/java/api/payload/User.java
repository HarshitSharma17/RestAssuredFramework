package api.payload;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Data
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class User {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("userStatus")
    private Integer userStatus;
}

