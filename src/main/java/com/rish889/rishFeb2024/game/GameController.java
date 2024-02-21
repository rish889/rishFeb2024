package com.rish889.rishFeb2024.game;

import com.rish889.rishFeb2024.config.ApiPaths;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @PostMapping(ApiPaths.GAMES)
    public @ResponseBody ResponseEntity<String> initGame(@Valid @RequestBody GameInitDto requestDto) {
        GameEntity gameEntity = GameEntity.builder()
                .seaArea(requestDto.getSeaArea())
                .fireStrategy(1)
                .build();
        GameEntity savedGameEntity = gameRepository.save(gameEntity);

        return ResponseEntity.ok("");
    }

    @PostMapping(ApiPaths.SHIPS)
    public @ResponseBody ResponseEntity<String> addShip(@PathVariable Long gameId, @Valid @RequestBody AddShipDto requestDto) {
        //handling size one now
        GridEntity gridEntity = GridEntity.builder()
                .gameId(gameId)
                .shipId(requestDto.shipId)
                .size(requestDto.size)
                .
                .build();

        return ResponseEntity.ok("");
    }
}
