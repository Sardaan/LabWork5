package neznaiyka;

public class Ordinary extends Human{

//    Ordinary(String name, ThinkingType thinkingType){
//        super(name, thinkingType);
//    }
    Ordinary(String name, ThinkingType thinkingType, Talent talent){
        super(name,thinkingType,talent);
    }
//    Ordinary(String name,  Talent talent){
//        super(name, talent);
//    }


    @Override
    public void meetSomebody(Human human){

        if (this.getThinkingType() == ThinkingType.SILLY || this.getThinkingType() == ThinkingType.AVERAGE) {
            System.out.println(getName() + " : " + getName(human) + " has an empty head");
        } else {
            System.out.println(getName() + " : " + getName(human) + " hello my dear friend");
        }

    }
}

