package se.ifmo.s264424.enums;

public enum ReadingType {
    BY_WORD,
    BY_SYLLABLE;

    public static ReadingType getType(String value){

        ReadingType e = null;

        for (ReadingType temp : ReadingType.values()){
            if (temp.toString().equals(value.toUpperCase())){
                e = temp;
            }
        }
        return e;
    }
}
