package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 * 
 * This class models a generic chessman, the methos isThreatening(...) must be implemented by the specialized subclass
 * 
 */
public abstract class Chessman implements Cloneable{

    private int id;

    private int x;

    private int y;

    protected Chessman(int id){
        this.id = id;
    }
    
    public abstract boolean isThreatening(boolean[][] positionMatrix);
    
    public boolean checkAlongPlus(boolean goDeep, boolean positionMatrix[][]){
        int n = positionMatrix.length;
        int m = positionMatrix[0].length;
        if(!goDeep){
            return (x+1<n && positionMatrix[x+1][y]) || (y+1<m && positionMatrix[x][y+1]) || (x-1>=0 && positionMatrix[x-1][y]) || (y-1>=0 && positionMatrix[x][y-1]);
        }
        for(int i=0; i<n; i++){
            if(i!=x && positionMatrix[i][y]){
                return true;
            }   
        }
        for(int i=0; i<m; i++){
            if(i!=y && positionMatrix[x][i]){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkAlongCross(boolean goDeep, boolean positionMatrix[][]){
        int n = positionMatrix.length;
        int m = positionMatrix[0].length;
        
        for(int i=1; x-i>=0 && y-i>=0; i++){
            if( positionMatrix[x-i][y-i] && x-i!=x && y-i!=y){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x+i<n && y+i<m; i++){
            if( positionMatrix[x+i][y+i] && x+i!=x && y+i!=y){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x-i>=0 && y+i<m; i++){
            if( positionMatrix[x-i][y+i] && x-i!=x && y+i!=y){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        for(int i=1; x+i<m && y-i>=0; i++){
            if(positionMatrix[x+i][y-i] && x+i!=x && y-i!=y){
                return true;
            }
            if(!goDeep){
                break;
            }
        }
        return false;
    }
    
    public boolean checkAlongCircle(boolean positionMatrix[][]){
        
        int x1 = x-2;
        int y1 = y-1;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x-1;
        y1 = y-2;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x+2;
        y1 = y+1;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x+1;
        y1 = y+2;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x-2;
        y1 = y+1;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x-1;
        y1 = y+2;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x+2;
        y1 = y-1;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        
        x1 = x+1;
        y1 = y-2;
        if(checkForTreaths(x1, y1, positionMatrix)){
            return true;
        }
        return false;
        
    }
    
    public boolean isOutsideChessboard(int x, int y, int n, int m){
        if(x<0 || y<0 || x>=n || y>=m){
            return true;
        }
        return false;
    }
    
    protected abstract boolean checkForTreaths(int x, int y, boolean positionMatrix[][]);
    
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
            // Swallow thr exception
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
        //return "(" + this.getClass().getSimpleName() + ") ID:'" + id + "' x:'" + x + "' y:'" + y + "'"/*\n*/; 
        return "(" + this.getClass().getSimpleName() + ") x:'" + x + "'y:'" + y + "'"/*\n*/;
    }
    
    
    
}
