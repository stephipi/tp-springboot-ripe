package com.igs.ipi.tpspringbootripe.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootripe.model.GameModel;

@Service
public class GameService {
 public GameModel newGame()
 {
     GameModel gameModel = new GameModel();
     gameModel.setNom1("Player1");
     gameModel.setNom2("Player2");
     return gameModel;
 }
}
