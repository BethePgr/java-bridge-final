package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private List<String> answerBridge;
    private List<List<String>> makingBridge;
    private int bridgeIndex;
    private boolean correct = true;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        initMakingBridge();
        bridgeIndex = 0;
    }

    private void initMakingBridge() {
        makingBridge = new ArrayList<>();
        makingBridge.add(new ArrayList<>());
        makingBridge.add(new ArrayList<>());
    }


    public void move(String moveInput) {
        if (answerBridge.get(bridgeIndex).equals("U")) {
            moveWhenAnswerIsU(moveInput);
        }
        if (answerBridge.get(bridgeIndex).equals("D")) {
            moveWhenAnswerIsD(moveInput);
        }
        bridgeIndex++;
    }

    private void moveWhenAnswerIsU(String moveInput) {
        if (moveInput.equals("U")) {
            makingBridge.get(0).add(" O ");
            makingBridge.get(1).add("   ");
        }
        if (moveInput.equals("D")) {
            makingBridge.get(0).add("   ");
            makingBridge.get(1).add(" X ");
            correct = false;
        }
    }

    private void moveWhenAnswerIsD(String moveInput) {
        if (moveInput.equals("U")) {
            makingBridge.get(0).add(" X ");
            makingBridge.get(1).add("   ");
            correct = false;
        }
        if (moveInput.equals("D")) {
            makingBridge.get(0).add("   ");
            makingBridge.get(1).add(" O ");
        }
    }

    public boolean retry(String input) {
        if (RetryCommand.isCommandR(input)) {
            return true;
        }

        return false;
    }

    public List<List<String>> getMakingBridge() {
        return makingBridge;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int sizeOfBMakingBridge() {
        return makingBridge.get(0).size();
    }
}
