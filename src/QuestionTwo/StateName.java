package QuestionTwo;

import java.util.HashMap;

public class StateName {
    private static HashMap<String, String> abbrevToNameMap;
    private static HashMap<String, String> fullNameToAbbrevMap;
    /*
    Advantages of enam: unique values, it is possible to check the data type and pass any string to the method parameter.
    */
    private static StateEnum[] states = StateEnum.values();

    public StateName() {
        abbrevToNameMap = new HashMap<>();
        fullNameToAbbrevMap = new HashMap<>();
        for (StateEnum state : states) {
            abbrevToNameMap.put(state.getAbbrev(), state.getname());
            fullNameToAbbrevMap.put(state.getname(), state.getAbbrev());
        }
    }

    // return the name of the state
    public String getFullNamefromAbbrev(String abbrev) {
        return abbrevToNameMap.get(abbrev);
    }

    //return the abbrev from name
    public String getAbbrevFromFullName(String s) {
        return fullNameToAbbrevMap.get(s);
    }
}

class StateUtilsHTML {

    private static StateEnum[] states = StateEnum.values();
    private static StateName map = new StateName();
    private static final String OPTION = "<option value=\"%1$s\">%1$s</option>\n";

    public static String selectList() {
        StringBuilder builder = new StringBuilder();
        builder.append("<select name=\"state\">\n");
        for (StateEnum state : states) {
            builder.append(String.format(OPTION, state.getname()));
        }
        builder.append("</select>\n");
        return builder.toString();
    }

    public static String parseSelectedState(String s) {
        return map.getAbbrevFromFullName(s);
    }

    public static String displayStateFullName(String abbr) {
        return map.getFullNamefromAbbrev(abbr);
    }

}


enum StateEnum {
    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("California", "CA");

    private final String name;
    private final String abbrev;

    StateEnum(String fullName, String abbrev) {
        this.name = fullName;
        this.abbrev = abbrev;
    }

    public String getname() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }
}