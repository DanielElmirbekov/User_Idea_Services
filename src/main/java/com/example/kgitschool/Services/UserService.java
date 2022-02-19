package com.example.kgitschool.Services;

import com.example.kgitschool.Models.dto.UserDTO;
import com.example.kgitschool.Models.dto.UserEntityDto;

public interface UserService {

    UserDTO findByPhone(String phone);

    String save(UserEntityDto userDtos);

    String confirm(UserEntityDto userConfirmDto);
}
