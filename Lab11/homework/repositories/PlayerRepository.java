package com.lab11.demo.repositories;

import com.lab11.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PlayerRepository extends JpaRepository<Player,Long> {
}
