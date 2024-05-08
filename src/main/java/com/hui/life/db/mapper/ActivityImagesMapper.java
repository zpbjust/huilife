package com.hui.life.db.mapper;

import com.hui.life.db.entity.ActivityImagesEntity;

import java.util.List;

public interface ActivityImagesMapper {
    int insert(ActivityImagesEntity activityImages);

    ActivityImagesEntity findById(Integer id);


    int update(ActivityImagesEntity activityImages);

    List<ActivityImagesEntity> findActivityImagesByActivityId(Integer activityId);

    int delete(Integer id);
}
