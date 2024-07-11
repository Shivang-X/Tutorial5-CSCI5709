package com.example.demo.Responses;

import com.example.demo.DTOs.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllUsers {
    private String message;
    private Boolean success;
    private List<UserDTO> users;
}
