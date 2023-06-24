import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Implémentation de la classe GrilleImplTest.
 */
public class GrilleImplTest {
    /**
     * Initialisation d'une grille.
     */
    private GrilleImpl grille;
    /**
     * Initialisation d'une grille.
     */
    private GrilleImpl grilleComplete;

    /**
     * Constante pour position en moins un.
     */
    private static final int INTMOINSUN = -1;

    /**
     * Constante pour position en zéro.
     */
    private static final int INTZERO = 0;

    /**
     * Constante pour position en un.
     */
    private static final int INTUN = 1;

    /**
     * Constante pour position en deux.
     */
    private static final int INTDEUX = 2;

    /**
     * Constante pour position en trois.
     */
    private static final int INTTROIS = 3;

    /**
     * Constante pour position en quatre.
     */
    private static final int INTQUATRE = 4;

    /**
     * Constante pour initialiser un élément.
     */
    private static final char UN = '1';

    /**
     * Constante pour initialiser un élément.
     */
    private static final char DEUX = '2';

    /**
     * Constante pour initialiser un élément.
     */
    private static final char TROIS = '3';

    /**
     * Implémentation d'un tableau d'élément.
     */
    private ElementDeGrille[] elements;

    /**
     * Mise en place avant les tests.
     */
    @BeforeEach
    public final void setup() {
        // Initialiser la grille avant chaque test
         this.elements = new ElementDeGrille[] {
                 new ElementDeGrilleImplAsChar(UN),
                 new ElementDeGrilleImplAsChar(DEUX),
                 new ElementDeGrilleImplAsChar(TROIS)
         };
        ElementDeGrille[][] grilleTab = {
                {null, null, null},
                {null, null, null},
                {null, null, elements[0]}
        };
        grille = new GrilleImpl(elements, grilleTab);
        ElementDeGrille[][] grilleTabComplete = {
                {elements[0], elements[0], elements[0]},
                {elements[0], elements[0], elements[0]},
                {elements[0], elements[0], elements[0]}
        };
        grilleComplete = new GrilleImpl(elements, grilleTabComplete);
    }

    /**
     * Test des éléments null.
     *
     * @throws ElementInterditException Gestion erreur
     * @throws HorsBornesException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     * @throws ValeurImpossibleException Gestion erreur
     */
    @Test
    public final void testSetElementNull()
            throws ElementInterditException, HorsBornesException,
            ValeurInitialeModificationException, ValeurImpossibleException {

        assertTrue(grille.isValeurInitiale(INTDEUX, INTDEUX));
        assertThrows(
                ValeurInitialeModificationException.class,
                () -> grille.isPossible(INTDEUX, INTDEUX, null)
        );

        grille.setValue(INTZERO, INTZERO, elements[1]);
        assertFalse(grille.isValeurInitiale(INTZERO, INTZERO));
        assertTrue(grille.isPossible(INTZERO, INTZERO, null));
    }

    /**
     * Mise en place des tests sur le constructeur.
     */
    @Test
    public final void testConstructorElementsSetCorrectly() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(elements[0]);
        expectedElements.add(elements[1]);
        expectedElements.add(elements[2]);

        // Act
        Set<ElementDeGrille> actualElements = grille.getElements();

