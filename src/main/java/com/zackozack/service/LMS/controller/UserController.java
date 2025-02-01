package com.zackozack.service.LMS.controller;

import com.zackozack.service.LMS.dto.CourseDto;
import com.zackozack.service.LMS.dto.UserCredentialsDto;
import com.zackozack.service.LMS.dto.UserDto;
import com.zackozack.service.LMS.service.CourseService;
import com.zackozack.service.LMS.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserCredentialsDto userDto) {
        UserDto newUser = userService.register(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
