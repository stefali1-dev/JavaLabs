package com.lab11.demo.controllers;

import java.util.List;

import com.lab11.demo.entities.Game;
import com.lab11.demo.entities.Player;
import com.lab11.demo.repositories.GameRepository;
import com.lab11.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/lab11")
public class GameController {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    @Autowired
    public GameController(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    //  * Retrieve a list of all players
    @GetMapping("/players/get-all")
    public List<Player> getPlayers() {
        return playerRepository.findAll();

    }
    // Add a new player
    @PostMapping("/players/add")
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    // Update the name of a player
    @PutMapping("/players/update-name/{id}")
    public Player updatePlayerName(@PathVariable Long id, @RequestBody String newName) throws ChangeSetPersister.NotFoundException{
        Player player = playerRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        player.setName(newName);
        return playerRepository.save(player);
    }

    // Delete a player
    @DeleteMapping("/players/delete/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        playerRepository.delete(player);
        return ResponseEntity.noContent().build();
    }

    // Retrieve a list of all players
    @GetMapping("/games/get-all")
    public List<Game> getGames() {
        return gameRepository.findAll();

    }
}
