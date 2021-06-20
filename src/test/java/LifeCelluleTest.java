import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LifeCelluleTest {

    @Test
    public void testNeighbors() {

        Cellules actual = new Cellules(
                new LifeCellule(-1, -1),
                new LifeCellule(-1, 0),
                new LifeCellule(-1, 1),
                new LifeCellule(0, -1),
                new LifeCellule(0, 1),
                new LifeCellule(1, -1),
                new LifeCellule(1, 0),
                new LifeCellule(1, 1)
        );


        Cellules expected = new LifeCellule(0, 0).neighbors();


        assertEquals(actual.size(), expected.size());
    }

    @Test
    public void testEquals() {

        LifeCellule c1 = new LifeCellule(0, 0);
        LifeCellule c2 = new LifeCellule(0, 0);


        assertEquals(c1, c2);
    }
}
