import org.junit.Test;

import static org.junit.Assert.*;

public class CellulesEqualityTest {

	@Test
	public void notEquals() {
		Cellules cellules1 = new Cellules();
		cellules1.add(new LifeCellule(0, 0));
		cellules1.add(new LifeCellule(2, 1));

		Cellules cellules2 = new Cellules();
		cellules2.add(new LifeCellule(0, 0));
		cellules2.add(new LifeCellule(0, 1));

		assertNotEquals(cellules1, cellules2);
	}

	@Test
	public void sameOrder() {
		Cellules cellules1 = new Cellules();
		cellules1.add(new LifeCellule(0, 0));
		cellules1.add(new LifeCellule(0, 1));

		Cellules cellules2 = new Cellules();
		cellules2.add(new LifeCellule(0, 0));
		cellules2.add(new LifeCellule(0, 1));

		assertEquals(cellules1, cellules2);
	}

	@Test
	public void differentOrder() {
		Cellules cellules1 = new Cellules();
		cellules1.add(new LifeCellule(0, 1));
		cellules1.add(new LifeCellule(0, 0));

		Cellules cellules2 = new Cellules();
		cellules2.add(new LifeCellule(0, 0));
		cellules2.add(new LifeCellule(0, 1));

		assertEquals(cellules1, cellules2);
	}
}
