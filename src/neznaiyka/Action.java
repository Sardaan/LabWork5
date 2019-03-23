package neznaiyka;

import java.util.ArrayDeque;


public class Action{

    private static Human humanToRun;
    private static Human lider;
    private static Human weirdo = new Weirdo("Neznaiyka", ThinkingType.SILLY,Talent.ThinkingOUT, false);
    private static Human talanted;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public static void startAction(ArrayDeque<Human> hum){
        System.out.println();
        System.out.println("Chapter 2");

        for(Human human: hum){
            human.setState(State.STAND);

            if (human.getTalent() == Talent.ThinkingOUT && !human.getLikeToWork()){
                weirdo = human;
                human.setState(State.ENVY);
                System.out.println(human+ " want to learn something new, but he doesn't like to work");
            }
            if (human.getTalent() == Talent.MUSIC)
                talanted = human;
            if (human.getThinkingType()==ThinkingType.KOROTYSHKA){
                System.out.println("Even "+human.getName()+" need to work to learn something new");
            }
        }
        weirdo.tryToDoSomething();
        weirdo.getHumanSkills();

        for(Human human: hum){
            if (human!=talanted && human!=weirdo){
                human.meetSomebody(weirdo);
                if (talanted!=null)
                    talanted.commend(human);
            }
        }
        if (talanted!=null){
        System.out.println(weirdo.getName()+ " envy of " + talanted.getName());
        System.out.println(weirdo.getName()+" ask for help from " +talanted.getName());}

    }

    public static void getSize(ArrayDeque<Human> hum) throws NumberOfPeopleException{
        if (hum.size()>8){
            throw new NumberOfPeopleException("invalid number of people in this action");
        }
        else
            System.out.println(hum.size() + " people in this action");
    }
}



//    public static void startEmergencyAction(ArrayDeque<Human> hum){
//
//        for(Human human: hum){
//            human.setState(State.RUN);
//            switch (human.getTalent()) {
//                case ThinkingOUT:
//                    weirdo = human;
//                    break;
//                case KNOWLEGE:
//                    lider = human;
//                    break;
//                case HOSPITALITY:
//                    humanToRun = human;
//                    break;
//                case PAINTING:
//                    human.takeNecessary(Necessary.BRUSH, Necessary.WATERCOLOR);
//                    break;
//                case MUSIC:
//                    human.takeNecessary(Necessary.INSTRUMENT);
//                    break;
//                case MEDICINE:
//                    human.takeNecessary(Necessary.MedicineKIT);
//                    break;
//                default:
//                    human.takeNecessary(Necessary.RUBBERS, Necessary.UMBRELLA);
//                    break;
//                }
//            }
//
//        for(Human human : hum){
//            if (human==null)
//                break;
//            if (human!=humanToRun){
//                human.runTo(humanToRun);
//            }
//        }
//
//        lider.setState(State.STAND);
//        lider.discuss();
//
//        int numberOfLaufingHuman=0;
//
//        for(Human human: hum){
//            if (human!=weirdo && lider.getState()==State.LAUGH){
//                human.setState(State.LAUGH);
//                numberOfLaufingHuman++;
//                human.meetSomebody(weirdo);
//            }
//        }
//
//        if (numberOfLaufingHuman>3) {
//            System.out.println("Vot smehu to bilo");
//        }
//
//    }



