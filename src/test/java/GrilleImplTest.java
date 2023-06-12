import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class GrilleImplTest {
    private GrilleImpl grille;

    //Mise en place avant les tests
    @BeforeEach
    public void setup() {
        // Initialiser la grille avant chaque test
        ElementDeGrille[] elements = {ElementDeGrille.UN, ElementDeGrille.DEUX, ElementDeGrille.TROIS};
        ElementDeGrille[][] grilleTab = new ElementDeGrille[3][3];
        grille = new GrilleImpl(elements, grilleTab);
    }

    //Mise en place des tests sur le constructeur
    @Test
    public void testConstructorElementsSetCorrectly() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(ElementDeGrille.UN);
        expectedElements.add(ElementDeGrille.DEUX);
        expectedElements.add(ElementDeGrille.TROIS);

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

    @Test
    public void testConstructorGrilleTabSetCorrectly() {
        // Arrange
        ElementDeGrille[][] expectedGrilleTab = new ElementDeGrille[3][3];

        // Act
        ElementDeGrille[][] actualGrilleTab = grille.getGrilleTab();

        // Assert
        Assertions.assertArrayEquals(expectedGrilleTab, actualGrilleTab);
    }

    //Série de tests sur getElements
    @Test
    public void testGetElementsReturnCorrectSet() {
        // Arrange
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(ElementDeGrille.UN);
        expectedElements.add(ElementDeGrille.DEUX);
        expectedElements.add(ElementDeGrille.TROIS);

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
        ElementDeGrille value = ElementDeGrille.UN;

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
        ElementDeGrille value = ElementDeGrille.DEUX;

        // Act and Assert
        Assertions.assertThrows(HorsBornesException.class, () -> grille.setValue(x, y, value));
    }

    @Test
    public void testSetValueInitialValueThrowValeurInitialeModificationException() {
        // Arrange
        int x = 1;
        int y = 1;
        ElementDeGrille value = ElementDeGrille.TROIS;

        // Act and Assert
        Assertions.assertThrows(ValeurInitialeModificationException.class, () -> grille.setValue(x, y, value));
    }

    @Test
    public void testSetValueInvalidValueThrowElementInterditException() {
        // Arrange
        int x = 2;
        int y = 2;
        ElementDeGrille value = ElementDeGrille.QUATRE;

        // Act and Assert
        Assertions.assertThrows(ElementInterditException.class, () -> grille.setValue(x, y, value));
    }
}
