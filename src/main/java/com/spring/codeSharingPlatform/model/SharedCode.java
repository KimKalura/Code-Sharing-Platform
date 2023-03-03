package com.spring.codeSharingPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class SharedCode {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    String code;

    @Column
    Long allowedViewTime;

    @Column
    LocalDateTime createdDate;

    @Column
    Integer views;

    public SharedCode(){}

    public SharedCode(Long id, String code, Long allowedViewTime, LocalDateTime createdDate, Integer views) {
        this.id = id;
        this.code = code;
        this.allowedViewTime = allowedViewTime;
        this.createdDate = createdDate;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAllowedViewTime() {
        return allowedViewTime;
    }

    public void setAllowedViewTime(Long allowedViewTime) {
        this.allowedViewTime = allowedViewTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonIgnore
    public boolean isPublic(){
        return this.views == 0 && allowedViewTime == 0;
    }

    @JsonIgnore
    public Long getSecondsPassedSinceCreation(){
        return ChronoUnit.SECONDS.between(this.createdDate, LocalDateTime.now());
    }
    @JsonIgnore
    public boolean isExpired(){
        return (getSecondsPassedSinceCreation() > this.allowedViewTime) || (this.views == 0);
    }
    @JsonIgnore
    public Long getTimeLeft(){
        return this.allowedViewTime - getSecondsPassedSinceCreation();
    }
}
