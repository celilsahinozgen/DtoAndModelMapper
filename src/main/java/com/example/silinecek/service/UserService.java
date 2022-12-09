package com.example.silinecek.service;

import com.example.silinecek.dto.UserCreateDto;
import com.example.silinecek.dto.UserResponseDto;
import com.example.silinecek.dto.UserUpdateDto;
import com.example.silinecek.model.User;
import com.example.silinecek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public List<UserResponseDto> findAllUser() {

        List<User> users = userRepository.findAll();
        List<UserResponseDto> usersDto =
                users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
        return usersDto;

    }

    public UserResponseDto findByUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return modelMapper.map(optionalUser.get(),UserResponseDto.class);
        }
        return null;
    }

    public UserCreateDto createUser(UserCreateDto newUserDto) {
        User user = modelMapper.map(newUserDto, User.class);
        return modelMapper.map(userRepository.save(user), UserCreateDto.class);


    }

    public UserUpdateDto updateUser(Long id, UserUpdateDto userdto) {
        Optional<User> optionalUser = userRepository.findById(id);


        if (optionalUser.isPresent()){
            optionalUser.get().setAdres(userdto.getAdres());


            return modelMapper.map(userRepository.save(optionalUser.get()), UserUpdateDto.class);
        }
        return null;
    }

    public Boolean deleteUser(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
