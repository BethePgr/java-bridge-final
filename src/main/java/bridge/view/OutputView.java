package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {



    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> makingBridge) {
        System.out.println(printOneMap(makingBridge.get(0)));
        System.out.println(printOneMap(makingBridge.get(1)));
    }

    private static String printOneMap(List<String> oneMakingBridge){
        StringBuilder str = new StringBuilder().append("[");
        for(String x : oneMakingBridge){
            str.append(x).append("|");
        }
        return str.deleteCharAt(str.length()-1).append("]").toString();
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> makingBridge) {
        System.out.println("최종 게임 결과");
        printMap(makingBridge);
    }

    public static void printSuccessOrFail(boolean flag,int count){
        String result = "실패";
        if(flag){
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + count);
    }
}
