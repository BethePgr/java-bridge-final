package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    InputController inputController = new InputController();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private boolean flag = true;
    private boolean gameResult = false;
    private int count =1;

    public void run(){
        String bridgeSize = inputController.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        while(flag) {
            runOneGame(answerBridge,bridgeGame, bridgeSize);
        }
        OutputView.printSuccessOrFail(gameResult,count);
    }

    public void successGame(BridgeGame bridgeGame){
        OutputView.printResult(bridgeGame.getMakingBridge());
        flag=false;
        gameResult = true;
    }
    public void runOneGame(List<String> answerBridge,BridgeGame bridgeGame,String bridgeSize){
        while(bridgeGame.isCorrect() && bridgeGame.sizeOfBMakingBridge() < Integer.parseInt(bridgeSize)){
            inputUorDUntilWrong(bridgeGame);
        }
        if(bridgeGame.isCorrect()){
            successGame(bridgeGame);
        }
        if(!bridgeGame.isCorrect()){
            failGame(bridgeGame,answerBridge,bridgeSize);
        }
    }

    public void inputUorDUntilWrong(BridgeGame bridgeGame){
        String input = inputController.readMoving();
        bridgeGame.move(input);
        OutputView.printMap(bridgeGame.getMakingBridge());
    }

    public void failGame(BridgeGame bridgeGame,List<String> answerBridge,String bridgeSize){
        String input = inputController.readRestart();
        if(!bridgeGame.retry(input)){
            OutputView.printResult(bridgeGame.getMakingBridge());
            flag = false;
        }
        if(bridgeGame.retry(input)){
            count++;
            runOneGame(answerBridge,new BridgeGame(answerBridge),bridgeSize);
        }
    }


}
