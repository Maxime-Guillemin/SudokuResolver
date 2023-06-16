import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GrilleImplTest {
    private GrilleImpl grille;
    private GrilleImpl grilleComplete;

    private final char UN = '1';
    private final char DEUX = '2';
    private final char TROIS = '3';

    private ElementDeGrille[] elements;

    //Mise en place avant les tests
    @BeforeEach
    public void setup(){
        // Initialiser la grille avant chaque test
         this.elements = new ElementDeGrille[]{
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

    //Mise en place des tests sur le constructeur
    @Test
    public void testConstructorElementsSetCorrectly() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(elements[0]);
        expectedElements.add(elements[1]);
        expectedElements.add(elements[2]);

        // Act
        Set<ElementDeGrille> actualElements = grille.getElements();

        // Assert
        Assertions.assertEquals(expectedElements, actualElements);
    }

    @Test
    public void testConstructorDimensionSetCorrectly() {
        // Arrange
        int expectedDimension = 3;

        // Act
        int actualDimension = grille.getDimension();

        // Assert
        Assertions.assertEquals(expectedDimension, actualDimension);
    }

    //Série de tests sur getElements
    @Test
    public void testGetElementsReturnCorrectSet() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(elements[0]);
        expectedElements.add(elements[1]);
        expectedElements.add(elements[2]);

        // Act
        Set<ElementDeGrille> actualElements = grille.getElements();

        // Assert
        Assertions.assertEquals(expectedElements, actualElements);
    }

    //Série de tests sur getDimension
    @Test
    public void testGetDimensionReturnCorrectValue() {
        // Arrange
        int expectedDimension = 3;

        // Act
        int actualDimension = grille.getDimension();

        // Assert
        Assertions.assertEquals(expectedDimension, actualDimension);
    }

    //Série de tests sur SetValue
    @Test
    public void testSetValueValidValueSuccess() throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
        // Arrange
        int x = 0;
        int y = 0;
        ElementDeGrille value = elements[0];

        // Act
        grille.setValue(x, y, value);

        // Assert
        ElementDeGrille result = grille.getValue(x, y);
        Assertions.assertEquals(value, result);
    }

    @Test
    public void testSetValueInvalidPositionThrowHorsBornesException() {
        // Arrange
        int x = 4;
        int y = 2;
        ElementDeGrille value = elements[1];

        // Act and Assert
        assertThrows(HorsBornesException.class, () -> grille.setValue(x, y, value));
    }

    @Test
    public void testSetValueInitialValueThrowValeurInitialeModificationException() {
        // Arrange
        int x = 2;
        int y = 2;
        ElementDeGrille value = elements[2];

        // Act and Assert
        assertThrows(ValeurInitialeModificationException.class, () -> grille.setValue(x, y, value));
    }

    @Test
    public void testSetValueInvalidValueThrowElementInterditException() {
        // Arrange
        int x = 1;
        int y = 2;
        ElementDeGrille value = new ElementDeGrilleImplAsChar('4');

        // Act and Assert
        assertThrows(ElementInterditException.class, () -> grille.setValue(x, y, value));
    }

    @Test
    public void testIsValeurInitialeWithValueReturnsTrue() throws HorsBornesException {
        // Arrange
        int x = 2;
        int y = 2;

        // Act
        boolean result = grille.isValeurInitiale(x, y);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsValeurInitialeWithoutValueReturnsFalse() throws HorsBornesException {
        // Arrange
        int x = 1;
        int y = 0;

        // Act
        boolean result = grille.isValeurInitiale(x, y);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsValeurInitialeWithInvalidPositionThrowsHorsBornesException() {
        // Arrange
        int x = 5;
        int y = 0;

        // Act and Assert
        assertThrows(HorsBornesException.class, () -> grille.isValeurInitiale(x, y));
    }

    @Test
    public void testIsPossible_ValidValue_ReturnsTrue() throws HorsBornesException, ElementInterditException {
        int x = 0;
        int y = 0;
        ElementDeGrille value = elements[1];

        boolean result = grille.isPossible(x, y, value);

        assertTrue(result);
    }

    @Test
    public void testIsPossibleInvalidValueReturnsFalse() throws HorsBornesException, ElementInterditException {
        int x = 0;
        int y = 2;
        ElementDeGrille value = elements[0];

        boolean result = grille.isPossible(x, y, value);

        assertFalse(result);
    }

    @Test
    public void testIsPossibleOutOfBoundsReturnsException() {
        int x = -1;
        int y = 0;
        ElementDeGrille value = elements[0];

        assertThrows(HorsBornesException.class, () -> grille.isPossible(x, y, value));
    }

    @Test
    public void testIsPossible_InvalidElement_ReturnsException() {
        int x = 0;
        int y = 0;
        ElementDeGrille value = new ElementDeGrilleImplAsChar('4');

        assertThrows(ElementInterditException.class, () -> grille.isPossible(x, y, value));
    }

    //Série de tests sur isComplete
    @Test
    public void testIsCompleteReturnsTrue() {
        boolean result = grilleComplete.isComplete();
        assertTrue(result);
    }

    @Test
    public void testIsCompleteReturnsFalse() {
        boolean result = grille.isComplete();
        assertFalse(result);
    }

    // Teste si getValue renvoie la valeur correcte pour une position donnée
    @Test
    public void testGetValueReturnsCorrectValue() throws HorsBornesException {
        // Arrange
        int x = 2;
        int y = 2;
        ElementDeGrille expectedValue = elements[0];

        // Act
        ElementDeGrille actualValue = grille.getValue(x, y);

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    // Teste si getValue lance une exception HorsBornesException pour une position invalide
    @Test
    public void testGetValueThrowsHorsBornesExceptionForInvalidPosition() {
        // Arrange
        int x = 4;
        int y = 1;

        // Act and Assert
        assertThrows(HorsBornesException.class, () -> grille.getValue(x, y));
    }
}
