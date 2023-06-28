/**
 * package-info.java: toutes les infos sur le package.
 */

import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurInitialeModificationException;

import java.util.Set;

/**
 * Décorateur de la classe Grille.
 * Ajoute des fonctionnalités supplémentaires à la grille.
 */
public class GrilleDecorateur implements Grille {

    /**
     * Notre grille.
     */
    private final Grille grille;

    /**
     * Constructeur par défaut du GrilleDecorateur.
     * Initialise la grille avec des éléments par défaut.
     */
    public GrilleDecorateur() {
        ElementDeGrilleImplAsChar[] elements = {
                new ElementDeGrilleImplAsChar('1'),
                new ElementDeGrilleImplAsChar('2'),
                new ElementDeGrilleImplAsChar('3'),
                new ElementDeGrilleImplAsChar('4'),
                new ElementDeGrilleImplAsChar('5'),
                new ElementDeGrilleImplAsChar('6'),
                new ElementDeGrilleImplAsChar('7'),
                new ElementDeGrilleImplAsChar('8'),
                new ElementDeGrilleImplAsChar('9')
        };

        /**
         * Indice pour le tableau grilleTab.
         * La valeur de cette constante est 0.
         */
        final int zero = 0;


        ElementDeGrille[][] grilleTab = {
                {elements[zero], elements[zero], elements[zero],
                        null, null, null, null, null, null},
                {elements[zero], elements[zero], elements[zero],
                        null, null, null, null, null, null},
                {elements[zero], elements[zero], elements[zero],
                        null, null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null},
                {null, null, null, null,
                        null, null, null, null, null}
        };

        this.grille = new GrilleImpl(elements, grilleTab);
    }

    /**
     * Retourne l'ensemble des éléments de la grille.
     *
     * @return l'ensemble des éléments de la grille
     */
    @Override
    public final Set<ElementDeGrille> getElements() {
        return grille.getElements();
    }

    /**
     * Retourne la dimension de la grille.
     *
     * @return la dimension de la grille
     */
    @Override
    public final int getDimension() {
        return grille.getDimension();
    }

    /**
     * Lance une exception pour la méthode setValue.
     * Cette méthode est volontairement désactivée dans le décorateur.
     *
     * @param x     la coordonnée x de l'élément
     * @param y     la coordonnée y de l'élément
     * @param value la valeur de l'élément
     * @throws HorsBornesException toujours lancée pour cette méthode
     */
    @Override
    public final void setValue(final int x,
                               final int y, final ElementDeGrille value)
            throws HorsBornesException {
        throw new HorsBornesException("fausse exception");
    }

    /**
     * Retourne la valeur de l'élément à la position spécifiée.
     *
     * @param x la coordonnée x de l'élément
     * @param y la coordonnée y de l'élément
     * @return la valeur de l'élément à la position spécifiée
     * @throws HorsBornesException si les coordonnées
     * sont en dehors des bornes de la grille
     */
    @Override
    public final ElementDeGrille getValue(final int x, final int y)
            throws HorsBornesException {
        return grille.getValue(x, y);
    }

    /**
     * Vérifie si la grille est complète.
     *
     * @return true si la grille est complète, false sinon
     */
    @Override
    public final boolean isComplete() {
        return grille.isComplete();
    }

    /**
     * Vérifie si la valeur spécifiée peut être placée
     * à la position donnée dans la grille.
     *
     * @param x     la coordonnée x de l'élément
     * @param y     la coordonnée y de l'élément
     * @param value la valeur à vérifier
     * @return true si la valeur est possible, false sinon
     * @throws HorsBornesException
     * si la valeur à modifier est une valeur initiale de la grille
     */
    @Override
    public final boolean isPossible(
            final int x, final int y, final ElementDeGrille value)
            throws HorsBornesException {
        throw new HorsBornesException("fausse exception");
    }

    /**
     * Vérifie si l'élément à la position spécifiée
     * est une valeur initiale de la grille.
     *
     * @param x la coordonnée x de l'élément
     * @param y la coordonnée y de l'élément
     * @return true si l'élément est une valeur initiale, false sinon
     * @throws HorsBornesException si les coordonnées
     * sont en dehors des bornes de la grille
     */
    @Override
    public final boolean isValeurInitiale(final int x, final int y)
            throws HorsBornesException {
        return grille.isValeurInitiale(x, y);
    }

    /**
     * Trouve la prochaine case vide dans la grille en
     * utilisant une approche basée sur les contraintes.
     *
     * @return Les coordonnées de la prochaine case vide
     * sous forme d'un tableau [x, y],
     * ou null si aucune case vide n'est trouvée.
     */
    @Override
    public final int[] trouverProchaineCaseVide()
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException {
       return grille.trouverProchaineCaseVide();
    }

    /**
     * Compte le nombre de valeurs possibles pour une case vide donnée.
     *
     * @param row L'indice de ligne de la case vide.
     * @param col L'indice de colonne de la case vide.
     * @return Le nombre de valeurs possibles pour la case vide.
     */
    @Override
    public final int compterValeursPossibles(
            final int row, final int col)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException {
        return grille.compterValeursPossibles(row, col);
    }
}
