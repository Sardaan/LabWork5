package se.ifmo.s264424;

import se.ifmo.s264424.enums.Necessary;

public interface EmergencyActions {
    void runTo(Human human);
    void takeNecessary(Necessary first);
    void takeNecessary(Necessary first, Necessary second);
}
