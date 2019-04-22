package se.ifmo.s264424;

import se.ifmo.s264424.enums.ReadingType;
import se.ifmo.s264424.enums.WritingType;

public interface HumanActions {
    WritingType write();
    ReadingType read();
    void meetSomebody(Human human);
}
