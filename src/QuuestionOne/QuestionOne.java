package QuuestionOne;

import java.util.*;

public class QuestionOne {
    public static void main(String[] args) {
        allStringSetsIdentical(new String[][]{{"a", "b"}, {"b", "b", "a"}, {"b", "a"}});
        allStringSetsIdentical(new String[][]{{"a", "b"}, {"a"}, {"b"}});
    }

    public static boolean allStringSetsIdentical(String[][] sets) {
        if(sets.length < 2) return true; //if no set or only one set, return true;
        Set<String> set = new HashSet<>();
        List<String> listOfStrings = null;
        for (String[] s : sets) {
            for (String str : s) {
                set.add(str);
            }
        }
        for (String[] s : sets) {
            listOfStrings = new ArrayList<String>();
            Collections.addAll(listOfStrings, s);
            for (String str : set) {
                if (!listOfStrings.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
