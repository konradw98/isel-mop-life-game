public class LifePrinciples implements Principles {

	@Override
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {

		if (alive && (numberOfNeighbors == 2 || numberOfNeighbors == 3))
			return true;
		else return !alive && numberOfNeighbors == 3;
	}

}
