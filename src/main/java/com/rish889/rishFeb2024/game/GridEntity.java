package com.rish889.rishFeb2024.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grids")
public class GridEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grid_id")
    private Long gridId;

    private int x;

    private int y;

    private int size;

    private Long gameId;

    private String shipId;
}
