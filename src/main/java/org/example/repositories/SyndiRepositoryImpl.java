package org.example.repositories;

import org.example.entities.SyndiEntity;
import org.example.models.SyndiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value="repo1")
public class SyndiRepositoryImpl implements SyndiRepository{
    private final static Logger LOGGER= LoggerFactory.getLogger(SyndiRepositoryImpl.class);
    public SyndiRepositoryImpl(){

    }

    @Override
    public Long save(SyndiEntity entity) {
        return null;
    }

    @Override
    public Long update(SyndiEntity entity) {
        LOGGER.debug("start method update");

        return null;
    }

    @Override
    public Boolean delete(Long id) {
        LOGGER.debug("start method delete");

        return null;
    }

    @Override
    public List<SyndiEntity> selectAll() {
        LOGGER.debug("start method selectAll");

        return null;
    }
}
