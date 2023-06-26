import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.util.Set;

/**
 * @author Sébastien Choplin <sebastien.choplin@webadvise.fr>
 */
public class GrilleDecorateur implements  Grille{

    private final Grille grille;
    public GrilleDecorateur(Grille grilleC){
       this.grille=grilleC;
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        return grille.getElements();
    }

    @Override
    public int getDimension() {
        return grille.getDimension();
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException, ElementInterditException, ValeurInitialeModificationException {
grille.setValue(x,y,value);
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        return grille.getValue(x,y);
    }

    @Override
    public boolean isComplete() {
        return grille.isComplete();
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException {
        return grille.isPossible(x,y,value);
    }

    @Override
    public boolean isValeurInitiale(int x, int y) throws HorsBornesException {
        return grille.isValeurInitiale(x,y);
    }
}
