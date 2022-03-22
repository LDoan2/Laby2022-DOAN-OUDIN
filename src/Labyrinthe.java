/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {
    private  static char constante;
    private boolean [][] murs;
    private Personnage personnage;
    private Sortie sortie;

    char getChar(int x, int y) {
        char res;
        res = murs[x][y];
        // On return le char
        return(res);
    }


    static int[] getSuivant(int x, int y, String action) {
        throw new Error("TODO");
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
