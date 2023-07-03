package com.app.springbootmysql.topic;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.Entity;
@Entity
public class Topic {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Topic(){

    }
    public Topic(Long id,String name,String description) {
        super();
        this.id = id;
        this.name=name;
        this.description=description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
