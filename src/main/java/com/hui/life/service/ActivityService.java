package com.hui.life.service;

import com.hui.life.db.entity.ActivitiesEntity;
import com.hui.life.db.mapper.ActivitiesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivitiesMapper activityMapper;

    public void createActivity(ActivitiesEntity activity) {
        activityMapper.insert(activity);
    }

    public void updateActivity(ActivitiesEntity activity) {
        activityMapper.update(activity);
    }

    public void deleteActivity(Integer id) {
        activityMapper.delete(id);
    }

    public ActivitiesEntity getActivityById(Integer id) {
        return activityMapper.findById(id);
    }

    public List<ActivitiesEntity> getAllActivities() {
        return activityMapper.findAll();
    }

}
