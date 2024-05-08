package com.hui.life.controller;

import com.hui.life.adapt.ActivitiesApi;
import com.hui.life.db.entity.ActivitiesEntity;
import com.hui.life.model.Activities;
import com.hui.life.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActivityController implements ActivitiesApi {
    private final ActivityService activityService;

    @Override
    public ResponseEntity<Activities> createActivity(Activities activities) {
        activityService.createActivity(parserActivity(activities));
        return ResponseEntity.ok(activities);
    }

    @Override
    public ResponseEntity<Activities> getActivityById(Integer id) {
        return ResponseEntity.ok(parserActivityEntity(activityService.getActivityById(id)));
    }

    @Override
    public ResponseEntity<List<Activities>> getAllActivities() {
        List<ActivitiesEntity> activitiesEntities = activityService.getAllActivities();
        List<Activities> activities = activitiesEntities.stream().map(this::parserActivityEntity).toList();
        return ResponseEntity.ok(activities);
    }

    @Override
    public ResponseEntity<Activities> updateActivity(Integer id, Activities activities) {
        activityService.updateActivity(parserActivity(activities));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteActivity(Integer id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }

    private Activities parserActivityEntity(ActivitiesEntity activities) {
        return new Activities()
                .content(activities.getContent())
                .id(activities.getId())
                .shopId(activities.getShopId())
                .title(activities.getTitle());
    }

    private ActivitiesEntity parserActivity(Activities activities) {
        return ActivitiesEntity.builder()
                .content(activities.getContent())
                .id(activities.getId())
                .shopId(activities.getShopId())
                .title(activities.getTitle())
                .build();
    }
}
