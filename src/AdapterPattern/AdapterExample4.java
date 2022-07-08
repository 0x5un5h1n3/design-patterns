package AdapterPattern;

//The IRoundPeg interface
interface IRoundPeg {

    public void insertIntoHole(String msg);
}

//The ISquarePeg interface
interface ISquarePeg {

    public void insert(String str);
}

//The RoundPeg interface
class RoundPeg implements IRoundPeg {

    @Override
    public void insertIntoHole(String msg) {
        System.out.println("RoundPeg insertIntoHole(): " + msg);
    }
}

//The SquarePeg class
class SquarePeg implements ISquarePeg {

    @Override
    public void insert(String str) {
        System.out.println("SquarePeg insert(): " + str);
    }
}
//The PegAdapter class. This is the two-way adapter class

class PegAdapter implements ISquarePeg, IRoundPeg {

    private RoundPeg2 roundPeg;
    private SquarePeg2 squarePeg;

    public PegAdapter(RoundPeg2 peg) {
        this.roundPeg = peg;
    }

    public PegAdapter(SquarePeg2 peg) {
        this.squarePeg = peg;
    }

    @Override
    public void insert(String str) {
        roundPeg.insertIntoHole(str);
    }

    @Override
    public void insertIntoHole(String msg) {
        squarePeg.insert(msg);
    }

}

//Test program for Pegs
class TestPeg {

    public static void main(String[] args) {
        //Create some pegs
        RoundPeg2 roundPeg = new RoundPeg2();
        SquarePeg2 squarePeg = new SquarePeg2();

        //Do an insert using the square peg
        ISquarePeg roundToSquare = new PegAdapter(roundPeg);
        roundToSquare.insert("Inserting round peg..."); //RoundPeg insertIntoHole(): Inserting round peg...

        //Do an inser using the round peg
        roundPeg.insertIntoHole("Inserting round peg..."); //RoundPeg insertIntoHole(): Inserting round peg...

        //Create a two-way adapter and do an insert with it
        IRoundPeg squareToRound = new PegAdapter(squarePeg);
        squareToRound.insertIntoHole("Inserting square peg..."); // SquarePeg insert(): Inserting square peg...
    }
}
