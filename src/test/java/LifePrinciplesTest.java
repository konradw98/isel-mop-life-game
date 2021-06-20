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
	public void diesBecauseOfUnderpopulation() {
		assertFalse(principles.inNextGeneration(true, 1));
	}

	@Test
	public void staysAlive() {
		assertTrue(principles.inNextGeneration(true, 2));
		assertTrue(principles.inNextGeneration(true, 3));
	}

	@Test
	public void diesBecauseOfOverpopulation() {
		assertFalse(principles.inNextGeneration(true, 4));
	}

	@Test
	public void aCellIsBorn() {
		assertTrue(principles.inNextGeneration(false, 3));
	}
}
