package com.studying.restapidemo.model.common;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="catalog")
@Data
public class Catalog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column
    private String name;

}

