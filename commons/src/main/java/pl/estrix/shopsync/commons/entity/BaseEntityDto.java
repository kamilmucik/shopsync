package pl.estrix.shopsync.commons.entity;


import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//@AllArgsConstructor
public abstract class BaseEntityDto<T> extends BaseDto implements EntityDto<T> {

    private T id;

    private String label;
    private LocalDate dateCreate;
    private LocalTime timeCreate;
    private LocalDateTime lastUpdated;

    public String getLabel() {
        return label;
    }

    @Override
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}