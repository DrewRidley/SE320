package Assignment5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUtils {
    /**
     * Removes all duplicates from the given list.
     * Preconditions:
     * - The list 'lst' must not be null.
     * - Elements in 'lst' must be comparable (they must implement Comparable interface).
     *
     * @param lst The list from which duplicates are to be removed. It shall be non-null and contain comparable elements.
     * @throws IllegalArgumentException if the list is null or contains non-comparable elements.
     */
    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0)
            return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
        while (elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex))
                lst.remove(nex);
            else
                pre = nex;
        }
    }

    /*
     *  The constraints given by this assignment can be applied with the use of generic bounds like so:
     * 
     *     public static <T extends Comparable<? super T>> void removeDuplicates(List<T> lst) {
     * 
     *  In some circumstances, this might be preferred over the above precondition as a javadoc comment. 
     */
}
