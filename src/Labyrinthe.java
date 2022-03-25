import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    // Attributs décrivant le layrinthe
    private boolean [][] murs;
    private Personnage personnage;
    private Sortie sortie;

    // Constante decrivant les emplacements du labyrinthe
    // Les constantes ont etes passees en public pour permettre leur acces aux tests
    // Les constante sont de type final pour empecher leur changement
    final static char MUR = 'X';
    final static char PJ = 'P';
    final static char SORTIE ='S';
    final static char VIDE = '.';

    // Constante decrivant les mouvements du perso
    // Les constantes ont etes passees en public pour permettre leur acces aux tests
    // Les constante sont de type final pour empecher leur changement
    final static String HAUT = "haut";
    final static String BAS = "bas";
    final static String GAUCHE = "gauche";
    final static String DROITE = "droite";


    

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
        if (action == HAUT) {
            y += 1;
        } else if (action == BAS) {
            y -= 1;
        } else if (action == DROITE) {
            x += 1;
        } else if (action == GAUCHE) {
            x -= 1;
        }
        tab[0] = x;
        tab[1] = y;
        return tab;
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        // On recupere la case suivante
        int[] tab = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);
        // On réalise l action jusqu a ce que l on croise un mur
        while (this.getChar(tab[0], tab[1]) != this.MUR ){
            if (action == this.DROITE){
                // On avance le perso sur l axe des Y
                this.personnage.avancerY();
                // On incremente Y jusqu'a tomber sur le mur
                tab[1] += 1;
            }

            if (action == this.GAUCHE){
                // On recule le perso sur l axe des Y
                this.personnage.reculerY();
                // On incremente Y jusqu'a tomber sur le mur
                tab[1] = tab[1] - 1;
            }

            if (action == this.HAUT){
                // On avance le perso sur l axe des X
                this.personnage.avancerX();
                // On incremente X jusqu'a tomber sur le mur
                tab[0] = tab[0] + 1;
            }

            if (action == this.BAS){
                // On recule le perso sur l axe des X
                this.personnage.reculerX();
                // On décrémente X jusqu'a tomber sur le mur
                tab[0] = tab[0] - 1;
            }
        }
    }


    public String toString() {
        // On cree une var de res
        String res ="";

        //On fait une boucle qui va balayer toute les lignes du tableau
        for (int i = 0; i<this.murs.length;i++) {
            //On fait une boucle qui va balayer toutes les colones du tableau
            for (int j = 0; j < this.murs[i].length; j++) {
                //On ajoute au res les caractères du tableau
                res += this.getChar(i, j);
            }
            //On fait un saut de lignes pour changer de lignes
            res+="\n";
        }
        return res;

    }


    public boolean etreFini() {
        //On initialise le bouleen sur false pour le modifier en cas de fin du jeu
        boolean arret = false;
        //On verifi si le personnage est sur la sortie
        if(this.sortie.getX() == this.personnage.getX() && this.sortie.getY() == this.personnage.getY()){
            arret = true;
        }
        return arret;
    }

    public void setMurs(int x,int y){
        this.murs = new boolean [x][y];
        for(int i = 0; i<this.murs.length;i++){
            for(int j = 0; j<this.murs[i].length; j++){
                this.murs[i][j] = false;
            }
        }
    }

    // TODO : revoir fonctionnalite de methode par rapport a chargerLabyrinthe
    public void ajoutMurs(int x, int y){
        this.murs[x][y] = true;
    }

    public void setSortie(int x,int y){
        this.sortie = new Sortie(x,y);
    }

    public void setPersonnage(int x, int y){
        this.personnage = new Personnage(x,y);
    }

    // TODO : revoir la methode, ne marche pas dans les tests -> ArrayIndexOutOfBoundException
    public static Labyrinthe chargerLabyrinthe(String nom) throws FileNotFoundException, IOException {
        // On lit le fichier qui va contenir la map et la charger
        FileReader read = new FileReader(nom);
        int x,y;
        char temp = ' ';
        Labyrinthe l = new Labyrinthe();
        x = read.read();
        y = read.read();
        l.setMurs(x,y);
        for(int i = 0;i<x;i++) {
            for(int j = 0; j<y;j++){
                temp = (char) read.read();
                if(temp == MUR){
                    l.ajoutMurs(x,y);
                }
                else if (temp == SORTIE){
                    l.setSortie(x,y);
                }
                else if(temp == PJ){
                    l.setPersonnage(x,y);
                }
            }
            temp = (char) read.read();
        }
        read.close();
        return l;
    }

    // TODO : Penser a faire les tests
}
