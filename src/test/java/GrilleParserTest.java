import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GrilleParserTest {

    @Test
    public void testParseWithValidInput() throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException, IOException, ValeurImpossibleException {
        String input = "-1234\n" +
                "2---\n" +
                "1--3\n" +
                "3--4\n" +
                "-1-2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            Grille grille = GrilleParser.parse(inputStream);

            // Assert the properties of the parsed grid
            Assertions.assertEquals(4, grille.getDimension());

            ElementDeGrille value = grille.getValue(0, 1);
            Assertions.assertNull(value);
    }

    // ...

}
