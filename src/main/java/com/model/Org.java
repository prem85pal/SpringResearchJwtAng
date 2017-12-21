package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Org extends BaseEntity {

    private String name;

}
