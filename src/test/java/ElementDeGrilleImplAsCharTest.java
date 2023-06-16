import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ElementDeGrilleImplAsCharTest {


    @Test
    public void testEquals() {
        ElementDeGrille elementDeGrille1 = new ElementDeGrilleImplAsChar('a');
        ElementDeGrille elementDeGrille2 = new ElementDeGrilleImplAsChar('a');

        assertNotSame(elementDeGrille1, elementDeGrille2);
        assertEquals(elementDeGrille1,elementDeGrille2);
    }

    @Test
    public void testNotEquals() {
        ElementDeGrille elementDeGrille1 = new ElementDeGrilleImplAsChar('a');
        ElementDeGrille elementDeGrille2 = new ElementDeGrilleImplAsChar('b');

        assertNotEquals(elementDeGrille1,elementDeGrille2);
    }
}
