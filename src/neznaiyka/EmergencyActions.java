package neznaiyka;

public interface EmergencyActions {
    void runTo(Human human);
    void takeNecessary(Necessary first);
    void takeNecessary(Necessary first, Necessary second);
}
