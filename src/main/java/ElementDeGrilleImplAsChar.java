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
}
