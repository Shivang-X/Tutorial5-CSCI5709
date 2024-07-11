package com.example.demo.Responses;

import com.example.demo.DTOs.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUsersResponse {
    private String success;
    private List<UserDTO> user;
}
