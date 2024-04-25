public class PrimitiveIntReturnedAsLong {
    private int line;
    private int col;

    private long col2;

    // compiler error when trying to return long as int
    /*
    public int getCol2() {
        return col2;
    }
    */

    PrimitiveIntReturnedAsLong(int line, int col){
        this.line = line;
        this.col = col;
    }

    public long getLine(){
        return line;
    }

    public long getCol(){
        return col;
    }

    public static void main (String[] args) {
        PrimitiveIntReturnedAsLong primitiveIntReturnedAsLong = new PrimitiveIntReturnedAsLong(1,2);
        System.out.println(primitiveIntReturnedAsLong.getLine()+","+primitiveIntReturnedAsLong.getCol());
    }
}
