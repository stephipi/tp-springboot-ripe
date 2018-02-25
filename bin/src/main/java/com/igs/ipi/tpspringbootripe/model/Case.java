package com.igs.ipi.tpspringbootripe.model;

public enum Case {
    CASEP1, CASEP2, CASEVIDE;
    
	public String getCase() {
		if(this == CASEP1)
			return "pieceP1.png";
		else if(this == CASEP2)
			return "pieceP2.png";
		else
			return null;
	}
}
