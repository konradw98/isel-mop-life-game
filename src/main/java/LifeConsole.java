public class LifeConsole {

    public static void main(String[] args) {
        System.out.println("================================TESTS FOR PROGRAM LOGIC=====================================");

        //equality test
        Cellules cellules1 = new Cellules();
        cellules1.add(new LifeCellule(0, 0));
        cellules1.add(new LifeCellule(2, 1));

        Cellules cellules2 = new Cellules();
        cellules2.add(new LifeCellule(0, 0));
        cellules2.add(new LifeCellule(0, 1));

        System.out.println("CELLS NOT EQUALS TEST="+!cellules1.equals(cellules2));

        //same order test
        Cellules cellules3 = new Cellules();
        cellules3.add(new LifeCellule(0, 0));
        cellules3.add(new LifeCellule(0, 1));

        Cellules cellules4 = new Cellules();
        cellules4.add(new LifeCellule(0, 0));
        cellules4.add(new LifeCellule(0, 1));

        System.out.println("CELLS SAME ORDER TEST="+cellules3.equals(cellules4));

        //different order test
        Cellules cellules5 = new Cellules();
        cellules5.add(new LifeCellule(0, 1));
        cellules5.add(new LifeCellule(0, 0));

        Cellules cells6 = new Cellules();
        cells6.add(new LifeCellule(0, 0));
        cells6.add(new LifeCellule(0, 1));

        System.out.println("CELLS DFFERENT ORDER TEST="+cellules4.equals(cellules5));

        //No neighbours test
        Cellules cellules7= new Cellules();
        System.out.println("CELLS NO NEIGBOURS TEST="+cellules7.getNeighbors().isEmpty());

        //CONWAYS CELL TEST

        Cellules actual = new Cellules(
                new LifeCellule(-1, -1),
                new LifeCellule(-1, 0),
                new LifeCellule(-1, 1),
                new LifeCellule(0, -1),
                new LifeCellule(0, 1),
                new LifeCellule(1, -1),
                new LifeCellule(1, 0),
                new LifeCellule(1, 1)
        );


        Cellules expected = new LifeCellule(0, 0).neighbors();

        System.out.println("CONWAYS CELL TEST1="+(actual.size()==expected.size()));

        //conwaycell test 2
        LifeCellule c1 = new LifeCellule(0, 0);
        LifeCellule c2 = new LifeCellule(0, 0);

        System.out.println("CONWAYS CELL TEST2="+c1.equals(c2));

        // CONWAY RULES TEST
        LifePrinciples principles= new LifePrinciples();
        System.out.println("CONWAY RULES TEST  ALIVE AND 2 NEIGHBOURS="+principles.inNextGeneration(true,2));//TRUE
        System.out.println("CONWAY RULES TEST  ALIVE AND 3 NEIGHBOURS="+principles.inNextGeneration(true,3));//TRUE
        System.out.println("CONWAY RULES TEST  ALIVE AND 4 NEIGHBOURS="+principles.inNextGeneration(true,4));
        System.out.println("CONWAY RULES TEST  ALIVE AND 5 NEIGHBOURS="+principles.inNextGeneration(true,5));
        System.out.println("CONWAY RULES TEST  ALIVE AND 6 NEIGHBOURS="+principles.inNextGeneration(true,6));
        System.out.println("CONWAY RULES TEST  ALIVE AND 7 NEIGHBOURS="+principles.inNextGeneration(true,7));
        System.out.println("CONWAY RULES TEST  ALIVE AND 8 NEIGHBOURS="+principles.inNextGeneration(true,8));
        System.out.println("CONWAY RULES TEST  DEAD AND 3 NEIGHBOURS="+principles.inNextGeneration(false,3));//TRUE
        System.out.println("CONWAY RULES TEST  DEAD AND 4 NEIGHBOURS="+principles.inNextGeneration(false,4));
        System.out.println("CONWAY RULES TEST  DEAD AND 5 NEIGHBOURS="+principles.inNextGeneration(false,5));
        System.out.println("CONWAY RULES TEST  DEAD AND 6 NEIGHBOURS="+principles.inNextGeneration(false,6));
        System.out.println("CONWAY RULES TEST  DEAD AND 7 NEIGHBOURS="+principles.inNextGeneration(false,8));
        System.out.println("CONWAY RULES TEST  DEAD AND 8 NEIGHBOURS="+principles.inNextGeneration(false,8));

        //GENERATION TEST
        Generation cells10 = new Generation(new LifePrinciples(), new LifeCellule(0, 0),
                new LifeCellule(0, 1), new LifeCellule(1, 1), new LifeCellule(1, 0));
        cells10.evolve();
        System.out.println("EMPTY ALIVE CELLS TEST="+ cells10.extinct());

        Generation newCells11=new Generation(new LifePrinciples(), new LifeCellule(0, 0), new LifeCellule(0,
                1), new LifeCellule(1, 1), new LifeCellule(1, 0));

        System.out.println("EVOLVE TEST (cells10 MUST BE EQUAL newCells11)="+cells10.equals(newCells11));

        Generation generation = new Generation(new LifePrinciples(),
                new LifeCellule(0, 0), new LifeCellule(1, 0),
                new LifeCellule(0, 1), new LifeCellule(2, 2),new LifeCellule(3, 4),new LifeCellule(6, 8),
                new LifeCellule(0, 2), new LifeCellule(0, 4),new LifeCellule(0, 5),new LifeCellule(0, 8),
                new LifeCellule(1, 2), new LifeCellule(1, 4),new LifeCellule(1, 5),new LifeCellule(1, 9),
                new LifeCellule(8, 8),new LifeCellule(3, 7),new LifeCellule(3, 9),new LifeCellule(2, 5));

        ConsoleView consoleView= new ConsoleView();

        consoleView.displayGeneration(generation,10,10);
        for(int i=0;i<10;i++){
            generation.evolve();
        consoleView.displayGeneration(generation,10,10);}

    }
    }
