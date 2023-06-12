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

    public GrilleImpl(ElementDeGrille[] elements, ElementDeGrille[][] grilleTab) {
        this.elements = new HashSet<>();
        for (ElementDeGrille element : elements) {
            this.elements.add(element);
        }
        this.dimension = grilleTab.length;
        this.grilleTab = grilleTab;
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
        // Ajoutez la logique pour définir la valeur d'une case dans la grille
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        // Ajoutez la logique pour obtenir la valeur d'une case dans la grille
        return null;
    }

    @Override
    public boolean isComplete() {
        // Ajoutez la logique pour vérifier si la grille est complète
        return false;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException,
            ElementInterditException {
        // Ajoutez la logique pour vérifier si une valeur peut être placée dans la grille
        return false;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        // Ajoutez la logique pour vérifier si la case contient une valeur initiale
        return false;
    }
}
