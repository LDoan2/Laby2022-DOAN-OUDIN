import java.io.*;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    // Attributs décrivant le layrinthe
    private boolean [][] murs;
    private Personnage personnage;
    private Sortie sortie;

    // Constante decrivant les emplacements du labyrinthe
    private static char MUR = 'X';
    private static char PJ = 'P';
    private static char SORTIE ='S';
    private static char VIDE = '.';

    // Constante decrivant les mouvements du perso
    private static String HAUT = "haut";
    private static String BAS = "bas";
    private static String GAUCHE = "gauche"
    private static String DROITE = "droite";


    

    char getChar(int x, int y) {
        // On cree un var permettant de stocker le res
        char res;
        // On verifie si la case selectionnee n est pas un mur
        if (this.murs[x][y] == false ){
            // On regarde si la case correspond a celle de la sortie
            if (this.sortie.getX() == x && this.sortie.getY() == y){
                res = this.SORTIE;
            } else {
                // On regarde si la case correspond a celle du perso
                if (this.personnage.getX() == x && this.personnage.getY() == y){
                    res = this.PJ;
                } else {
                    res = this.VIDE;
                }
            }
        } else {
            res = this.MUR;
        }

        // On return le char correspondant
        return(res);
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
        /** On lit le fichier qui va contenir la map et la charger
        FileReader read = new FileReader(nom);
         *//
        throw new Error("TODO");

    }
}
