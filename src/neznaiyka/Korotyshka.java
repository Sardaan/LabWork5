package neznaiyka;

public class Korotyshka extends Human {

    Korotyshka(String name, ThinkingType thinkingType, Talent talent){
        super(name, thinkingType, talent);
    }


    @Override
    public void meetSomebody(Object obj) {
        System.out.println(getName()+": Have a good day!");
    }
    static class Malyish extends Korotyshka{
        Malyish(String name,ThinkingType thinkingType, Talent talent){
            super(name, thinkingType, talent);
        }

    }
}
