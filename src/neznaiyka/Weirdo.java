package neznaiyka;

public class Weirdo extends Human {
//    private ThinkingType thinkingType;
//    private WritingType writingType;
//    private ReadingType readingType;
//    private Clothes clothes;
//    private Body body;
    private boolean likeToWork;

    Weirdo(String name, ThinkingType thinkingType, Talent talent,boolean likeToWork){
        super(name,thinkingType,talent);
    }
    Weirdo(String name, ThinkingType thinkingType, Talent talent){
        super(name,thinkingType,talent);
    }

    public boolean getLikeToWork(){
        return this.likeToWork;
    }
    public void setLikeToWork(boolean likeToWork){
        this.likeToWork=likeToWork;
    }

    @Override
    public WritingType write() {
        return WritingType.TYPED;
    }

    @Override
    public ReadingType read() {
        return ReadingType.BySYLLABLE;
    }

    @Override
    public void tryToDoSomething() {
        System.out.println(getName() + " does everything shivorot na vivorot");
        write();
        read();
    }

    @Override
    public void meetSomebody(Object obj){
        System.out.println(getName()+" : "+"Hello "+getName(obj)+", i like turn oxygen into carbon dioxide");
    }
}