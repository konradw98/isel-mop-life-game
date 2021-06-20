public class LifeConsole {

    public static void main(String[] args) throws InterruptedException {
        ConsoleView consoleView = new ConsoleView();



        System.out.println("=====================BLOCK TEST=========================");

        Generation generation1 = new Generation(new LifePrinciples(), new LifeCellule(2, 2), new LifeCellule(2, 3),
                new LifeCellule(3, 3), new LifeCellule(3, 2));

        for (int i = 0; i < 10; i++) {

            consoleView.displayGeneration(generation1, 10, 10);
            generation1.evolve();
            //Thread.sleep(300);
        }

        System.out.println("=====================BOAT TEST=========================");
        Generation generation2 = new Generation(new LifePrinciples(), new LifeCellule(2, 2),
                new LifeCellule(2, 3), new LifeCellule(3, 2), new LifeCellule(3, 4),
                new LifeCellule(4, 3));

        for (int i = 0; i < 10; i++) {

            consoleView.displayGeneration(generation2, 10, 10);
            generation2.evolve();

        }

        System.out.println("=====================BLINKER TEST=========================");
        Generation generation3 = new Generation(new LifePrinciples(), new LifeCellule(2, 2),
                new LifeCellule(2, 3), new LifeCellule(2, 4));

        for (int i = 0; i < 10; i++) {
            consoleView.displayGeneration(generation3, 10, 10);
            generation3.evolve();

        }

        System.out.println("=====================NORMAL GAME=========================");

        Generation generation = new Generation(new LifePrinciples(),
                new LifeCellule(0, 0), new LifeCellule(1, 0),
                new LifeCellule(0, 1), new LifeCellule(2, 2), new LifeCellule(3, 4), new LifeCellule(6, 8),
                new LifeCellule(0, 2), new LifeCellule(0, 4), new LifeCellule(0, 5), new LifeCellule(0, 8),
                new LifeCellule(1, 2), new LifeCellule(1, 4), new LifeCellule(1, 5), new LifeCellule(1, 9),
                new LifeCellule(8, 8), new LifeCellule(3, 7), new LifeCellule(3, 9), new LifeCellule(2, 5));




        for (int i = 0; i < 100; i++) {

            consoleView.displayGeneration(generation, 10, 10);
            generation.evolve();
            Thread.sleep(300);
        }


    }
}
