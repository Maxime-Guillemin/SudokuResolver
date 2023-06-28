import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurInitialeModificationException;

/**
 * Interface de résolveur de Grille.
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface Solveur {
    /**
     * Résout une grille.
     *
     * @param grille La grille à résoudre
     * @return true si la grille a été résolue avec succès
     * @throws HorsBornesException si des coordonnées
     * sont en dehors des bornes de la grille
     * @throws ElementInterditException si un élément
     * interdit est présent dans la grille
     * @throws ValeurInitialeModificationException si
     * une tentative de modification d'une valeur initiale est effectuée
     */
    boolean solve(Grille grille)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException;
}
