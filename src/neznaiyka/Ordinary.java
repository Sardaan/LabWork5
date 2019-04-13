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
    public void meetSomebody(Object obj){

        if (this.getThinkingType() == ThinkingType.SILLY || this.getThinkingType() == ThinkingType.AVERAGE) {
            System.out.println(getName() + " : " + getName(obj) + " has an empty head");
        } else {
            System.out.println(getName() + " : " + getName(obj) + " hello my dear friend");
        }

    }
}

