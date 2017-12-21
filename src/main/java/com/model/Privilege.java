package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Privilege extends BaseEntity {

    private String name;

    public Privilege(String name) {
        this.name = name;
    }

}
