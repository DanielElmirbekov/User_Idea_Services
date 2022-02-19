package com.example.kgitschool.Controllers;

import com.example.kgitschool.Models.dto.UserEntityDto;
import com.example.kgitschool.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserEntityDto userEntityDto){

        return userService.save(userEntityDto);

    }
    @PostMapping("/confirm")
    public String confirmUserCode(@RequestBody UserEntityDto userConfirmDto){
        return userService.confirm(userConfirmDto);

    }
}
