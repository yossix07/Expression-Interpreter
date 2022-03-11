//ID: 208641472

import java.util.ArrayList;

/**
 * Used to implement method regarding to actions on lists.
 * @author Yossi Maatook.
 */
public class ListActions {

    /**
     * Receives a list of strings and returns the same list, but without duplicates.
     * @param list - the list which we want to remove duplicates from.
     * @return a list of string without duplicates.
     */
    public ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();

        //Goes through the list and add the string to a new list, if doesnt exist already//
        for (String s:list) {

            //In case current string isn't in the list, adds it//
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}
