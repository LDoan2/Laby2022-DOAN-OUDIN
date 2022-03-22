/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    // Attributs décrivant le layrinthe
    private boolean [][] murs;
    private Personnage personnage;
    private Sortie sortie;

    // Constante decrivant les emplacements du labyrinthe
    private static char X;
    private static char P;
    private static char S;
    private static char .;

    // Constante decrivant les mouvements du perso
    private static String HAUT = "haut";
    private static String BAS = "bas";
    private static String GAUCHE = "gauche"
    private static String DROITE = "droite";


    

    char getChar(int x, int y) {
        char res;
        if (this.constante == "X"){
            res = "MUR";
        } else {

        }
    }


    static int[] getSuivant(int x, int y, String action) {
        int [] tab =new int[2];
        if (action == "HAUT") {
            y += 1;
        } else if (action == "BAS") {
            y -= 1;
        } else if (action == "DROITE") {
            x += 1;
        } else if (action == "GAUCHE") {
            x -= 1;
        }
        tab[0] = x;
        tab[1] = y;
        return tab;
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }


    public String toString() {
        throw new Error("TODO");
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }
}
