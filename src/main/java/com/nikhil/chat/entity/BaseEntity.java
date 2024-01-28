package com.nikhil.chat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class BaseEntity {

    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";

    @JsonProperty(CREATED_AT)
    @Column(name = CREATED_AT, nullable = false, updatable = false)
    @CreatedDate
    private long createdAt;

    @JsonProperty(UPDATED_AT)
    @Column(name = UPDATED_AT)
    @LastModifiedDate
    private long updatedAt;

    public long getCreatedAt() {
        return createdAt/1000;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt*1000;
    }

    public long getUpdatedAt() {
        return updatedAt/1000;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt*1000;
    }
}
