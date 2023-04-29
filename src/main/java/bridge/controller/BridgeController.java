package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    InputController inputController = new InputController();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run(){
        String bridgeSize = inputController.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        runOneGame(bridgeGame,bridgeSize);

    }

    public void runOneGame(BridgeGame bridgeGame,String bridgeSize){
        while(bridgeGame.isCorrect() && bridgeGame.sizeOfBMakingBridge() < Integer.parseInt(bridgeSize)){
            String input = inputController.readMoving();
            bridgeGame.move(input);
            OutputView.printMap(bridgeGame.getMakingBridge());
        }
    }


}
