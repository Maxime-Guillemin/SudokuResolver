import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.util.Set;
import java.util.HashSet;

public class GrilleImpl implements Grille {
    private Set<ElementDeGrille> elements;
    private int dimension;
    private ElementDeGrille[][] grilleTab;
    private ElementDeGrille[][] grilleTabInitiale;

    public GrilleImpl(ElementDeGrille[] elements, ElementDeGrille[][] grilleTab) {
        this.elements = new HashSet<>();
        for (ElementDeGrille element : elements) {
            this.elements.add(element);
        }
        this.dimension = grilleTab.length;
        this.grilleTab = grilleTab;
        this.grilleTabInitiale = grilleTab;
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        return elements;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
        // Vérifier si la position (x, y) est en dehors des limites de la grille
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException("Position en dehors des limites de la grille.");
        }

        // Vérifier si la case (x, y) contient une valeur initiale de la grille
        if (isValeurInitiale(x, y)) {
            throw new ValeurInitialeModificationException("Impossible de modifier une valeur initiale de la grille.");
        }

        // Vérifier si la valeur value est autorisée dans cette grille
        if (value != null && !elements.contains(value)) {
            throw new ElementInterditException("L'élément de grille n'est pas autorisé dans cette grille.");
        }

        // Définir la valeur de la case (x, y) dans le tableau grilleTab
        grilleTab[x][y] = value;
    }


    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        // Vérifier si la position (x, y) est en dehors des limites de la grille
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException("Position en dehors des limites de la grille.");
        }

        // Récupérer la valeur de la case (x, y) dans le tableau grilleTab
        return grilleTab[x][y];
    }


    @Override
    public boolean isComplete() {
        // Ajoutez la logique pour vérifier si la grille est complète
        return false;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException {
        // Vérifier si la position (x, y) est en dehors des limites de la grille
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException("Position en dehors des limites de la grille.");
        }

        // Vérifier si la valeur value est autorisée dans cette grille
        if (value != null && !elements.contains(value)) {
            throw new ElementInterditException("L'élément de grille n'est pas autorisé dans cette grille.");
        }

        // Vérifier si la valeur value est présente sur la même ligne ou colonne
        for (int i = 0; i < dimension; i++) {
            if (grilleTab[x][i] == value || grilleTab[i][y] == value) {
                return false;
            }
        }

        // Calculer les indices du carré contenant la position (x, y)
        int carreDim = (int) Math.sqrt(dimension);
        int carreX = (x / carreDim) * carreDim;
        int carreY = (y / carreDim) * carreDim;

        // Vérifier si la valeur value est présente dans le carré
        for (int i = carreX; i < carreX + carreDim; i++) {
            for (int j = carreY; j < carreY + carreDim; j++) {
                if (grilleTab[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) throws HorsBornesException {
        // Vérifier si la position (x, y) est en dehors des limites de la grille
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException("Position en dehors des limites de la grille.");
        }

        return grilleTabInitiale[x][y] != null;
    }
}
