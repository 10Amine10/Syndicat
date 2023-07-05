package org.example.repositories;

import org.example.entities.SyndiEntity;
import org.example.models.SyndiDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SyndiRepository {
    Long save(SyndiEntity s);
    Long update(SyndiEntity s);
    Boolean delete(Long id);
    List<SyndiEntity> selectAll();

}
