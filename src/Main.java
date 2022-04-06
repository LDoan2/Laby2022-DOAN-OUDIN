import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FichierIncorrectException, IOException, ActionInconnueException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom du labyrinthe :");
        String ch = sc.nextLine();
        Labyrinthe l = Labyrinthe.chargerLabyrinthe(ch);
        System.out.println(l.toString());
        while(!l.etreFini()) {
            System.out.println("Prochaine action :");
            ch = sc.next();
            l.deplacerPerso(ch);
            System.out.println(l.toString());
        }
        System.out.println("Gagner!!");
    }
}
