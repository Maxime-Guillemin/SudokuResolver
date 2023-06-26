import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Implémentation de la classe SudokuSolverTest.
 */
public class SudokuSolverTest {
    /**
     * Grille utilisée pour les tests.
     */
    private Grille grille;

    /**
     * Mise en place avant chaque test.
     */

    /**
     * Indice pour le tableau grille.
     * La valeur de cette constante est 0.
     */
    public static final int IDX_0 = 0;

    /**
     * Indice pour le tableau grille.
     * La valeur de cette constante est 1.
     */
    public static final int IDX_1 = 1;

    /**
     * Indice pour le tableau grille.
     * La valeur de cette constante est 2.
     */
    public static final int IDX_2 = 2;

    /**
     * Indice pour le tableau grille.
     * La valeur de cette constante est 3.
     */
    public static final int IDX_3 = 3;

    /**
     * Méthode de configuration exécutée avant chaque test.
     * Elle initialise la grille avec des éléments
     * et une configuration par défaut.
     */
    @BeforeEach
    public final void setup() {
        ElementDeGrilleImplAsChar[] elements = {
                new ElementDeGrilleImplAsChar('1'),
                new ElementDeGrilleImplAsChar('2'),
                new ElementDeGrilleImplAsChar('3'),
                new ElementDeGrilleImplAsChar('4')
        };

        ElementDeGrille[][] grilleTab = {
                {elements[IDX_0], elements[IDX_1],
                        elements[IDX_2], elements[IDX_3]},
                {null, null, null, null},
                {null, elements[IDX_2], null, null},
                {null, null, null, null}
        };

        grille = new GrilleImpl(elements, grilleTab);
    }

    /**
     * Teste la résolution du sudoku avec une grille valide.
     */
    @Test
    public final void testSolvableGrid() {
        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(grille);

        // Assert
        assertTrue(result);
        assertTrue(grille.isComplete());
    }

    /**
     * Méthode de test pour vérifier le comportement
     * d'une exception de grille.
     * Elle crée un objet SudokuSolver et tente de
     * résoudre une grille décorée vide.
     * Le résultat attendu est false, indiquant que
     * la résolution a échoué.
     */
    @Test
    public final void testExceptionDeGrille() {
        SudokuSolver solver = new SudokuSolver();
        boolean result = solver.solve(new GrilleDecorateur() { });
        assertFalse(result);
    }

    /**
     * Teste la résolution du sudoku avec une grille déjà complète.
     */
    @Test
    public final void testSolveAlreadyCompleteGrid() {
        ElementDeGrilleImplAsChar[] elements = {
                new ElementDeGrilleImplAsChar('1'),
                new ElementDeGrilleImplAsChar('2'),
                new ElementDeGrilleImplAsChar('3'),
                new ElementDeGrilleImplAsChar('4')
        };

        ElementDeGrille[][] grilleTabComplete = {
                {elements[IDX_0], elements[IDX_1],
                        elements[IDX_2], elements[IDX_0]},
                {elements[IDX_3], elements[IDX_0],
                        elements[IDX_2], elements[IDX_3]},
                {elements[IDX_1], elements[IDX_0],
                        elements[IDX_1], elements[IDX_2]},
                {elements[IDX_2], elements[IDX_0],
                        elements[IDX_1], elements[IDX_2]}
        };

        Grille completeGrid = new GrilleImpl(elements, grilleTabComplete);

        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(completeGrid);

        // Assert
        assertTrue(result);
        assertTrue(completeGrid.isComplete());
    }

    /**
     * Teste la résolution du sudoku avec une grille invalide.
     */
    @Test
    public final void testSolveInsolvableGrid() {
        ElementDeGrilleImplAsChar[] elements = {
                new ElementDeGrilleImplAsChar('1'),
                new ElementDeGrilleImplAsChar('2')
        };

        ElementDeGrille[][] grilleTabInvalid = {
                {elements[IDX_0], elements[IDX_1], null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };

        Grille invalidGrid = new GrilleImpl(elements, grilleTabInvalid);

        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(invalidGrid);

        // Assert
        assertFalse(result);
    }

    /**
     * Méthode de test pour vérifier le comportement
     * de la résolution lorsque la grille est vide.
     * Elle crée une grille invalide avec deux éléments
     * par défaut et un tableau de grille vide.
     * Ensuite, elle utilise un objet SudokuSolver pour
     * tenter de résoudre la grille vide.
     * Le résultat attendu est false, indiquant que la
     * résolution a échoué.
     */
    @Test
    public final void testSolveEmptyGrid() {
        ElementDeGrilleImplAsChar[] elements = {
                new ElementDeGrilleImplAsChar('1'),
                new ElementDeGrilleImplAsChar('2')
        };

        ElementDeGrille[][] grilleTabInvalid = {};

        Grille invalidGrid = new GrilleImpl(elements, grilleTabInvalid);

        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(invalidGrid);

        // Assert
        assertFalse(result);
    }
}
