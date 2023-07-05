package org.example.mappers;

import org.example.entities.SyndiEntity;
import org.example.models.SyndiDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "mapper1")
public class SyndiMapper {

    public SyndiEntity syndiDtoToEntity(SyndiDTO dto) {
        SyndiEntity syndiEntity = new SyndiEntity();
        syndiEntity.setId(dto.getId());
        syndiEntity.setName(dto.getName());
        return syndiEntity;
    }
    public SyndiDTO syndiEntityToDto(SyndiEntity syndiEntity) {
        SyndiDTO dto = new SyndiDTO();
        dto.setId(syndiEntity.getId());
        dto.setName(syndiEntity.getName());
        return dto;
    }
    public List<SyndiDTO> syndiEntiesToDtos(List<SyndiEntity> syndiEntities) {
        if (syndiEntities!=null&&!syndiEntities.isEmpty()){
            return syndiEntities.stream().map(syndiEntity -> syndiEntityToDto(syndiEntity)).collect(Collectors.toList());
        }else {
            return new ArrayList<>();
        }
    }

}
