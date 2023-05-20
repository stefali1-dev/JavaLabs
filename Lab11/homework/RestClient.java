package com.lab11.demo;

import com.lab11.demo.entities.Game;
import com.lab11.demo.entities.Player;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.TimeUnit;

public class RestClient {

    private static final String BASE_URL = "http://localhost:8082/api/lab11"; // Replace with your server's base URL

    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();

        // Get list of players
        ResponseEntity<Player[]> response = restTemplate.getForEntity(BASE_URL + "/players/get-all", Player[].class);
        Player[] players = response.getBody();
        System.out.println("List of players:");
        for (Player player : players) {
            System.out.println(player);
        }

        TimeUnit.SECONDS.sleep(1);

        // Add a new player
        Player newPlayer = new Player(789L, "John");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Player> request = new HttpEntity<>(newPlayer, headers);
        ResponseEntity<String> addResponse = restTemplate.postForEntity(BASE_URL + "/players/add", request, String.class);
        System.out.println("Add player response: " + addResponse.getBody());

        TimeUnit.SECONDS.sleep(1);

        // Update player name
        Long playerIdToUpdate = 789L;
        String updatedName = "John Smith";
        restTemplate.put(BASE_URL + "/players/update-name/" + playerIdToUpdate, updatedName);
        System.out.println("Player name updated successfully");

        TimeUnit.SECONDS.sleep(1);

        // Delete a player
        Long playerIdToDelete = 789L;
        restTemplate.delete(BASE_URL + "/players/delete/" + playerIdToDelete);
        System.out.println("Player deleted successfully");

        TimeUnit.SECONDS.sleep(1);

        // Get list of games
        ResponseEntity<Game[]> gamesResponse = restTemplate.getForEntity(BASE_URL + "/games/get-all", Game[].class);
        Game[] games = gamesResponse.getBody();
        System.out.println("List of games:");
        for (Game game : games) {
            System.out.println(game);
        }
    }
}