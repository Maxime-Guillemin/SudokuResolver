import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("Une erreur s'est produite lors de la lecture du fichier de grille :");
            e.printStackTrace();
        } catch (ElementInterditException | ValeurInitialeModificationException |
                 HorsBornesException | ValeurImpossibleException e) {
            System.out.println("Une exception s'est produite lors de la résolution du sudoku :");
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
    private static InputStream getInputStreamFromRelativePath(String relativePath) throws IOException {
        // Obtient le répertoire de travail actuel de l'application
        String workingDirectory = System.getProperty("user.dir");

        // Construit le chemin absolu en concaténant le répertoire de travail avec le chemin relatif
        Path path = Paths.get(workingDirectory, relativePath);

        // Ouvre un InputStream à partir du chemin absolu
        return Files.newInputStream(path);
    }
}
