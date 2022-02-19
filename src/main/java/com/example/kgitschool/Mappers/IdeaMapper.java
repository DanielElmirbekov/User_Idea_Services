package com.example.kgitschool.Mappers;

import com.example.kgitschool.Models.dto.IdeaDTO;
import com.example.kgitschool.Models.entites.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE = Mappers.getMapper(IdeaMapper.class);
    //Idea ideaDtoToIdea(IdeaDTO ideaDTO);
    //IdeaDTO ideaToIdeaDto(Idea idea);

    @Mapping(source = "ideaDTO.body",target = "text")

    Idea ideaDtoToIdea(IdeaDTO ideaDTO);
    IdeaDTO ideaToIdeaDto(Idea idea);
}
