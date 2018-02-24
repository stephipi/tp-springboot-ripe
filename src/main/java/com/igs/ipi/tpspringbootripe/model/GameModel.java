package com.igs.ipi.tpspringbootripe.model;

public class GameModel {

    private static final int LIGNE = 7;
    private static final int COLONNE = 6;
    
    private Case[][] cases = new Case[COLONNE][LIGNE];
    
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
				cases[i][j] = Case.CASE;
			}
		}
    }
}
