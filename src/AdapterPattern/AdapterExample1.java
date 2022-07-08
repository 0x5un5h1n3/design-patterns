package AdapterPattern;

class SquarePeg2 {
    
    public void insert(String str) {
        System.out.println("SquarePeg insert(): " + str); // SquarePeg insert(): Insert square peg...
    }
}

class RoundPeg2 {
    
    public void insertIntoHole(String msg) {
        System.out.println("RoundPeg inserIntoHole(): " + msg); //RoundPeg inserIntoHole(): Insering round peg...
    }
}

class RoundToSquarePegAdapter extends SquarePeg2 {
    
    private RoundPeg2 roundPeg;
    
    public RoundToSquarePegAdapter(RoundPeg2 peg) {
        this.roundPeg = peg;
    }
    
    @Override
    public void insert(String str) {
        roundPeg.insertIntoHole(str);
    }
}

class ObjectAdapter {

    public static void main(String[] args) {
        RoundPeg2 roundPeg = new RoundPeg2();
        SquarePeg2 squarePeg = new SquarePeg2();
        
        squarePeg.insert("Insert square peg...");
        
        RoundToSquarePegAdapter adapter = new RoundToSquarePegAdapter(roundPeg);
        adapter.insert("Insering round peg...");
    }
}
