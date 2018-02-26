package com.igs.ipi.tpspringbootripe.model;

import java.util.List;

public class GameModel {

    private static final int LIGNE = 6;
    private static final int COLONNE = 7;
    
    public static final int NB_A_ALIGNER = 4;
    
    private Jeton[][] jetons = new Jeton[LIGNE][COLONNE];
    
	private String nom1;
    private String nom2;
    private boolean isPlayer1;
    private int numJoueurGagnant = 0;
    
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

    public Jeton[][] getCases() {
		return jetons;
	}
	
	public void setCases(Jeton[][] cases) {
		this.jetons = cases;
	}
	
	public GameModel() {
		for (int i = 0; i < jetons.length; i++) {
			for (int j = 0; j < jetons[i].length; j++) {
				jetons[i][j] = Jeton.CASEVIDE;
			}
		}
		isPlayer1 = true;
    }
	
	public void add(Integer indexColonne) {
		//verifie que la partie n'est pas déjà gagnée
		if (numJoueurGagnant != 0) {
			throw new IllegalStateException("La partie est déjà terminée");
		}
		
		//ajoute le jeton dans la grille de jeu
	    for (int indexLigne = jetons.length - 1; indexLigne >= 0; indexLigne--) {
	        if (jetons[indexLigne][indexColonne] == Jeton.CASEVIDE) {
	        	jetons[indexLigne][indexColonne] = Jeton.JETONP1;
	        	if (!isPlayer1)
	        		jetons[indexLigne][indexColonne] = Jeton.JETONP2;
	        	

	        	 boolean coupGagnant = isCoupGagnant(indexColonne, indexLigne);
	        	 if (coupGagnant) {
	        		 if (isPlayer1)
	        			 numJoueurGagnant = 1;
	        		 else
	        			 numJoueurGagnant = 2;
	        	 }
	        	//change de joueur
                isPlayer1 = !isPlayer1;
	            return;
	        }
	    }
	    //vérifie que la colone n'est pas pleine
	    throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + indexColonne);
	}
	
	private boolean isCoupGagnant(int x, int y) {
		 Jeton caseCourante = jetons[y][x];
		 Coordonnes init = new Coordonnes(x, y);
		 List<List<Coordonnes>> alignementsPossibles = init.getAlignementsPossibles(NB_A_ALIGNER, COLONNE, LIGNE);
	for (List<Coordonnes> alignement : alignementsPossibles) {
		int nbAlignes = 0;
		for (Coordonnes c : alignement) {
			if (jetons[c.y][c.x] == caseCourante) {
				nbAlignes++;
			} else {
				nbAlignes = 0;
			}
			if (nbAlignes == NB_A_ALIGNER) {
				return true;
			}
		}
	}	
	return false;
}
	 
	public boolean isTourJoueur1() {
		return isPlayer1;
	}

	public void setTourJoueur1(boolean tourJoueur1) {
		this.isPlayer1 = tourJoueur1;
	}
	

    public Integer getNumJoueurGagnant() {
        return numJoueurGagnant;
    }

    public boolean isJoueur1Gagnant() {
        return numJoueurGagnant == 1;
    }

    public boolean isJoueur2Gagnant() {
        return numJoueurGagnant == 2;
    }
}
