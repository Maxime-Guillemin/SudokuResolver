import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @BeforeEach
    public final void setup() {
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

        ElementDeGrille[][] grilleTab = {
                {elements[0], elements[1], elements[2], null, null, null, null, null, null},
                {elements[3], elements[4], elements[5], null, null, null, null, null, null},
                {elements[6], elements[7], elements[8], null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
        };

        grille = new GrilleImpl(elements, grilleTab);
    }

    /**
     * Teste la résolution du sudoku avec une grille valide.
     */
    @Test
    public final void testSolveValidGrid() {
        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(grille);

        // Assert
        assertTrue(result);
        assertTrue(grille.isComplete());
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
                new ElementDeGrilleImplAsChar('4'),
                new ElementDeGrilleImplAsChar('5'),
                new ElementDeGrilleImplAsChar('6'),
                new ElementDeGrilleImplAsChar('7'),
                new ElementDeGrilleImplAsChar('8'),
                new ElementDeGrilleImplAsChar('9')
        };

        ElementDeGrille[][] grilleTabComplete = {
                {elements[0], elements[1], elements[2],elements[0], elements[1], elements[2], elements[0], elements[1], elements[2]},
                {elements[3], elements[4], elements[5],elements[3], elements[4], elements[5], elements[3], elements[4], elements[5]},
                {elements[6], elements[7], elements[8],elements[6], elements[7], elements[8], elements[6], elements[7], elements[8]},
                {elements[0], elements[1], elements[2],elements[0], elements[1], elements[2], elements[0], elements[1], elements[2]},
                {elements[3], elements[4], elements[5],elements[3], elements[4], elements[5], elements[3], elements[4], elements[5]},
                {elements[6], elements[7], elements[8],elements[6], elements[7], elements[8], elements[6], elements[7], elements[8]},
                {elements[0], elements[1], elements[2],elements[0], elements[1], elements[2], elements[0], elements[1], elements[2]},
                {elements[3], elements[4], elements[5],elements[3], elements[4], elements[5], elements[3], elements[4], elements[5]},
                {elements[6], elements[7], elements[8],elements[6], elements[7], elements[8], elements[6], elements[7], elements[8]}
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
    public final void testSolveInvalidGrid() {
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

        ElementDeGrille[][] grilleTabInvalid = {
                {elements[0], elements[1], elements[2], null, null, null, null, null, null},
                {elements[3], elements[4], elements[5], null, null, null, null, null, null},
                {elements[6], elements[7], elements[8], null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
        };

        Grille invalidGrid = new GrilleImpl(elements, grilleTabInvalid);

        // Arrange
        SudokuSolver solver = new SudokuSolver();

        // Act
        boolean result = solver.solve(invalidGrid);

        // Assert
        assertFalse(result);
    }
}
