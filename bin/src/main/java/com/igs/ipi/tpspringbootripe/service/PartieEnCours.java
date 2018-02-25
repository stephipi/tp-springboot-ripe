package com.igs.ipi.tpspringbootripe.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.igs.ipi.tpspringbootripe.model.GameModel;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours {
	private GameModel gameModel;
	public GameModel getGameModel() {
	        return gameModel;
	}
	
	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}
}
