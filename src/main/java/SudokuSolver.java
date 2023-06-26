import exception.ElementInterditException;
import exception.HorsBornesException;
import exception.ValeurImpossibleException;
import exception.ValeurInitialeModificationException;

public class SudokuSolver implements Solveur {

    @Override
    public boolean solve(Grille grille) {
        // Vérifier si la grille est complète
        if (grille.isComplete()) {
            return true;  // La grille est déjà résolue
        }

        // Trouver la prochaine case vide dans la grille
        int dimension = grille.getDimension();
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                try {
                    if (grille.getValue(row, col) == null) {
                        // Essayer chaque valeur possible dans la case vide
                        for (ElementDeGrille value : grille.getElements()) {
                            if (grille.isPossible(row, col, value)) {
                                // Placer la valeur dans la case
                                grille.setValue(row, col, value);

                                // Résoudre récursivement la grille avec la nouvelle valeur
                                if (solve(grille)) {
                                    return true;  // La grille a été résolue
                                }

                                // Annuler la valeur précédente
                                grille.setValue(row, col, null);
                            }
                        }

                        // Aucune valeur possible n'a permis de résoudre la grille
                        return false;
                    }
                } catch (Exception e) {
                    // Une exception s'est produite, arrêter la résolution
                    e.printStackTrace();
                    return false;
                }
            }
        }

        return false;  // La grille ne peut pas être résolue car dimension 0,0
    }
}
