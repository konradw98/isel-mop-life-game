import java.util.Objects;

public class LifeCellule implements Cellule {

    protected int i;
    protected int j;

    public LifeCellule(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Cellules neighbors() {
        return new Cellules(

                new LifeCellule(this.i - 1, this.j - 1),
                new LifeCellule(this.i - 1, this.j),
                new LifeCellule(this.i - 1, this.j + 1),
                new LifeCellule(this.i, this.j - 1),
                new LifeCellule(this.i, this.j + 1),
                new LifeCellule(this.i + 1, this.j - 1),
                new LifeCellule(this.i + 1, this.j),
                new LifeCellule(this.i + 1, this.j + 1)
        );
    }

    @Override
    public String toString() {
        return "c(" + i + ":" + j + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        LifeCellule that = (LifeCellule) o;

        return i == that.i && j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
