import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Cellules implements Iterable<Cellule> {

    protected HashSet<Cellule> cellules;

    public Cellules(Cellule... cellules) {
        this.cellules = new HashSet<Cellule>(Arrays.asList(cellules));
    }

    public Cellules() {
        this.cellules = new HashSet<>();
    }

    public Cellules getNeighbors() {
        return new Cellules(cellules.stream()
                .map(Cellule::neighbors).flatMap(neighbor -> neighbor.cellules.stream()).distinct().toArray(Cellule[]::new));
    }

    public boolean isEmpty() {
        return cellules.isEmpty();
    }

    public int size() {
        return cellules.size();
    }

    public void add(Cellule cellule) {
        if (cellules.contains(cellule))
        {
            return;
        }

        cellules.add(cellule);
    }

    public void addAll(Iterable<? extends Cellule> cellules) {

        cellules.forEach((cell) -> {
            add(cell);

        });
    }

    @Override
    public Iterator<Cellule> iterator() {
        return cellules.iterator();
    }

    public boolean contains(Cellule cellule) {
        return cellules.contains(cellule);
    }

    public void remove(Cellule cellule) {
        cellules.remove(cellule);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cellules)) {
            return false;
        }

        Cellules other = (Cellules) obj;

        if (!cellules.stream().noneMatch((cellule) -> (!other.contains(cellule)))) {

            return false;
        }
        if (!other.cellules.stream().noneMatch((cellule) -> (!contains(cellule)))) {

            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return cellules.toString();
    }

}
