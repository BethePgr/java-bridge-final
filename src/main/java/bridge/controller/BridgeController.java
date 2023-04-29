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
    public void run(){
        String bridgeSize = inputController.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        while(flag) {
            runOneGame(answerBridge,bridgeGame, bridgeSize);
        }
    }

    public void runOneGame(List<String> answerBridge,BridgeGame bridgeGame,String bridgeSize){
        while(bridgeGame.isCorrect() && bridgeGame.sizeOfBMakingBridge() < Integer.parseInt(bridgeSize)){
            String input = inputController.readMoving();
            bridgeGame.move(input);
            OutputView.printMap(bridgeGame.getMakingBridge());
        }
        if(bridgeGame.isCorrect()){
            OutputView.printResult(bridgeGame.getMakingBridge());
        }
        if(!bridgeGame.isCorrect()){
            String input = inputController.readRestart();
            if(!bridgeGame.retry(input)){
                OutputView.printResult(bridgeGame.getMakingBridge());
                flag = false;
            }
            if(bridgeGame.retry(input)){
                runOneGame(answerBridge,new BridgeGame(answerBridge),bridgeSize);
            }
        }
    }


}
