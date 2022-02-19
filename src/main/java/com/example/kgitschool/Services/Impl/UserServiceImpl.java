package com.example.kgitschool.Services.Impl;

import com.example.kgitschool.Exception.ErrorIncorrectCode;
import com.example.kgitschool.Exception.UserAlreadyExist;
import com.example.kgitschool.Mappers.UserMapper;
import com.example.kgitschool.Models.dto.UserDTO;
import com.example.kgitschool.Models.dto.UserEntityDto;
import com.example.kgitschool.Models.entites.User;
import com.example.kgitschool.Services.UserService;
import com.example.kgitschool.dao.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO findByPhone(String phone){
        User user = userRepo.findByPhone(phone);
        return UserMapper.INSTANCE.toUserDto(user);

    }

    @Override
    public String save(UserEntityDto userEntityDto) {
        boolean exist = userRepo.existsByPhone(userEntityDto.getPhone());
        if (exist){
            throw new UserAlreadyExist("user not ready exist");
        }
        User user = UserMapper.INSTANCE.userDTOtoUser(userEntityDto);
        String code = generateRandomCode();
        user.setCode(code);
        user = userRepo.save(user);
        return "ваш код потверждения: "+user.getCode();
    }

    @Override
    public String confirm(UserEntityDto userConfirmDto) {
        User user = userRepo.findByPhone(userConfirmDto.getCode());
        if (user.getCode().equals(userConfirmDto.getCode())){
            throw new ErrorIncorrectCode("The entered code does not match");
        }
        user.setActivated(true);
        userRepo.save(user);
        return "регистрация прошла успешно";
    }

    private String generateRandomCode() {
        int code = (int) (Math.random()*(9999-1000+1)+1000);
        //Формула рандомного генерация чисел*(max-min+1)+min
        return String.valueOf(code);
    }
}
