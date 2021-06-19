public class Generation {

	private Principles principles;
	private Cellules aliveCellules;

	public Generation(Principles principles, Cellule... aliveCellules) {
		this(principles, new Cellules(aliveCellules));
	}

	public Generation(Principles principles, Cellules aliveCellules) {
		this.principles = principles;
		this.aliveCellules = aliveCellules;
	}

	public void evolve() {
		Cellules nextGenAliveCellules = new Cellules();
		aliveCellules.getNeighbors().cellules.forEach(
				cellule -> {
					if (principles.inNextGeneration(isAlive(cellule), countAliveNeighbors(cellule)))
						nextGenAliveCellules.cellules.add(cellule);
				});
		aliveCellules = nextGenAliveCellules;
	}

	public boolean isAlive(Cellule cellule) {
		return aliveCellules.contains(cellule);
	}

	public int countAliveNeighbors(Cellule cellule) {
		return (int) aliveCellules.cellules.stream()
				.filter(c -> c.neighbors().contains(cellule))
				.count();
	}

	public boolean extinct() {
		return aliveCellules.isEmpty();
	}

	public Cellules getAliveCells() {
		return aliveCellules;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Generation)) {
			return false;
		}
		Generation other = (Generation) obj;
		return aliveCellules.equals(other.aliveCellules);
	}
}
