package com.michel.mapper;

import com.michel.dto.PessoaDTO;
import com.michel.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
    Pessoa toModel(PessoaDTO DTO);
    PessoaDTO toDTO(Optional<Pessoa> entity);
}
