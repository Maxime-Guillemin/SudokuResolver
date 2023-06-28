import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurInitialeModificationException;

/**
 * Classe pour résoudre un Sudoku.
 */
public final class SudokuSolver implements Solveur {

    /**
     * Résoudre la grille de Sudoku.
     *
     * @param grille la grille de Sudoku à résoudre
     * @return true si la grille est résolue, sinon false
     */
    @Override
    public boolean solve(final Grille grille)
            throws HorsBornesException,
            ElementInterditException, ValeurInitialeModificationException {
        // Vérifier si la grille est complète
        if (grille.isComplete()) {
            return true;  // La grille est déjà résolue
        }

        // Trouver la prochaine case vide dans la grille
        // en utilisant une approche basée sur les contraintes
        int[] coordonnees = grille.trouverProchaineCaseVide();
        if (coordonnees == null) {
            return false;
            // Aucune case vide n'est trouvée,
            // la grille ne peut pas être résolue
        }

        int row = coordonnees[0];
        int col = coordonnees[1];

        for (ElementDeGrille value : grille.getElements()) {
                try {
                            if (grille.isPossible(row, col, value)) {
                                // Placer la valeur dans la case
                                grille.setValue(row, col, value);

                                // Résoudre récursivement la grille
                                // avec la nouvelle valeur
                                if (solve(grille)) {
                                    return true;  // La grille a été résolue
                                }

                                // Annuler la valeur précédente
                                grille.setValue(row, col, null);
                            }
                } catch (Exception e) {
                    // Une exception s'est produite, arrêter la résolution
                    e.printStackTrace();
                    return false;
                }
        }
        return false;
        // La grille ne peut pas être
        // résolue car dimension 0,0
    }
}
