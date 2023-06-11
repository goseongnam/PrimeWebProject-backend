package com.spring.delivery.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private Address address;
    private String phoneNum;
    private String runTime;

    @OneToMany(mappedBy="store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
