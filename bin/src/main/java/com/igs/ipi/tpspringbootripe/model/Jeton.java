package com.igs.ipi.tpspringbootripe.model;

public enum Jeton {
    JETONP1, JETONP2, CASEVIDE;
    
	public String getCase() {
	    switch (this) {
	        case JETONP1:
				return "pieceP1.png";
	        case JETONP2:
	            return "pieceP2.png";
	        default:
	            return null;
	    }
	}
}
