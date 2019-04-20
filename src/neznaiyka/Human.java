package neznaiyka;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Objects;

public class Human implements HumanActions, EmergencyActions, Comparable<Human>{
    private ThinkingType thinkingType;
    private WritingType writingType;
    private ReadingType readingType;
    private Talent talent;
    private boolean likeToWork=true;
    private String name;

        //конструкторы

    public Human(String name, ThinkingType thinkingType, Talent talent, WritingType writingType, ReadingType readingType, boolean likeToWork){
        this.name = name;
        this.thinkingType= thinkingType;
        this.talent = talent;
        this.writingType = writingType;
        this.readingType = readingType;
        this.likeToWork = likeToWork;
    }
    public Human(String name, ThinkingType thinkingType, Talent talent){
        this.name = name;
        this.thinkingType= thinkingType;
        this.talent=talent;
    }


        //гетеры и сетер

    public boolean getLikeToWork(){
        return this.likeToWork;
    }
    public void setLikeToWork(boolean likeToWork){
        this.likeToWork=likeToWork;
    }

    public Talent getTalent(){
        return talent;
    }

    public String getName(){
        return this.name;
    }

    public String getName(Human human){
        return human.getName();
    }

    public ReadingType getReadingType() {
        return readingType;
    }

    public ThinkingType getThinkingType() {
        return thinkingType;
    }

    public WritingType getWritingType(){
        return writingType;
    }



    //Методы

    @Override
    public int hashCode() {
        // todo почитай про это
        int LTW = likeToWork? 1:0;
        return name.hashCode() + thinkingType.hashCode() + talent.hashCode() +
                writingType.hashCode() + readingType.hashCode() + LTW;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Human){
              if (((Human) obj).name.equals(this.name) && ((Human) obj).thinkingType == this.thinkingType &&
                      ((Human) obj).talent.equals(this.talent) && ((Human) obj).writingType.equals(this.writingType) &&
                      ((Human) obj).readingType.equals(this.readingType) && ((Human) obj).name.equals(this.name))
                  return true;
        }
        return false;

    }

    @Override
    public String toString(){
        return getName() + "," + getThinkingType() + "," + getTalent() + "," + getWritingType() +
                "," + getReadingType() + "," + getLikeToWork();
    }

    @Override
    public WritingType write(){
        return WritingType.LOWERCASE;
    }

    @Override
    public ReadingType read(){
        return ReadingType.ByWORD;
    }

    @Override
    public void meetSomebody(Human human) {
        System.out.println(getName() + " : " + getName(human) + " hello my dear friend");
    }


    public void getHumanSkills() {
        if (this.write() == WritingType.LOWERCASE) {
            System.out.println(getName() + " can write by lowercase");
        }
        if (this.write() == WritingType.TYPED) {
            System.out.println(getName() + " can write onlu printed letters");
        }
        if (this.read() == ReadingType.ByWORD) {
            System.out.println(getName() + " can read by words");
        }
        if (this.read()  == ReadingType.BySYLLABLE) {
            System.out.println(getName() + " can read only by syllable");
        }
    }
    public void tryToDoSomething() {
        if (this.getTalent()==Talent.ThinkingOUT)
            System.out.println(getName() + " does everything shivorot na vivorot");
            write();
            read();
    }



    @Override
    public void takeNecessary(Necessary first){
        System.out.println(getName()+" take " + first);
    }

    @Override
    public void takeNecessary(Necessary first, Necessary second){
        System.out.println(getName()+" takes " + first+" and "+second);
    }
    @Override
    public void runTo(Human human){
        System.out.println(getName()+" runs to "+ getName(human));
    }

    public void commend(Human human){
        if (this.getTalent()==Talent.MUSIC){
            System.out.println(getName(human)+" : " +getName()+ " you are a such good musician");
        }
    }
    @Override
    public int compareTo(Human human){
        return name.toLowerCase().compareTo(human.getName().toLowerCase());
    }

}
