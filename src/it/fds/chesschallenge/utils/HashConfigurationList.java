package it.fds.chesschallenge.utils;

import it.fds.chesschallenge.model.Chessman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DamianoG
 *
 */
public class HashConfigurationList<T> extends ArrayList<Chessman> {

    private static final long serialVersionUID = -4740736867489924664L;

    public HashConfigurationList(){
        super();
    }
    
    /**
     * Count the instances of each category of chessmen in the list,
     * order the hashes of each coordinates for each chessman category and then compute a hash with that list and the number of instances found.
     * Then hash all togheter.
     */
    @Override
    public int hashCode(){
        //int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        if(this.size() <= 0){
            return 0;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(Chessman cp : this){
            String key = cp.getClass().getSimpleName();
            List<Integer> value = map.get(key);
            if(value == null){
                List<Integer> l = new ArrayList<>();
                l.add(cp.hashPosition());
                map.put(key, l);
            }
            else{
                map.get(key).add(cp.hashPosition());
            }
        }
        int [] finalHashArray = new int[5];
        Integer king = hashSortedList(map.get("King"), "King");
        finalHashArray[0] = (king != null)?king:0;
        Integer queen = hashSortedList(map.get("Queen"), "Queen");
        finalHashArray[1] = (queen != null)?queen:0;
        Integer bishop = hashSortedList(map.get("Bishop"), "Bishop");
        finalHashArray[2] = (bishop != null)?bishop:0;
        Integer rook = hashSortedList(map.get("Rook"), "Rook");
        finalHashArray[3] = (rook != null)?rook:0;
        Integer knight = hashSortedList(map.get("Knight"), "Knight");
        finalHashArray[4] = (knight != null)?knight:0;
        
        int finalHash = 1;
        for(int i=0; i<finalHashArray.length; i++){
            finalHash = 37 * finalHash + finalHashArray[i];
        }
        
        return finalHash;
    }
    
    private Integer hashSortedList(List<Integer> l, String s){
        if(l==null){
            return null;
        }
        Collections.sort(l);
        int hashResult = 1;
        hashResult = 37 * hashResult + s.hashCode();
        hashResult = 37 * hashResult + l.size();
        for(int i=0; i<l.size(); i++){
            hashResult += 37 * hashResult + l.get(i);
        }
        return hashResult;
    }
    
}
