package com.dharbor.set.fusion.dynamicentityservice.model.eventlistener;

import com.dharbor.set.fusion.dynamicentityservice.model.BaseEntity;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

/**
 * Created by vkarthikesan on 8/8/2017.
 */
@Component
public class EntityEventListener<T extends BaseEntity> extends AbstractRepositoryEventListener<T> {

    @Override
    protected void onBeforeCreate(T entity) {
        entity.onBeforeCreate();
    }

    @Override
    protected void onBeforeSave(T entity) {
        entity.onBeforeSave();
    }
}
