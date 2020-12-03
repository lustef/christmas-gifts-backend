package com.lustef.christmas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity<T_ID> implements Serializable {

//    @NotNull
    protected LocalDateTime created;

    public abstract T_ID getId();

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @PrePersist
    public void setCreated(){
        created = LocalDateTime.now();
    }
}
