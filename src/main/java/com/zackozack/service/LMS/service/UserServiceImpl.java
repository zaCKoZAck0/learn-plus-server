package com.zackozack.service.LMS.service;


import com.zackozack.service.LMS.dto.UserCredentialsDto;
import com.zackozack.service.LMS.dto.UserDto;
import com.zackozack.service.LMS.entity.User;
import com.zackozack.service.LMS.entity.enums.Role;
import com.zackozack.service.LMS.exception.ResourceNotFoundException;
import com.zackozack.service.LMS.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDto register(UserCredentialsDto userDto) {
        log.info("Creating new user with email: {}", userDto.getEmail());
        User user = modelMapper.map(userDto, User.class);
        user.setRole(Role.USER);
        user = userRepository.save(user);
        log.info("User created with id: {}", user.getId());
        return modelMapper.map(user, UserDto.class);
    }
    @Override
    public UserDto getUserById(Long id) {
        log.info("Fetching user with id: {}", id);
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + id)
        );
        return modelMapper.map(user, UserDto.class);
    }
}
