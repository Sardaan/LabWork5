package se.ifmo.s264424.enums;

public enum Talent {
    NOPE,
    MUSIC,
    PAINTING,
    MEDICINE,
    KNOWLEDGE,
    COOKING;


    public static Talent getTalent(String value){

        Talent talent = null;

        for (Talent talentEnum : Talent.values()){
            if (talentEnum.toString().equals(value.toUpperCase())){
                talent = talentEnum;
            }
        }

        return talent;
    }
}
