import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifePrinciplesTest {

	private LifePrinciples principles;

	@Before
	public void setUp() {
		principles = new LifePrinciples();
	}



	@Test
	public void staysAlive() {
		assertTrue(principles.inNextGeneration(true, 2));
		assertTrue(principles.inNextGeneration(true, 3));
	}

	@Test
	public void aCelluleIsBorn() {
		assertTrue(principles.inNextGeneration(false, 3));
	}

	@Test
	public void diesBecauseOfUnderpopulation() {
		assertFalse(principles.inNextGeneration(true, 0));
	}

	@Test
	public void diesBecauseOfUnderpopulation1() {
		assertFalse(principles.inNextGeneration(true, 1));
	}

	// WITH 3 NEIGHBORS CELLLULE IS BORN

	@Test
	public void diesBecauseOfOverpopulation() {
		assertFalse(principles.inNextGeneration(true, 4));
	}

	@Test
	public void diesBecauseOfOverpopulation1() {
		assertFalse(principles.inNextGeneration(true, 5));
	}

	@Test
	public void diesBecauseOfOverpopulation2() {
		assertFalse(principles.inNextGeneration(true, 6));
	}

	@Test
	public void diesBecauseOfOverpopulation3() {
		assertFalse(principles.inNextGeneration(true, 7));
	}

	@Test
	public void diesBecauseOfOverpopulation4() {
		assertFalse(principles.inNextGeneration(true, 8));
	}



}
