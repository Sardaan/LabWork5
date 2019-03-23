package neznaiyka;


import java.util.ArrayDeque;
import java.util.Objects;

public abstract class Human implements HumanActions, EmergencyActions{
    private ThinkingType thinkingType;
    private WritingType writingType;
    private ReadingType readingType;
    //private Clothes clothes;
    //private Body body;
    //private Necessary things;
    private State state = State.RUN;
    private Talent talent=Talent.NOPE;
    private boolean likeToWork=true;
    private String name;

        //конструкторы

    public Human(String name, ThinkingType thinkingType){
        this.name = name;
        this.thinkingType= thinkingType;
    }
    public Human(String name, ThinkingType thinkingType, Talent talent){
        this.name = name;
        this.thinkingType= thinkingType;
        this.talent=talent;
    }


        //гетеры и сетеры

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

    public State getState(){
        return this.state;
    }
    public void setState(State state){
        this.state = state;
    }

    public String getName(Object obj){
        return obj.toString();
    }

    public ReadingType getReadingType() {
        return readingType;
    }

    public ThinkingType getThinkingType() {
        return thinkingType;
    }

    public void setThinkingType(ThinkingType thinkingType) throws WrongThinkingTypeException{
        if (thinkingType==ThinkingType.KOROTYSHKA){
            throw new WrongThinkingTypeException("invalid thinking type");
        }else{
            this.thinkingType=thinkingType;}
    }
    public WritingType getWritingType(){
        return writingType;
    }



    //Методы

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name != other.name)
            return false;
        if (thinkingType != other.thinkingType)
            return false;
        return true;
    }

    @Override
    public String toString(){
        return getName();
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
    public void wear(Clothes clothes, Body body){
        System.out.println(getName() + " wears " +clothes+ " on " + body);
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
            wear(Clothes.SHOES, Body.FEET);
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
    public void runTo(Object obj){
        System.out.println(getName()+" runs to "+ getName(obj));
        this.state = State.STAND;
    }

    @Override
    public void discuss(){
        if (this.getState()==State.STAND){
            System.out.println(getName()+": Neznayika think out everything");
            this.state=State.LAUGH;
        }
    }
    public void commend(Object obj){
        if (this.getTalent()==Talent.MUSIC){
            System.out.println(getName(obj)+" : " +getName()+ " you are a such good musician");
        }
    }


}
