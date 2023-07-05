package org.example.services;

import org.example.models.SyndiDTO;

import java.util.List;

public interface SyndiService {
    Long save(SyndiDTO s);
    Long update(SyndiDTO s);
    Boolean delete(Long id);
    List<SyndiDTO> selectAll();
}
