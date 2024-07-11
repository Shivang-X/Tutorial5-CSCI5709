package com.example.demo.Controllers;

import com.example.demo.Responses.*;
import com.example.demo.Requests.AddUserRequest;
import com.example.demo.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<AddSuccessResponse> addUser(@RequestBody AddUserRequest request){
        try{
            return ResponseEntity.status(200).body(userService.addUser(request));
        }catch(Exception e){
            return ResponseEntity.status(400).body(userService.addUser(request));
        }
    }

    @GetMapping("/users")
    public AllUsers getAllUsers(){
        try{
            AllUsers users = userService.getAllUsers();
            return users;
        }catch(Exception e){
            return null;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateSuccessResponse> updateUser(@PathVariable UUID id, @RequestBody AddUserRequest request){
        try{
            return ResponseEntity.status(200).body(userService.updateUser(id, request));
        }catch(Exception e){
            return ResponseEntity.status(404).body(new UpdateSuccessResponse("User not found", false));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable UUID id){
        try{
            return ResponseEntity.status(200).body(userService.getUser(id));
        }catch(Exception e){
            return ResponseEntity.status(404).body(new GetUserResponse(false, null));
        }
    }

}
