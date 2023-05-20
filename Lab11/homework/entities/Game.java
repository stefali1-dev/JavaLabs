package com.lab11.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Information about the game
 */
@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
public class Game {
    @Id
    private Long id;

    private String player1;
    private String player2;

    private String winner;

}
