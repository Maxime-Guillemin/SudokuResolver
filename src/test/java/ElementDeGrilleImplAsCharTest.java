import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Implémentation de la classe ElementDeGrilleImplAsCharTest.
 */
public class ElementDeGrilleImplAsCharTest {

    /**
     * Test l'équalité entre deux éléments.
     * Les élements sont différents mais ils ont la même valeur.
     */
    @Test
    public final void testEquals() {
        ElementDeGrille elementDeGrille1 = new ElementDeGrilleImplAsChar('a');
        ElementDeGrille elementDeGrille2 = new ElementDeGrilleImplAsChar('a');

        assertNotSame(elementDeGrille1, elementDeGrille2);
        assertEquals(elementDeGrille1, elementDeGrille2);
    }

    /**
     * Test l'équalité entre deux éléments.
     * Les élements sont différents.
     */
    @Test
    public final void testNotEquals() {
        ElementDeGrille elementDeGrille1 = new ElementDeGrilleImplAsChar('a');
        ElementDeGrille elementDeGrille2 = new ElementDeGrilleImplAsChar('b');

        assertNotEquals(elementDeGrille1, elementDeGrille2);
    }
}
