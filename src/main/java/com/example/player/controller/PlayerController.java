package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.player.model.Player;
import com.example.player.service.PlayerH2Service;

@RestController
public class PlayerController{

    @Autowired
    public PlayerH2Service playerH2Service;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return playerH2Service.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
            return playerH2Service.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerH2Service.addPlayer(player);
        
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,@RequestBody Player player){
        return playerH2Service.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerH2Service.deletePlayer(playerId);
    }

}