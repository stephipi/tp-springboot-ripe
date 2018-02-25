package com.igs.ipi.tpspringbootripe.model;

public class GameModel {

    private static final int LIGNE = 6;
    private static final int COLONNE = 7;
    
    private Case[][] cases = new Case[LIGNE][COLONNE];
    
	private String nom1;
    private String nom2;
    
	public String getNom1() {
		return nom1;
	}
	
	public String getNom2() {
		return nom2;
	}
	
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}
	
	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}

    public Case[][] getCases() {
		return cases;
	}
	
	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	public GameModel() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				cases[i][j] = Case.CASEVIDE;
			}
		}
    }
	
	public void add(Integer indexColonne) {
	    for (int indexLigne = cases.length - 1; indexLigne >= 0; indexLigne--) {
	        if (cases[indexLigne][indexColonne-1] == Case.CASEVIDE) {
	        	cases[indexLigne][indexColonne-1] = Case.CASEP1;
	            return;
	        }
	    }
	    throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + indexColonne);
	}
}
