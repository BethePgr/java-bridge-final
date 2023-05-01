package bridge.domain;

import java.util.Arrays;

public enum RetryCommand {

    RETRY_COMMAND("R"),
    END_COMMAND("Q");

    private String command;

    RetryCommand(String command){
        this.command = command;
    }

    public static boolean isCommandR(String input){
        return input.equals(RETRY_COMMAND.command);
    }
}
