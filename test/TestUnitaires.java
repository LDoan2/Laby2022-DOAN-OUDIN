import org.junit.jupiter.api.Test;

import java.security.spec.ECField;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitaires {

    @Test
    public void test_deplacer() throws Exception{
        // On cree et charge un nouveau labyrinthe
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // On verifie l'emplacement de base du PJ et de la sortie
        assertEquals(l.getChar(2,3),Labyrinthe.PJ);
        assertEquals(l.getChar(1,1),Labyrinthe.SORTIE);

        // On test
        l.deplacerPerso("haut");
        l.deplacerPerso("haut");
        // On verifie
        assertEquals(l.getChar(1,3),Labyrinthe.PJ);

        // On test
        l.deplacerPerso("gauche");
        assertEquals(l.getChar(1,3),Labyrinthe.VIDE);
        assertEquals(l.getChar(1,1),Labyrinthe.SORTIE);
    }

    @Test
    public void test_Exception_Pj() throws Exception{
        boolean erreur = false;
        // On cree le nouveau labx
        try {
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_pas_PJ.txt");
            // On verifie si c est la bonne exception renvoyee
        } catch(FichierIncorrectException e){
            erreur = true;
        }
        assertEquals(true,erreur,"L'erreur ne c'est pas declanchee");
    }

    @Test
    public void test_Exception_Sortie() throws Exception {
        boolean erreur = false;
        try {
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");
        }catch(FichierIncorrectException e){
            erreur = true;
        }
        assertEquals(true,erreur,"L'erreur ne c'est pas declanchee");
    }




}
