package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto getUserById(Long id);
}
