package com.example.demo.Responses;

import com.example.demo.DTOs.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserResponse {
    private boolean success;
    private UserDTO user;
}
