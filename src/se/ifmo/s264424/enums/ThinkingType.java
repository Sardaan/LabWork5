package se.ifmo.s264424.enums;

public enum ThinkingType {
    GENIUS,
    CLEVER,
    AVERAGE,
    SILLY;

    public static ThinkingType getType(String value){

        ThinkingType e = null;

        for (ThinkingType temp : ThinkingType.values()){
            if (temp.toString().equals(value.toUpperCase())){
                e = temp;
            }
        }

        return e;
    }
}
