import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    @Test
    public void testdeplacementhaut() throws FichierIncorrectException, IOException, ActionInconnueException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        l.deplacerPerso("haut");
        assertEquals('P',l.getChar(1,3),"Le personnage n est pas au bon endroit");
    }
}
