package org.example.dto.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.dto.dish.OrderDTO;

import java.util.Set;
@Data
@ApiModel(description = "DTO for UserWaiter entity")
public class UserWaiterDTO {
    @ApiModelProperty(notes = "Unique identifier of the user waiter")
    private Long id;

    @ApiModelProperty(notes = "Username of the user waiter", required = true)
    @NotBlank
    private String username;

    @ApiModelProperty(notes = "Password of the user waiter", required = true)
    @NotBlank
    private String password;

    @ApiModelProperty(notes = "Roles of the user waiter")
    private Set<String> roles;

    @ApiModelProperty(notes = "Orders associated with the user waiter")
    private Set<OrderDTO> orders;
}
