package app.dto.users;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private int id;

    public UserDTO() {}

    public UserDTO(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
