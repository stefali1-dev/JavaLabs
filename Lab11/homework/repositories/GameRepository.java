package com.lab11.demo.repositories;

import com.lab11.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GameRepository extends JpaRepository<Game,Long> {
}
