
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
            if ((this.sortie.getX() == x) && (this.sortie.getY() == y)){
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

    // TODO : a eventuellement modifier dans le cas ou il s affiche mal dans le main
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
        this.murs = new boolean[x][y];
    }

    public void ajoutMurs(int x, int y){
        this.murs[x][y] = true;
    }

    public void setSortie(int x,int y){
        this.sortie = new Sortie(x,y);
    }

    public void setPersonnage(int x, int y){
        this.personnage = new Personnage(x,y);
    }

    public void setVide(int x, int y){
        this.murs[x][y] = false;
    }


    // TODO : penser a gerer les exceptions
    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {

            // On lit les characteres du fichier
            Reader reader = new FileReader(nom);
            // On lit les lignes du fichier
            BufferedReader bReader = new BufferedReader(reader);

            // On regarde les premieres lignes
            int nbLignes = Integer.parseInt(bReader.readLine());
            // On lit la ligne suivante
            int nbColonnes = Integer.parseInt(bReader.readLine());
            // On initialise le labyrinthe qui sera retourne
            Labyrinthe l = new Labyrinthe();

            // On connait le nombre de lignes et colonnes, on peut creer le tableau de murs
            l.setMurs(nbLignes, nbColonnes);

            // On parcourt le labyrinthe
            // On parcourt l'ensemble des lignes

            int i;
            int j;

            for (i = 0; i < nbLignes; i++) {
                // On change de ligne a chaque iteration
                // On parcourt les characteres que composent la ligne
                for (j = 0; j < nbColonnes; j++) {
                    char temp = (char) bReader.read();
                    if (temp == MUR) {
                        l.ajoutMurs(i, j);
                    }
                    if (temp == SORTIE) {
                        l.setSortie(i, j);
                    }
                    if (temp == PJ) {
                        l.setPersonnage(i, j);
                    }
                    if (temp != VIDE && temp != MUR && temp != SORTIE && temp != PJ) {
                        throw new FichierIncorrectException("caractere inconnu " + temp);
                    }

                }
                // On lit la prochaine ligne
                bReader.readLine();
            }
            // On ferme le bufferedReader
            bReader.close();

            // Exceptions
            BufferedReader bReader2 = new BufferedReader(new FileReader(nom));
            // On passe les lignes inutiles
            bReader2.readLine();
            bReader2.readLine();
            // Les colonnes que l'on va compter
            int nbC = 0;
            boolean trouve = false;
            char temp = (char) bReader2.read();
            int compteurP = 0;
            int compteurS= 0;

            // On compte le nombre de colonnes
            while (trouve == false) {
                temp = (char) bReader2.read();
                if (temp == '\n') {
                    trouve = true;
                }
                else{
                nbC += 1;
                }

            }
            // On parcours le tableau pour compter les persos et sorties
            for (int k = 0; k < nbLignes; k++){
                for (int m = 0; m < nbColonnes; m++){
                    if (l.getChar(k, m) == SORTIE){
                        compteurS += 1;
                    }
                    if (l.getChar(k, m) == PJ){
                        compteurP += 1;
                    }
                }
            }
            // On compte les persos
            if (compteurP == 0){
                throw new FichierIncorrectException("personnage inconnu");
            } else {
                if (compteurP > 1){
                    throw new FichierIncorrectException(("plusieurs personnages"));
                }
            }
            // On compte les sorties
            if (compteurS == 0){
                throw new FichierIncorrectException("sortie inconnu");
            } else {
                if (compteurS > 1){
                    throw new FichierIncorrectException(("plusieurs sorties"));
                }
            }

            // On regarde si c est bien le bon nombre de lignes et colonnes
            if (i != nbLignes) {
                throw new FichierIncorrectException("nbLignes ne correspond pas");
            }
            if (nbC != nbColonnes) {
                throw new FichierIncorrectException("nbColonnes ne correspond pas "+nbC+" != "+nbColonnes);
            }


            // On return le lab
            return (l);


    }

}
