import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Main class represents the entry point for solving a Sudoku puzzle.
 * It reads a Sudoku grid from a file, solves the puzzle, and prints the result.
 */
public final class Main {
    /**
     * Constructeur privé pour empêcher l'instanciation de la
     * classe utilitaire.
     * Lève une UnsupportedOperationException pour indiquer
     * que cette classe ne peut pas être instanciée.
     *
     * @throws UnsupportedOperationException si une tentative
     * est faite pour instancier la classe utilitaire
     */
    private Main() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated.");
    }
    /**
     * The main method is the entry point for the program.
     * It reads a Sudoku grid from a file, solves the puzzle,
     * and prints the result.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(final String[] args) {
        String fichierGrille = "grille/sudoku16-a.txt";

        try (InputStream in = getInputStreamFromRelativePath(fichierGrille)) {
            Grille grille = GrilleParser.parse(in);
            SudokuSolver solver = new SudokuSolver();

            // Résolution du sudoku
            boolean solved = solver.solve(grille);

            if (solved) {
                // Affichage de la grille résolue
                System.out.println("Grille résolue");
            } else {
                System.out.println("La grille ne peut pas être résolue.");
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors "
                    +
                    "de la lecture du fichier de grille :");
            e.printStackTrace();
        } catch (ElementInterditException
                 | ValeurInitialeModificationException
                 | HorsBornesException
                 | ValeurImpossibleException e) {
            System.out.println("Une exception s'est produite "
                    +
                    "lors de la résolution du sudoku :");
            e.printStackTrace();
        }
    }

    /**
     * Obtient un InputStream à partir d'un chemin relatif.
     *
     * @param relativePath chemin relatif du fichier
     * @return InputStream correspondant au fichier
     * @throws IOException si une erreur de lecture du fichier se produit
     */
    private static InputStream
    getInputStreamFromRelativePath(final String relativePath)
            throws IOException {
        // Obtient le répertoire de travail actuel de l'application
        String workingDirectory = System.getProperty("user.dir");

        // Construit le chemin absolu en concaténant le répertoire
        // de travail avec le chemin relatif
        Path path = Paths.get(workingDirectory, relativePath);

        // Ouvre un InputStream à partir du chemin absolu
        return Files.newInputStream(path);
    }
}
