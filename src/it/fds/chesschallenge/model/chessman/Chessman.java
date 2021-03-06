package it.fds.chesschallenge.model.chessman;

import it.fds.chesschallenge.model.chessboard.ChessBoard;



/**
 * @author DamianoG
 * 
 * This class models a generic chessman, the methos isThreatening(...) must be implemented by the specialized subclass
 * 
 */
public abstract class Chessman implements Cloneable{

    private int id;

    protected int x;

    protected int y;

    /**
     * @param id a unique identifier for this chessman
     */
    protected Chessman(int id){
        this.id = id;
    }

    /**
     * 
     * @param id a unique identifier for this chessman
     * @param x an initial horizontal chessman coordinate
     * @param y an initial vertical chessman coordinate
     */
    protected Chessman(int id, int x, int y){
        this.id = id;
        setPos(x, y);
    }
    
    public abstract boolean isThreatening(ChessBoard board);
    
    /**
     * Checks if at least one more chessman is placed along the X or Y axes where <b>this</b> chessman is placed 
     * 
     * @param goDeep set the flag to true to check all the tiles along x and y, false just to check for the adjacent tiles
     * @param positionMatrix the representation of the chessmen positions over the chessboard as a boolean matrix
     * @return true if at least one chessman is found on the checked tiles, false otherwise
     */
    public boolean checkXY(boolean goDeep, ChessBoard board){
        int n = board.getWidth();
        int m = board.getHeight();
        if(!goDeep){
            return (!board.isOutsideBounds(x + 1, y) && board.isOccupied(x + 1, y))
                    || (!board.isOutsideBounds(x, y + 1) && board.isOccupied(x, y + 1))
                    || (!board.isOutsideBounds(x - 1, y) && board.isOccupied(x - 1, y))
                    || (!board.isOutsideBounds(x, y - 1) && board.isOccupied(x, y - 1));
        }
        for(int i=0; i<n; i++){
            if(i!=x && board.isOccupied(i, y)){
                return true;
            }   
        }
        for(int i=0; i<m; i++){
            if(i!=y && board.isOccupied(x, i)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if at least another one chessman is placed along the two diagonals built from <b>this</b> chessman position 
     * 
     * @param goDeep set the flag to true to check all the tiles along x and y, false just to check for the adjacent tiles
     * @param positionMatrix the representation of the chessmen positions over the chessboard as a boolean matrix
     * @return true if at least one chessman is found on the checked tiles, false otherwise
     */
    public boolean checkDiagonal(boolean goDeep, ChessBoard board){
        int n = board.getWidth();
        int m = board.getHeight();
        
        for(int i=1; x-i>=0 && y-i>=0; i++){
            if( board.isOccupied(x-i, y-i) && i!=0){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x+i<n && y+i<m; i++){
            if( board.isOccupied(x+i, y+i) && i!=0){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x-i>=0 && y+i<m; i++){
            if( board.isOccupied(x-i, y+i) && i!=0){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x+i<m && y-i>=0; i++){
            if(board.isOccupied(x+i, y-i) && i!=0){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        return false;
    }
    
    public boolean isOutsideChessboard(ChessBoard board){
        return board.isOutsideBounds(this);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Set the position of this chessman taking in input an array which its length is equals to 2
     * @param pos a not null 2-length array with all positions not null.
     */
    public void setPos(Integer position[]) {
        if(position==null){
            throw new IllegalArgumentException("the position array is null...");
        }
        if(position.length!=2 || position[0]==null || position[1]==null){
            throw new IllegalArgumentException("The position array is not valid, value is: '" + position.toString() + "'");
        }
        this.x = position[0];
        this.y = position[1];
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Chessman)){
           return false;
        }
        if(o == this){
            return true;
        }
        Chessman o1 = ((Chessman)o);
        if(x == o1.getX() && y == o1.getY()){
            return true;
        }
        return false;
    }
    
    public int hashPosition(){
        return hashPosition(x, y);
    }
    
    public static int hashPosition(int x, int y){
        return ("(" + x + "," + y + ")").hashCode();
    }
    
    public static int hashPosition2(int x, int y){
        int hashResult = 67;
        hashResult = 37 * hashResult + x*10;
        hashResult = 37 * hashResult + y*20;
        return hashResult;
    }    
    
    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // Swallow the exception
        }
        return new Object();
    }
    
    @Override
    public int hashCode() {
        int hashResult = 67;
        hashResult = 37 * hashResult + hashPosition();
        hashResult =  37 * hashResult + this.getClass().hashCode();
        return hashResult;
    }
    
    @Override
    public String toString(){
        return "(" + this.getClass().getSimpleName() + ") x:'" + x + "'y:'" + y + "'"/*\n*/;
    }
    
    
    
}
