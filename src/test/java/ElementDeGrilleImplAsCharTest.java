import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Implémentation de la classe ElementDeGrilleImplAsCharTest.
 */
public class ElementDeGrilleImplAsCharTest {

    /**
     * Teste l'égalité entre deux éléments.
     * Les éléments sont différents mais ils ont la même valeur.
     */
    @Test
    public final void testEquals() {
        ElementDeGrille elementDeGrille1 = new ElementDeGrilleImplAsChar('a');
        ElementDeGrille elementDeGrille2 = new ElementDeGrilleImplAsChar('a');

        assertNotSame(elementDeGrille1, elementDeGrille2);
        assertEquals(elementDeGrille1, elementDeGrille2);
    }

    /**
     * Teste l'inégalité entre deux éléments.
     * Les éléments sont d'une classe différente ou ont des valeurs différentes.
     */
    @Test
    public final void testNotEquals() {
        char value = 'A';
        ElementDeGrilleImplAsChar element =
                new ElementDeGrilleImplAsChar(value);

        Object otherObject = new Object();
        Assertions.assertFalse(element.equals(otherObject),
                "La méthode equals() devrait "
                        +
                        "renvoyer false pour un objet "
                        +
                        "d'une classe différente.");

        ElementDeGrilleImplAsChar otherElement =
                new ElementDeGrilleImplAsChar('B');
        Assertions.assertFalse(element.equals(otherElement),
                "La méthode equals() devrait "
                        +
                        "renvoyer false pour un objet de même "
                        +
                        "classe mais avec une valeur différente.");

        ElementDeGrilleImplAsChar sameElement =
                new ElementDeGrilleImplAsChar(value);
        Assertions.assertTrue(element.equals(sameElement),
                "La méthode equals() devrait "
                        +
                        "renvoyer true pour un objet "
                        +
                        "de même classe et avec "
                        +
                        "la même valeur.");
    }

    /**
     * Teste la méthode toString() pour obtenir la
     * représentation en chaîne de caractères de l'élément.
     */
    @Test
    public final void testToString() {
        char value = 'A';
        ElementDeGrilleImplAsChar element =
                new ElementDeGrilleImplAsChar(value);

        String expected = String.valueOf(value);
        String actual = element.toString();

        assertEquals(expected, actual,
                "La méthode toString() ne "
                        +
                        "renvoie pas la valeur attendue.");
    }
}
