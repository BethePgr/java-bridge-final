package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("input의 길이와 동일한 크기의 U나 D가 무작위로 들어간 리스트를 반환해야한다.")
    void returnList() throws Exception {
        //given
        int size = 10;
        //when
        List<String> list = bridgeMaker.makeBridge(10);
        //then
        assertTrue(list.stream().allMatch(str -> str.equals("U") || str.equals("D")));
        System.out.println(list);
    }

}