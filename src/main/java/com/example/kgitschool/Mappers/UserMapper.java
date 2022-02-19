package com.example.kgitschool.Mappers;

import com.example.kgitschool.Models.dto.UserDTO;
import com.example.kgitschool.Models.dto.UserEntityDto;
import com.example.kgitschool.Models.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

     UserDTO toUserDto(User user);
     User toUser(UserDTO userDTO);

    default User userDTOtoUser(UserEntityDto userEntityDto){
        User user = new User();
        user.setPhone(userEntityDto.getPhone());
        user.setCode(userEntityDto.getCode());
        return user;
    }
}
