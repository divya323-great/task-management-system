package com.divya.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private String remarks;

    private String createdByName;
    private String createdById;

    private String lastUpdatedByName;
    private String lastUpdatedById;

    private LocalDateTime createdOn;
    private LocalDateTime lastUpdatedOn;

    public Task(){}

    // Automatically set timestamps
    @PrePersist
    public void onCreate(){
        createdOn = LocalDateTime.now();
        lastUpdatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        lastUpdatedOn = LocalDateTime.now();
    }

    // GETTERS & SETTERS

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }

    public LocalDate getDueDate(){ return dueDate; }
    public void setDueDate(LocalDate dueDate){ this.dueDate = dueDate; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }

    public String getRemarks(){ return remarks; }
    public void setRemarks(String remarks){ this.remarks = remarks; }

    public String getCreatedByName(){ return createdByName; }
    public void setCreatedByName(String createdByName){ this.createdByName = createdByName; }

    public String getCreatedById(){ return createdById; }
    public void setCreatedById(String createdById){ this.createdById = createdById; }

    public String getLastUpdatedByName(){ return lastUpdatedByName; }
    public void setLastUpdatedByName(String lastUpdatedByName){ this.lastUpdatedByName = lastUpdatedByName; }

    public String getLastUpdatedById(){ return lastUpdatedById; }
    public void setLastUpdatedById(String lastUpdatedById){ this.lastUpdatedById = lastUpdatedById; }

    public LocalDateTime getCreatedOn(){ return createdOn; }
    public void setCreatedOn(LocalDateTime createdOn){ this.createdOn = createdOn; }

    public LocalDateTime getLastUpdatedOn(){ return lastUpdatedOn; }
    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn){ this.lastUpdatedOn = lastUpdatedOn; }

}