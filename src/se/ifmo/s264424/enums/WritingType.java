package se.ifmo.s264424.enums;

public enum WritingType {
    LOWERCASE,
    TYPED;

    public static WritingType getType(String value){

        WritingType e = null;

        for (WritingType temp : WritingType.values()){
            if (temp.toString().equals(value.toUpperCase())){
                e = temp;
            }
        }
        return e;
    }
}
