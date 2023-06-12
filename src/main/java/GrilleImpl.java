import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.util.Set;

public class GrilleImpl implements Grille {
    public GrilleImpl(ElementDeGrille[] elementDeGrilles, ElementDeGrille[][] grilleTab) {
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        return null;
    }

    @Override
    public int getDimension() {
        return 0;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException, ElementInterditException, ValeurInitialeModificationException {

    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException {
        return false;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        return false;
    }
}
