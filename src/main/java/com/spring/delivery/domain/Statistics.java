package com.spring.delivery.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;

    @OneToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    public Statistics(int count, Menu menu) {
        this.count = count;
        this.menu = menu;
    }
}
