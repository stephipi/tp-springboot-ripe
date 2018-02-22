package com.igs.ipi.tpspringbootripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootripe.model.GameModel;
import com.igs.ipi.tpspringbootripe.service.GameService;

@Controller
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        GameModel gameModel = gameService.newGame();
        ModelAndView modelAndView = new ModelAndView("game");
        modelAndView.addObject(gameModel);
        return modelAndView;
    }
}
