package com.igs.ipi.tpspringbootripe.model;

public enum Case {
    CASE;
    
	public String getCase() {
		if(this == CASE)
			return "case";
		else
			return null;
	}
}
