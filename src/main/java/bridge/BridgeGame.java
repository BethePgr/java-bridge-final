package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> answerBridge;
    private List<List<String>> makingBridge;
    private int bridgeIndex;
    private boolean correct = true;

    public BridgeGame(List<String> answerBridge){
        this.answerBridge = answerBridge;
        initMakingBridge();
        bridgeIndex = 0;
    }

    private void initMakingBridge(){
        makingBridge = new ArrayList<>();
        makingBridge.add(new ArrayList<>());
        makingBridge.add(new ArrayList<>());
    }

    public void move(String moveInput) {
        if(answerBridge.get(bridgeIndex).equals("U")){
            moveWhenAnswerIsU(moveInput);
        }
        if(answerBridge.get(bridgeIndex).equals("D")){
            moveWhenAnswerIsD(moveInput);
        }
        bridgeIndex++;
    }

    private void moveWhenAnswerIsU(String moveInput){
        if(moveInput.equals("U")){
            makingBridge.get(0).add(" O ");
            makingBridge.get(1).add("   ");
        }if(moveInput.equals("D")){
            makingBridge.get(0).add("   ");
            makingBridge.get(1).add(" X ");
            correct = false;
        }
    }

    private void moveWhenAnswerIsD(String moveInput){
        if(moveInput.equals("U")){
            makingBridge.get(0).add(" X ");
            makingBridge.get(1).add("   ");
            correct = false;
        }
        if(moveInput.equals("D")){
            makingBridge.get(0).add("   ");
            makingBridge.get(1).add(" O ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
        if (input.equals("R")){

        }
        if (input.equals("Q")){

        }
    }

    public List<List<String>> getMakingBridge(){
        return makingBridge;
    }

    public boolean isCorrect(){
        return correct;
    }

    public int sizeOfBMakingBridge(){
        return makingBridge.get(0).size();
    }
}
