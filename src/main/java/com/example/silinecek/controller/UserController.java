package com.example.silinecek.controller;

import com.example.silinecek.dto.UserCreateDto;
import com.example.silinecek.dto.UserResponseDto;
import com.example.silinecek.dto.UserUpdateDto;
import com.example.silinecek.model.User;
import com.example.silinecek.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("findall")
    public ResponseEntity<List<UserResponseDto>> findAllUser() {
        List<UserResponseDto> listUser = userService.findAllUser();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<UserResponseDto> findByUser(@PathVariable Long id){
        UserResponseDto user = userService.findByUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<UserCreateDto> createUser(@RequestBody UserCreateDto newUserDto){
        UserCreateDto resultUser = userService.createUser(newUserDto);
        return ResponseEntity.ok(resultUser);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserUpdateDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userdto) {
        UserUpdateDto resultUser = userService.updateUser(id,userdto);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }


}
