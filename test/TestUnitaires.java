import org.junit.jupiter.api.Test;

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
}
