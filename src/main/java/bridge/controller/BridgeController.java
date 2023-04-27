package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class BridgeController {

    InputController inputController = new InputController();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public void run(){
        String bridgeSize = inputController.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);

    }

}
