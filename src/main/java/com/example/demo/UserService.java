package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Requests.AddUserRequest;
import com.example.demo.Responses.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
//import com.example.T5.DTO.GetUser;
//import com.example.T5.DTO.GetUsers;
//import com.example.T5.DTO.UserDto;
//import com.example.T5.DTO.UserRequest;
//import com.example.T5.DTO.UserResponse;
//import com.example.T5.entities.User;
//import com.example.T5.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;

    private List<User> users = new ArrayList<>();

    public AllUsers getAllUsers() {
        AllUsers allUsers = new AllUsers();

        List<UserDTO> userDTOs = users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
        allUsers.setUsers(userDTOs);
        allUsers.setMessage("Users retrieved");
        allUsers.setSuccess(true);
        return allUsers;
    }

    public AddSuccessResponse addUser(AddUserRequest request) {
        User newUser = new User(UUID.randomUUID(), request.getFirstName(), request.getEmail());
        users.add(newUser);
        AddSuccessResponse response = new AddSuccessResponse();
        response.setMessage("User added");
        response.setSuccess(true);
        return response;
    }

    public GetUserResponse getUser(UUID id) throws Exception {
        GetUserResponse response = new GetUserResponse();

        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            response.setUser(modelMapper.map(user, UserDTO.class)); // Set the User object, not Optional<User>
            response.setSuccess(true);
        } else {
            throw new Exception("Not Found");
        }

        return response;
    }


    public UpdateSuccessResponse updateUser(UUID id, AddUserRequest request) throws Exception {
        UpdateSuccessResponse response = new UpdateSuccessResponse();

        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setFirstName(request.getFirstName());
            updatedUser.setEmail(request.getEmail());
            response.setMessage("User updated");
            response.setSuccess(true);
        } else {
            throw new Exception("Not Found");
        }

        return response;
    }


}