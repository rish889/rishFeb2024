package com.rish889.rishFeb2024.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShipDto {
    String shipId;
    int size;
    int xPlayerA;
    int yPlayerA;
    int xPlayerB;
    int yPlayerB;
}
