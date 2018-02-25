package com.igs.ipi.tpspringbootripe.model;

public enum Case {
    CASEP1, CASEP2, CASEVIDE;
    
	public String getCase() {
		if(this == CASEP1)
			return "player1";
		else if(this == CASEP2)
			return "player2";
		else
			return "vide";
	}
}
