package bridge.domain;

import java.util.Arrays;

public enum MoveCommand {

    UP(1, "U"),
    DOWN(0, "D");

    private final int moveIntCommand;
    private final String moveStringCommand;

    MoveCommand(int moveIntCommand, String moveStringCommand) {
        this.moveIntCommand = moveIntCommand;
        this.moveStringCommand = moveStringCommand;
    }

    public static String findString(int rand) {
        return Arrays.stream(MoveCommand.values()).filter(str -> str.moveIntCommand == rand)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] U나 D만 입력")).moveStringCommand;
    }
}
