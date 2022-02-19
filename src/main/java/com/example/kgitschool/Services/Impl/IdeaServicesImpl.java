package com.example.kgitschool.Services.Impl;

import com.example.kgitschool.Exception.UserNotActivatedException;
import com.example.kgitschool.Exception.UserNotFoundException;
import com.example.kgitschool.Mappers.IdeaMapper;
import com.example.kgitschool.Mappers.UserMapper;
import com.example.kgitschool.Models.dto.IdeaDTO;
import com.example.kgitschool.Models.dto.UserDTO;
import com.example.kgitschool.Models.entites.Idea;
import com.example.kgitschool.Services.IdeaServices;
import com.example.kgitschool.Services.UserService;
import com.example.kgitschool.dao.IdeaRepo;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IdeaServicesImpl implements IdeaServices {

    private IdeaRepo ideaRepo;
    private UserService userService;

    public IdeaServicesImpl(IdeaRepo ideaRepo, UserService userService) {
        this.ideaRepo = ideaRepo;
        this.userService = userService;
    }

    @Override
    public IdeaDTO save(IdeaDTO ideaDTO){

        UserDTO userDTO = userService.findByPhone(ideaDTO.getPhone());
        if (Objects.isNull(userDTO)){
            throw new UserNotFoundException("user with phone:"+ideaDTO.getPhone()+"\t not found");
        }
        if (!userDTO.isActivated()){
            throw new UserNotActivatedException("user not activated");
        }
        Idea idea = IdeaMapper.INSTANCE.ideaDtoToIdea(ideaDTO);
        idea.setUser(UserMapper.INSTANCE.toUser(userDTO));
        idea = ideaRepo.save(idea);

        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }

}
