package com.igs.ipi.tpspringbootripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootripe.model.GameModel;
import com.igs.ipi.tpspringbootripe.service.GameService;
import com.igs.ipi.tpspringbootripe.service.PartieEnCours;

@Controller
public class GameController {

    private GameService gameService;
    private PartieEnCours partieEnCours;

    public GameController(GameService gameService, PartieEnCours partieEnCours) {
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }
    
    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        ModelAndView modelAndView = new ModelAndView("game");
        GameModel gameModel = gameService.newGame();
        modelAndView.addObject("game", gameModel);
        return modelAndView;
    }

    @RequestMapping("/game")
    public ModelAndView game() {
        ModelAndView modelAndView = new ModelAndView("game");
        GameModel gameModel = partieEnCours.getGameModel();
        modelAndView.addObject("game", gameModel);
        return modelAndView;
    }

    @RequestMapping(value="/game/drop/{index}")
    public ModelAndView drop(@PathVariable("index") Integer indexColonne) {
        System.out.print(indexColonne);
        ModelAndView modelAndView = new ModelAndView("game");
        GameModel gameModel = partieEnCours.getGameModel();
        int index = indexColonne-1;
        gameModel.add(index);
        modelAndView.addObject("game", gameModel);
        return modelAndView;
    }
    
    @RequestMapping("/hello/{index}")
    public ModelAndView hello(@PathVariable("index") Integer indexColonne) {
        ModelAndView modelAndView = new ModelAndView("hello");
        System.out.print(indexColonne);
        modelAndView.addObject("hello");
        return modelAndView;
    }

}