        // Assert
        assertEquals(expectedElements, actualElements);
    }

    /**
     * Test dimension sur le constructeur.
     */
    @Test
    public final void testConstructorDimensionSetCorrectly() {
        // Arrange
        int expectedDimension = INTTROIS;

        // Act
        int actualDimension = grille.getDimension();

        // Assert
        assertEquals(expectedDimension, actualDimension);
    }

    /**
     * Série de tests sur getElements.
     */
    @Test
    public final void testGetElementsReturnCorrectSet() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(elements[0]);
        expectedElements.add(elements[1]);
        expectedElements.add(elements[2]);

        // Act
        Set<ElementDeGrille> actualElements = grille.getElements();

        // Assert
        assertEquals(expectedElements, actualElements);
    }

    /**
     * Série de tests sur getDimension.
     */
    @Test
    public final void testGetDimensionReturnCorrectValue() {
        // Arrange
        int expectedDimension = INTTROIS;

        // Act
        int actualDimension = grille.getDimension();

        // Assert
        assertEquals(expectedDimension, actualDimension);
    }

    //

    /**
     * Série de tests sur SetValue.
     *
     * @throws HorsBornesException Gestion erreur
     * @throws ValeurImpossibleException Gestion erreur
     * @throws ElementInterditException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     */
    @Test
    public final void testSetValueValidValueSuccess()
            throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
        // Arrange
        int x = INTZERO;
        int y = INTZERO;
        ElementDeGrille value = elements[0];

        // Act
        grille.setValue(x, y, value);

        // Assert
        ElementDeGrille result = grille.getValue(x, y);
        assertEquals(value, result);
    }

    /**
     * Test concernant la position.
     */
    @Test
    public final void testSetValueInvalidPositionThrowHorsBornesException() {
        // Arrange
        ElementDeGrille value = elements[1];

        // Act and Assert
        assertThrows(
                HorsBornesException.class,
                () -> grille.setValue(INTDEUX, INTQUATRE, value)
        );

        // Act and Assert
        assertThrows(
                HorsBornesException.class,
                () -> grille.setValue(INTQUATRE, INTDEUX, value)
        );

        // Act and Assert
        assertThrows(
                HorsBornesException.class,
                () -> grille.setValue(INTMOINSUN, INTDEUX, value)
        );

        // Act and Assert
        assertThrows(
                HorsBornesException.class,
                () -> grille.setValue(INTDEUX, INTMOINSUN, value)
        );
    }

    /**
     * Test de mettre une valeur sur un élément initial de la grille.
     */
    @Test
    public final
    void testSetValueInitialValueThrowValeurInitialeModificationException() {
        // Arrange
        int x = INTDEUX;
        int y = INTDEUX;
        ElementDeGrille value = elements[2];

        // Act and Assert
        assertThrows(
                ValeurInitialeModificationException.class,
                () -> grille.setValue(x, y, value)
        );
    }

    /**
     * Test de mettre une valeur alors que l'élement n'est pas autorisé.
     */
    @Test
    public final void testSetValueInvalidValueThrowElementInterditException() {
        // Arrange
        int x = INTUN;
        int y = INTDEUX;
        ElementDeGrille value = new ElementDeGrilleImplAsChar('4');

        // Act and Assert
        assertThrows(
                ElementInterditException.class,
                () -> grille.setValue(x, y, value)
        );
    }

    /**
     * Test si c'est une valeur initiale.
     *
     * @throws HorsBornesException Gestion erreur
     */
    @Test
    public final void testIsValeurInitialeWithValueReturnsTrue()
            throws HorsBornesException {
        // Arrange
        int x = INTDEUX;
        int y = INTDEUX;

        // Act
        boolean result = grille.isValeurInitiale(x, y);

        // Assert
        assertTrue(result);
    }

    /**
     * Test si ce n'est pas une valeur initiale.
     *
     * @throws HorsBornesException Gestion erreur
     */
    @Test
    public final void testIsValeurInitialeWithoutValueReturnsFalse()
            throws HorsBornesException {
        // Arrange
        int x = INTUN;
        int y = INTZERO;

        // Act
        boolean result = grille.isValeurInitiale(x, y);

        // Assert
        assertFalse(result);
    }

    /**
     * Test si c'est une valeur initiale.
     * Tente d'accéder à une case qui n'est pas dans la grille.
     */
    @Test
    public final
    void testIsValeurInitialeWithInvalidPositionThrowsHorsBornesException() {
        // Arrange
        int x = INTQUATRE;
        int y = INTZERO;

        // Act and Assert
        assertThrows(
                HorsBornesException.class,
                () -> grille.isValeurInitiale(x, y)
        );
    }

    /**
     * Test si c'est possible de mettre un élément sur une case.
     *
     * @throws HorsBornesException Gestion erreur
     * @throws ElementInterditException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     */
    @Test
    public final void testIsPossibleValidValueReturnsTrue()
            throws HorsBornesException, ElementInterditException,
            ValeurInitialeModificationException {
        int x = INTZERO;
        int y = INTZERO;
        ElementDeGrille value = elements[1];

        boolean result = grille.isPossible(x, y, value);

        assertTrue(result);
    }

    /**
     * Test si c'est possible de mettre un élément sur une case.
     * Sauf qu'ici la valeur n'est pas possible sur l'axe Y.
     *
     * @throws HorsBornesException Gestion erreur
     * @throws ElementInterditException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     */
    @Test
    public final void testIsPossibleInvalidValueYReturnsFalse()
            throws HorsBornesException, ElementInterditException,
            ValeurInitialeModificationException {
        int x = INTZERO;
        int y = INTDEUX;
        ElementDeGrille value = elements[0];

        boolean result = grille.isPossible(x, y, value);

        assertFalse(result);
    }

    /**
     * Test si c'est possible de mettre un élément sur une case.
     * Sauf qu'ici la valeur n'est pas possible sur l'axe X.
     *
     * @throws HorsBornesException Gestion erreur
     * @throws ElementInterditException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     */
    @Test
    public final void testIsPossibleInvalidValueXReturnsFalse()
            throws HorsBornesException, ElementInterditException,
            ValeurInitialeModificationException {
        int x = INTDEUX;
        int y = INTZERO;
        ElementDeGrille value = elements[0];

        boolean result = grille.isPossible(x, y, value);

        assertFalse(result);
    }

    /**
     * Test si c'est possible de mettre un élément sur une case.
     * Sauf sur une grille carré.
     *
     * @throws HorsBornesException Gestion erreur
     * @throws ElementInterditException Gestion erreur
     * @throws ValeurInitialeModificationException Gestion erreur
     */
    @Test
    public final void testIsPossibleInvalidValueCarreReturnsFalse()
            throws HorsBornesException, ElementInterditException,
            ValeurInitialeModificationException {
        int x = INTZERO;
        int y = INTDEUX;
        ElementDeGrille value = elements[1];

        ElementDeGrille[][] grilleTabQuatre = {
                {elements[0], elements[0], null, elements[0]},
                {elements[0], elements[0], elements[0], elements[1]},
                {elements[0], elements[0], elements[0], elements[0]},
                {elements[0], elements[0], elements[0], elements[0]}
        };
        Grille grilleQuatre = new GrilleImpl(elements, grilleTabQuatre);

        boolean result = grilleQuatre.isPossible(x, y, value);

        assertFalse(result);
    }

    /**
     * Test s'il est possible de mettre un élément en dehors de la grille.
     */
    @Test
    public final void testIsPossibleOutOfBoundsReturnsException() {
        int x = INTMOINSUN;
        int y = INTZERO;
        ElementDeGrille value = elements[0];

        assertThrows(
                HorsBornesException.class,
                () -> grille.isPossible(x, y, value)
        );
    }

    /**
     * Test s'il est possible de mettre un nouvel élément.
     */
    @Test
    public final void testIsPossibleInvalidElementReturnsException() {
        int x = INTZERO;
        int y = INTZERO;
        ElementDeGrille value = new ElementDeGrilleImplAsChar('4');

        assertThrows(
                ElementInterditException.class,
                () -> grille.isPossible(x, y, value)
        );
    }

    /**
     * Série de tests sur isComplete.
     */
    @Test
    public final void testIsCompleteReturnsTrue() {
        boolean result = grilleComplete.isComplete();
        assertTrue(result);
    }

    /**
     * Test si la grille est compléte. Ici non.
     */
    @Test
    public final void testIsCompleteReturnsFalse() {
        boolean result = grille.isComplete();
        assertFalse(result);
    }

    /**
     * Teste si getValue renvoie la valeur correcte pour une position donnée.
     *
     * @throws HorsBornesException Gestion erreur
     */
    @Test
    public final void testGetValueReturnsCorrectValue()
            throws HorsBornesException {
        // Arrange
        int x = INTDEUX;
        int y = INTDEUX;
        ElementDeGrille expectedValue = elements[0];

        // Act
        ElementDeGrille actualValue = grille.getValue(x, y);

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Teste si getValue lance une exception HorsBornesException
     * pour une position invalide.
     */
    @Test
    public final
    void testGetValueThrowsHorsBornesExceptionForInvalidPosition() {
        // Arrange
        int x = INTQUATRE;
        int y = INTUN;

        // Act and Assert
        assertThrows(HorsBornesException.class, () -> grille.getValue(x, y));
    }
}
