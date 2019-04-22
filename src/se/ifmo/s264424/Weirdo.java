package se.ifmo.s264424;

import se.ifmo.s264424.enums.ReadingType;
import se.ifmo.s264424.enums.Talent;
import se.ifmo.s264424.enums.ThinkingType;
import se.ifmo.s264424.enums.WritingType;

public class Weirdo extends Human {

    private boolean likeToWork;

    Weirdo(String name, ThinkingType thinkingType, Talent talent, boolean likeToWork){
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
        return ReadingType.BY_SYLLABLE;
    }

    @Override
    public void tryToDoSomething() {
        System.out.println(getName() + " does everything shivorot na vivorot");
        write();
        read();
    }

    @Override
    public void meetSomebody(Human human){
        System.out.println(getName()+" : "+"Hello "+getName(human)+", i like turn oxygen into carbon dioxide");
    }
}