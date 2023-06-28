import java.util.Set;

import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

/**
 * Interface de grille de sudoku. Chaque case d'une Grille peut contenir un
 * ElementDeGrille ou null si aucun élément n'est placé.
 * Une Grille doit toujours respecter les règles du sudoku.
 *
 * Une Grille peut contenir des cases qui ne doivent pas être modifiées
 * (les valeurs initiales de la Grille)
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface Grille {

    /**
     * Renvoie les ElementDeGrille pouvant exister dans la grille.
     *
     * @return ensemble des éléments de grille
     */
    Set<ElementDeGrille> getElements();

    /**
     * Renvoie la largeur/hauteur de la grille.
     *
     * @return dimension de la grille
     */
    int getDimension();

    /**
     * Affecte une valeur dans une case de la grille,
     * ou null pour 'vider' la case.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value élément de grille à mettre dans la case,
     *              null pour vider la case
     * @throws ValeurImpossibleException
     * si l'élément de grille n'est pas autorisé à cette position
     * dans la grille aux vues des autres valeurs de la grille
     * @throws ElementInterditException
     * si l'élément de grille n'est pas autorisé dans cette grille
     * pouvant être mis dans la grille
     * @throws HorsBornesException
     * si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException
     * si une valeur initiale de la grille est en position x,y
     */
    void setValue(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException;

    /**
     * Renvoie une valeur de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return élément de la grille de la case x,y,
     * null s'il n'y a pas d'élément à cette position
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     */
    ElementDeGrille getValue(int x, int y) throws HorsBornesException;

    /**
     * Teste si une grille est remplie.
     *
     * @return true si la grille est complète
     */
    boolean isComplete();

    /**
     * Teste si une valeur peut être placée dans la grille.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur à mettre dans la case
     * @return true si value peut être placé dans la grille
     * en position x,y en respectant les règles du sudoku
     * et sans modifier une valeur initiale.
     * @throws HorsBornesException
     * si x ou y sont hors bornes
     * @throws ElementInterditException
     * si value n'est pas un caractère pouvant être mis dans la grille
     * @throws ValeurInitialeModificationException
     * si une valeur initiale de la grille est en position x,y
     */
    boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ElementInterditException,
            ValeurInitialeModificationException;

    /**
     * Teste si la case x,y contient une valeur initiale de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return true si la case x,y
     * contient une valeur initiale de la grille
     * @throws HorsBornesException si x ou y
     * sont en dehors de la grille
     */
    boolean isValeurInitiale(int x, int y) throws HorsBornesException;

    /**
     * Trouve la prochaine case vide dans la grille en
     * utilisant une approche basée sur les contraintes.
     *
     * @return Les coordonnées de la prochaine case vide
     * sous forme d'un tableau [x, y],
     * ou null si aucune case vide n'est trouvée.
     * @throws HorsBornesException si x ou y
     * @throws ElementInterditException
     * si value n'est pas un caractère pouvant être mis dans la grille
     * @throws ValeurInitialeModificationException
     * si une valeur initiale de la grille est en position x,y
     */

    int[] trouverProchaineCaseVide()
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException;

    /**
     * Compte le nombre de valeurs possibles pour une case vide donnée.
     *
     * @param row L'indice de ligne de la case vide.
     * @param col L'indice de colonne de la case vide.
     * @return Le nombre de valeurs possibles pour la case vide.
     * @throws HorsBornesException si x ou y
     * @throws ElementInterditException
     * si value n'est pas un caractère pouvant être mis dans la grille
     * @throws ValeurInitialeModificationException
     * si une valeur initiale de la grille est en position x,y
     */
    int compterValeursPossibles(final int row, final int col)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException;
}
