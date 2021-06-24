import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class LifeConsole {

    public static void main(String[] args) throws InterruptedException {
        final ConsoleView consoleView = new ConsoleView();
        final Principles principles= new LifePrinciples();

        System.out.println("BLOCK TEST---------------------------------------");

        Generation generation1 = new Generation(principles, new LifeCellule(2, 2), new LifeCellule(2, 3),
                new LifeCellule(3, 3), new LifeCellule(3, 2));

        for (int i = 0; i < 10; i++) {
            System.out.println("STEP:" + i);
            consoleView.displayGeneration(generation1, 10, 10);
            generation1.evolve();
            //Thread.sleep(300);
        }

        System.out.println("BOAT TEST----------------------------------------");
        Generation generation2 = new Generation(principles, new LifeCellule(2, 2),
                new LifeCellule(2, 3), new LifeCellule(3, 2), new LifeCellule(3, 4),
                new LifeCellule(4, 3));

        for (int i = 0; i < 10; i++) {
            System.out.println("STEP:" + i);
            consoleView.displayGeneration(generation2, 10, 10);
            generation2.evolve();

        }

        System.out.println("BLINKER TEST---------------------------------------");
        Generation generation3 = new Generation(principles, new LifeCellule(2, 2),
                new LifeCellule(2, 3), new LifeCellule(2, 4));

        for (int i = 0; i < 10; i++) {
            System.out.println("STEP:" + i);
            consoleView.displayGeneration(generation3, 10, 10);
            generation3.evolve();

        }

        System.out.println("=====================NORMAL GAME=========================");

        Generation generation = new Generation(principles,
                new LifeCellule(0, 0), new LifeCellule(1, 0),
                new LifeCellule(0, 1), new LifeCellule(2, 2), new LifeCellule(3, 4), new LifeCellule(6, 8),
                new LifeCellule(0, 2), new LifeCellule(0, 4), new LifeCellule(0, 5), new LifeCellule(0, 8),
                new LifeCellule(1, 2), new LifeCellule(1, 4), new LifeCellule(1, 5), new LifeCellule(1, 9),
                new LifeCellule(8, 8), new LifeCellule(3, 7), new LifeCellule(3, 9), new LifeCellule(2, 5),
                new LifeCellule(3, 7), new LifeCellule(4, 6), new LifeCellule(4, 7), new LifeCellule(5, 8),
                new LifeCellule(5, 9), new LifeCellule(5, 10), new LifeCellule(2, 4), new LifeCellule(2, 5),
                new LifeCellule(4, 8), new LifeCellule(4, 9), new LifeCellule(4, 10)
        );


        for (int i = 0; i < 20; i++) {
            System.out.println("STEP:" + i);
            consoleView.displayGeneration(generation, 10, 10);
            generation.evolve();
            Thread.sleep(200);
        }

        System.out.println("=====================REAL GAME=========================");

        System.out.println("How many percent of cells will be alive at the beginning?");
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Cellules cellules = new Cellules();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            cellules.add(new LifeCellule(random.nextInt(10), random.nextInt(10)));
        }
        Generation generation4 = new Generation(principles, cellules);
        for (int i = 0; i < 20; i++) {
            System.out.println("STEP:" + i);
            consoleView.displayGeneration(generation4, 10, 10);
            generation4.evolve();
            Thread.sleep(200);
        }
    }
}
