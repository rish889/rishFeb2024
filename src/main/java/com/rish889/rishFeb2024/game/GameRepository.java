package com.rish889.rishFeb2024.game;

import com.rish889.rishFeb2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<GameEntity, Integer> {
}
