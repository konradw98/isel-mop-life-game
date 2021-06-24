public class ConsoleView implements View {


    @Override
    public void displayGeneration(Generation generation, int rows, int columns) {
        boolean[][] table = toTable(generation.getAliveCells(), rows, columns);

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[0].length; j++) {
                if(table[i][j]){
                    System.out.print("o");
                } else {System.out.print("*");} // chnaging view
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean[][] toTable(Cellules cellules, int rows, int columns) {
        boolean[][] grid = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cellules.contains(new LifeCellule(i, j))) {
                    grid[i][j] = true;
                }
            }
        }
        return grid;
    }


}
