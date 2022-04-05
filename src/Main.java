import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FichierIncorrectException, IOException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        System.out.println(l.toString());
    }
}
