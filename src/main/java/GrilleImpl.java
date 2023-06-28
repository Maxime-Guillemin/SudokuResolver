/**
 * package-info.java: toutes les infos sur le package.
 */

import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.util.Set;
import java.util.HashSet;

/**
 * Implémentation de l'interface Grille.
 */
public class GrilleImpl implements Grille {
    /**
     * Liste des éléments possibles dans la grille.
     */
    private Set<ElementDeGrille> elements;
    /**
     * Dimension de la grille.
     */
    private int dimension;
    /**
     * Grille actuelle.
     */
    private final ElementDeGrille[][] grilleTab;
    /**
     * Grille initiale.
     */
    private final ElementDeGrille[][] grilleTabInitiale;

    /**
     * Constructeur de la classe GrilleImpl.
     *
     * @param pElements   Les éléments de grille autorisés.
     * @param pGrilleTab  Le tableau représentant la grille.
     */
    public GrilleImpl(final ElementDeGrille[] pElements,
                      final ElementDeGrille[][] pGrilleTab) {
        this.elements = new HashSet<>();
        for (ElementDeGrille element : pElements) {
            this.elements.add(element);
            this.dimension = pGrilleTab.length;
        }

        this.dimension = pGrilleTab.length;
        this.grilleTab = new ElementDeGrille[dimension][dimension];
        for (int i = 0; i < this.dimension; i++) {
            this.grilleTab[i] = pGrilleTab[i].clone();
        }

        this.grilleTabInitiale = new ElementDeGrille[dimension][dimension];
        for (int i = 0; i < this.dimension; i++) {
            this.grilleTabInitiale[i] = pGrilleTab[i].clone();
        }
    }

    /**
     * Récupère la liste des éléments du Sudoku.
     *
     * @return
     */
    @Override
    public final Set<ElementDeGrille> getElements() {
        return new HashSet<>(elements);
    }

    /**
     * Récupère la dimension de la grille.
     *
     * @return
     */
    @Override
    public final int getDimension() {
        return dimension;
    }

    /**
     * Met une valeur dans la grille.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value élément de grille à mettre dans la case,
     *             null pour vider la case
     * @throws HorsBornesException
     * @throws ValeurImpossibleException
     * @throws ElementInterditException
     * @throws ValeurInitialeModificationException
     */
    @Override
    public final void setValue(final int x, final int y,
                               final ElementDeGrille value)
            throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException,
            ValeurInitialeModificationException {

        verifierLimitesGrille(x, y, dimension);
        verifierModificationValeurInitiale(x, y);
        verifierElementAutorise(value, elements);
        grilleTab[x][y] = value;
    }

    /**
     * Retourne un élément en fonction de la position souhaitée.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return
     * @throws HorsBornesException
     */
    @Override
    public final ElementDeGrille getValue(final int x, final int y)
            throws HorsBornesException {
        verifierLimitesGrille(x, y, dimension);
        return grilleTab[x][y];
    }

    /**
     * Vérifie que le Sudoku est complet.
     *
     * @return
     */
    @Override
    public final boolean isComplete() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (grilleTab[i][j] == null) {
                    return false;
                }
            }
        }

        if (dimension == 0) {
            return false;
        }

        return true;
    }

    /**
     * Vérifie que la valeur à placer est possible.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @return
     * @throws HorsBornesException
     * @throws ElementInterditException
     * @throws ValeurInitialeModificationException
     */
    @Override
    public final boolean isPossible(final int x, final int y,
                                    final ElementDeGrille value)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException {
        verifierModificationValeurInitiale(x, y);
        if (value != null) {
            verifierLimitesGrille(x, y, dimension);
            verifierElementAutorise(value, elements);
            for (int i = 0; i < dimension; i++) {
                if (grilleTab[x][i] == value || grilleTab[i][y] == value) {
                    return false;
                }
            }
            int carreDim = (int) Math.sqrt(dimension);
            int carreX = (x / carreDim) * carreDim;
            int carreY = (y / carreDim) * carreDim;
            for (int i = carreX; i < carreX + carreDim; i++) {
                for (int j = carreY; j < carreY + carreDim; j++) {
                    if (grilleTab[i][j] == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Vérifie si la valeur est une valeur initiale.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @return
     * @throws HorsBornesException
     */
    @Override
    public final boolean isValeurInitiale(final int x, final int y)
            throws HorsBornesException {

        verifierLimitesGrille(x, y, dimension);
        return grilleTabInitiale[x][y] != null;
    }

    /**
     * Vérifie le débordement de la grille.
     *
     * @param x  position x dans la grille
     * @param y  position y dans la grille
     * @param pDimension dimension de la grille
     * @throws HorsBornesException gestion exception
     */
    private void verifierLimitesGrille(final int x, final int y,
                                       final int pDimension)
            throws HorsBornesException {

        if (x < 0 || x >= pDimension || y < 0 || y >= pDimension) {
            throw new HorsBornesException(
                    "Position en dehors des limites de la grille."
            );
        }
    }

    /**
     * Vérifie l'élement selon notre liste autorisée.
     *
     * @param value  valeur à vérifier
     * @param pElements liste des éléments
     * @throws ElementInterditException gestion exception
     */
    private void verifierElementAutorise(final ElementDeGrille value,
                                         final Set<ElementDeGrille> pElements)
            throws ElementInterditException {
        if (!pElements.contains(value) && value != null) {
            throw new ElementInterditException(
                    "L'élément de grille n'est pas autorisé dans cette grille."
            );
        }
    }

    /**
     * Vérifie le non changement du tableau initial.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @throws ValeurInitialeModificationException  gestion exception
     * @throws HorsBornesException  gestion exception
     */
    private void verifierModificationValeurInitiale(final int x, final int y)
            throws ValeurInitialeModificationException, HorsBornesException {
        if (isValeurInitiale(x, y)) {
            throw new ValeurInitialeModificationException(
                    "Impossible de modifier une valeur initiale de la grille."
            );
        }
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
        int[] coordonnees = null;
        int minValeursPossibles = dimension + 1;

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (grilleTab[row][col] == null) {
                    int valeursPossibles = compterValeursPossibles(row, col);
                    if (valeursPossibles < minValeursPossibles) {
                        minValeursPossibles = valeursPossibles;
                        coordonnees = new int[]{row, col};
                    }
                }
            }
        }

        return coordonnees;
    }

    /**
     * Compte le nombre de valeurs possibles pour une case vide donnée.
     *
     * @param row L'indice de ligne de la case vide.
     * @param col L'indice de colonne de la case vide.
     * @return Le nombre de valeurs possibles pour la case vide.
     */
    @Override
    public final int compterValeursPossibles(final int row, final int col)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException {
        int valeursPossibles = 0;
        for (ElementDeGrille value : elements) {
                if (isPossible(row, col, value)) {
                    valeursPossibles++;
                }
        }
        return valeursPossibles;
    }
}
