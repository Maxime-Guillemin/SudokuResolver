/**
 * package-info.java: toutes les infos sur le package.
 */

import java.util.Objects;

/**
 *  Implémentation de la classe ElementDeGrilleImplAsChar.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
     * Déclaration pour la valeur dans une grille.
     */
    private char value;

    /**
     * Constructeur de la classe ElementDeGrilleImplAsChar.
     *
     * @param pValue valeur pour l'élément de la grille
     */
    public ElementDeGrilleImplAsChar(final char pValue) {
        this.value = pValue;
    }

    // Ajoutez les méthodes nécessaires


    /**
     * Renvoie dans une chaîne de caractère.
     *
     * @return
     */
    @Override
    public final String toString() {
        return String.valueOf(value);
    }

    /**
     * Fonction équals.
     *
     * @param o Objet élément
     * @return
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ElementDeGrilleImplAsChar that = (ElementDeGrilleImplAsChar) o;
        return value == that.value;
    }

    /**
     * Retour le hash de l'objet.
     *
     * @return
     */
    @Override
    public final int hashCode() {
        return Objects.hash(value);
    }
}
