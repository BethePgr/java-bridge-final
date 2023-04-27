package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("모든 경우의 U랑 D를 옳게 입력했을 경우")
    void all_rights() throws Exception {
        //given
        List<String> answerBridge = new ArrayList<>(List.of("U","D","D","U"));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        //when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("U");
        List<List<String>> makingBridge = new ArrayList<>();
        makingBridge.add(new ArrayList<>(List.of(" O ","   ","   "," O ")));
        makingBridge.add(new ArrayList<>(List.of("   "," O "," O ","   ")));
        //then
        assertEquals(bridgeGame.getMakingBridge(),makingBridge);
    }

    @Test
    @DisplayName("두 번째랑 세 번째의 U랑 D를 다르게 입력했을 경우")
    void two_wrongs() throws Exception {
        //given
        List<String> answerBridge = new ArrayList<>(List.of("U","D","D","U"));
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        //when
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        List<List<String>> makingBridge = new ArrayList<>();
        makingBridge.add(new ArrayList<>(List.of(" O "," X "," X "," O ")));
        makingBridge.add(new ArrayList<>(List.of("   ","   ","   ","   ")));
        //then
        assertEquals(bridgeGame.getMakingBridge(),makingBridge);
    }
}