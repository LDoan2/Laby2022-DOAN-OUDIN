import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FichierIncorrectException, IOException, ActionInconnueException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        System.out.println(l.toString());
        l.deplacerPerso(Labyrinthe.BAS);
        System.out.println(l.toString());
    }
}
