package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.UserCredentialsDto;
import com.zackozack.service.LMS.dto.UserDto;

public interface UserService {
    UserDto register(UserCredentialsDto userDto);
    UserDto getUserById(Long id);
}
