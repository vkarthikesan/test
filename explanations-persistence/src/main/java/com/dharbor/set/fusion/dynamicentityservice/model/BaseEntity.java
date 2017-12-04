package com.dharbor.set.fusion.dynamicentityservice.model;

/**
 * Created by vkarthikesan on 8/8/2017.
 */
public interface BaseEntity {
    default void onBeforeCreate() {}
    default void onBeforeSave() {}
}
