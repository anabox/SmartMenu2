package org.example.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.dto.user.MenuUserDTO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menuUsers")
@Api(tags = "Menu User Management")
public class MenuUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "Get all menu users")
    public ResponseEntity<List<MenuUserDTO>> getAllMenuUsers() {
        List<MenuUserDTO> menuUsers = userService.getAllMenuUsers();
        return new ResponseEntity<>(menuUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get menu user by ID")
    public ResponseEntity<MenuUserDTO> getMenuUserById(@PathVariable Long id) {
        MenuUserDTO menuUser = userService.getMenuUserById(id);
        return new ResponseEntity<>(menuUser, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new menu user")
    public ResponseEntity<MenuUserDTO> createMenuUser(@RequestBody MenuUserDTO menuUserDTO) {
        MenuUserDTO createdMenuUser = userService.createMenuUser(menuUserDTO);
        return new ResponseEntity<>(createdMenuUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing menu user")
    public ResponseEntity<MenuUserDTO> updateMenuUser(@PathVariable Long id, @RequestBody MenuUserDTO menuUserDTO) {
        MenuUserDTO updatedMenuUser = userService.updateMenuUser(id, menuUserDTO);
        return new ResponseEntity<>(updatedMenuUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a menu user")
    public ResponseEntity<Void> deleteMenuUser(@PathVariable Long id) {
        userService.deleteMenuUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
