import java.util.Objects;

public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    private char value;

    public ElementDeGrilleImplAsChar(char value) {
        this.value = value;
    }

    // Ajoutez les méthodes nécessaires


    @Override
    public String toString() {
        return  String.valueOf(value) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementDeGrilleImplAsChar that = (ElementDeGrilleImplAsChar) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
