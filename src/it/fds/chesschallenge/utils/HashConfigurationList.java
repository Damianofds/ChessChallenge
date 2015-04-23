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
        long [] finalHashArray = new long[5];
        Long king = hashSortedList(map.get("King"), "King");
        finalHashArray[0] = (king != null)?king:0;
        Long queen = hashSortedList(map.get("Queen"), "Queen");
        finalHashArray[1] = (queen != null)?queen:0;
        Long bishop = hashSortedList(map.get("Bishop"), "Bishop");
        finalHashArray[2] = (bishop != null)?bishop:0;
        Long rook = hashSortedList(map.get("Rook"), "Rook");
        finalHashArray[3] = (rook != null)?rook:0;
        Long knight = hashSortedList(map.get("Knight"), "Knight");
        finalHashArray[4] = (knight != null)?knight:0;
        
        Long finalHash = 17l;
        for(int i=0; i<finalHashArray.length; i++){
            finalHash = 37 * finalHash + finalHashArray[i];
        }
        return finalHash.intValue();
    }
    
    private Long hashSortedList(List<Integer> l, String s){
        if(l==null){
            return null;
        }
        Collections.sort(l);
        StringBuffer stringToHash = new StringBuffer();
        stringToHash.append(s).append("-").append(l.size()).append("-");
        for(int i=0; i<l.size(); i++){
            stringToHash.append(l.get(i)).append("-");
        }
        return new Integer(stringToHash.toString().hashCode()).longValue();
    }
    

    
}
