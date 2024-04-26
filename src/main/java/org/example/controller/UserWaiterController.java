package org.example.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.dto.user.UserWaiterDTO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userWaiters")
@Api(tags = "User Waiter Management")
public class UserWaiterController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "Get all user waiters")
    public ResponseEntity<List<UserWaiterDTO>> getAllUserWaiters() {
        List<UserWaiterDTO> userWaiters = userService.getAllUserWaiters();
        return new ResponseEntity<>(userWaiters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user waiter by ID")
    public ResponseEntity<UserWaiterDTO> getUserWaiterById(@PathVariable Long id) {
        UserWaiterDTO userWaiter = userService.getUserWaiterById(id);
        return new ResponseEntity<>(userWaiter, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new user waiter")
    public ResponseEntity<UserWaiterDTO> createUserWaiter(@RequestBody UserWaiterDTO userWaiterDTO) {
        UserWaiterDTO createdUserWaiter = userService.createUserWaiter(userWaiterDTO);
        return new ResponseEntity<>(createdUserWaiter, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing user waiter")
    public ResponseEntity<UserWaiterDTO> updateUserWaiter(@PathVariable Long id, @RequestBody UserWaiterDTO userWaiterDTO) {
        UserWaiterDTO updatedUserWaiter = userService.updateUserWaiter(id, userWaiterDTO);
        return new ResponseEntity<>(updatedUserWaiter, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a user waiter")
    public ResponseEntity<Void> deleteUserWaiter(@PathVariable Long id) {
        userService.deleteUserWaiter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
