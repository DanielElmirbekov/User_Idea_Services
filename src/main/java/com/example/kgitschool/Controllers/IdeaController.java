package com.example.kgitschool.Controllers;

import com.example.kgitschool.Models.dto.IdeaDTO;
import com.example.kgitschool.Services.IdeaServices;
import com.example.kgitschool.dao.UserIdeasDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/idea")
public class IdeaController {

    private IdeaServices ideaServices;

    public IdeaController(IdeaServices ideaServices) {
        this.ideaServices = ideaServices;
    }
    @PostMapping("/save")
    public IdeaDTO save(@RequestBody IdeaDTO ideaDTO){return ideaServices.save(ideaDTO);}
    @GetMapping("/user/get")
    public List<UserIdeasDto>getAllUserIdeas(@RequestParam String phone){
        return null;
    }

}
