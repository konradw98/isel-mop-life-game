import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class CellulesNeighborsTest {

	@Test
	public void testNoNeighbors() {
		Cellules cellules = new Cellules();
		assertTrue(cellules.getNeighbors().isEmpty());
	}


}
