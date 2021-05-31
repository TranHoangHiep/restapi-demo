package com.studying.restapidemo.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}

