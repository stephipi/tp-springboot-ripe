package com.igs.ipi.tpspringbootripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootripe.model.GameModel;
import com.igs.ipi.tpspringbootripe.service.GameService;
import com.igs.ipi.tpspringbootripe.service.PartieEnCoursService;

@Controller
public class GameController {

    private GameService gameService;
    private PartieEnCoursService partieEnCours;

    public GameController(GameService gameService, PartieEnCoursService partieEnCours) {
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }
    
    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        GameModel gameModel = gameService.newGame();
        ModelAndView modelAndView = new ModelAndView("game");
        modelAndView.addObject("game", gameModel);
        return modelAndView;
    }

    @RequestMapping("/game")
    public ModelAndView game() {
        GameModel gameModel = partieEnCours.getGameModel();
        ModelAndView modelAndView = new ModelAndView("game");
        modelAndView.addObject("game", gameModel);
        return modelAndView;
    }

}
