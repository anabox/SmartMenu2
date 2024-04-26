package org.example.dto.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;
@Data
@ApiModel(description = "DTO for MenuUser entity")
public class MenuUserDTO {
    @ApiModelProperty(notes = "Unique identifier of the menu user")
    private Long id;

    @ApiModelProperty(notes = "Username of the menu user", required = true)
    @NotBlank
    private String username;

    @ApiModelProperty(notes = "Password of the menu user", required = true)
    @NotBlank
    private String password;

    @ApiModelProperty(notes = "Roles of the menu user")
    private Set<String> roles;
}
