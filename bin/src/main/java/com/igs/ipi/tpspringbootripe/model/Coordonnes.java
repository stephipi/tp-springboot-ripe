package com.igs.ipi.tpspringbootripe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.igs.ipi.tpspringbootripe.model.Coordonnes;

public class Coordonnes {

    public final int x;
    public final int y;

    public Coordonnes(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public List<List<Coordonnes>> getAlignementsPossibles(int nbAAligner, int lengthX, int lengthY) {
        List<List<Coordonnes>> alignements = new ArrayList<>();
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (offset) -> this.decalerEnVertical(offset)));
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (offset) -> this.decalerEnHorizontal(offset)));
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (offset) -> this.decalerEnDiagonalNE(offset)));
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (offset) -> this.decalerEnDiagonalSE(offset)));
        return alignements;
    }

    private List<Coordonnes> variations(int decalageMax, int lengthX, int lengthY, Function<Integer, Coordonnes> decaleur) {
        List<Coordonnes> coords = new ArrayList<>();
        for (int d = -decalageMax; d < decalageMax; d++) {
            Coordonnes coord = decaleur.apply(d);
            if (coord.isValide(lengthX, lengthY)) {
                coords.add(coord);
            }
        }
        return coords;
    }

    private boolean isValide(int lengthX, int lengthY) {
        return (x >= 0 && x < lengthX) && (y >= 0 && y < lengthY);
    }

    private Coordonnes decalerEnVertical(int offset) {
        return new Coordonnes(x, y + offset);
    }

    private Coordonnes decalerEnHorizontal(int offset) {
        return new Coordonnes(x + offset, y);
    }

    private Coordonnes decalerEnDiagonalNE(int offset) {
        return new Coordonnes(x + offset, y + offset);
    }

    private Coordonnes decalerEnDiagonalSE(int offset) {
        return new Coordonnes(x + offset, y - offset);
    }
    
}
