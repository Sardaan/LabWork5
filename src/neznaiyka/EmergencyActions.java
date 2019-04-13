package neznaiyka;

public interface EmergencyActions {
    void runTo(Object obj);
    void takeNecessary(Necessary first);
    void takeNecessary(Necessary first, Necessary second);
}
