package neznaiyka;

public class Korotyshka extends Human {

    Korotyshka(String name, ThinkingType thinkingType, Talent talent){
        super(name, thinkingType, talent);
    }


    @Override
    public void meetSomebody(Human human) {
        System.out.println(getName()+": Have a good day!");
    }

}
