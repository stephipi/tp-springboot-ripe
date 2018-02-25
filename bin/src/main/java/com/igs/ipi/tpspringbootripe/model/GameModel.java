package com.igs.ipi.tpspringbootripe.model;

public class GameModel {

    private static final int LIGNE = 6;
    private static final int COLONNE = 7;
    
    private Case[][] cases = new Case[LIGNE][COLONNE];
    
	private String nom1;
    private String nom2;
    private boolean isPlayer1;
    
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
		isPlayer1 = true;
    }
	
	public void add(Integer indexColonne) {
	    for (int indexLigne = cases.length - 1; indexLigne >= 0; indexLigne--) {
	        if (cases[indexLigne][indexColonne] == Case.CASEVIDE) {
	        	Case playedCase = Case.CASEP1;
	        	if (!isPlayer1)
	        		playedCase = Case.CASEP2;
	        	cases[indexLigne][indexColonne] = playedCase;

                isPlayer1 = !isPlayer1;
	            return;
	        }
	    }
	    throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + indexColonne);
	}
	
	public boolean isTourJoueur1() {
		return isPlayer1;
	}

	public void setTourJoueur1(boolean tourJoueur1) {
		this.isPlayer1 = tourJoueur1;
	}
}
