public class LifeConsole {

    public static void main(String[] args) {
        Generation generation = new Generation(new LifePrinciples(),
                new LifeCellule(0, 0), new LifeCellule(1, 0),
                new LifeCellule(0, 1), new LifeCellule(2, 2),new LifeCellule(3, 4),new LifeCellule(6, 8),
                new LifeCellule(0, 2), new LifeCellule(0, 4),new LifeCellule(0, 5),new LifeCellule(0, 8),
                new LifeCellule(1, 2), new LifeCellule(1, 4),new LifeCellule(1, 5),new LifeCellule(1, 9),
                new LifeCellule(8, 8),new LifeCellule(3, 7),new LifeCellule(3, 9),new LifeCellule(2, 5));

        ConsoleView consoleDisplayDriver= new ConsoleView();

        consoleDisplayDriver.displayGeneration(generation,10,10);
        for(int i=0;i<10;i++){
            generation.evolve();
        consoleDisplayDriver.displayGeneration(generation,10,10);}

    }
    }
