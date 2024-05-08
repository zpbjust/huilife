package com.hui.life.db.mapper;

import com.hui.life.db.entity.ActivitiesEntity;

import java.util.List;

public interface ActivitiesMapper {
    int insert(ActivitiesEntity activities);

    ActivitiesEntity findById(Integer id);

    List<ActivitiesEntity> findAll();

    int update(ActivitiesEntity activities);

    int delete(Integer id);
}
