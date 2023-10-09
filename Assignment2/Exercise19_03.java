import java.util.ArrayList;
import java.util.HashMap;

public class Exercise19_03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) { 
        //Hashmap here for constant time duplicate checking.
        HashMap<String, E> map = new HashMap<>(list.size());
        for (E item : list) {
            map.put(item.toString(), item);  
        }
        return new ArrayList<>(map.values());
    }
}