package bridge.view;

import java.util.List;

public class OutputView {

    public static void printMap(List<List<String>> makingBridge) {
        System.out.println(printOneMap(makingBridge.get(0)));
        System.out.println(printOneMap(makingBridge.get(1)));
    }

    private static String printOneMap(List<String> oneMakingBridge) {
        StringBuilder str = new StringBuilder().append("[");
        for (String x : oneMakingBridge) {
            str.append(x).append("|");
        }
        return str.deleteCharAt(str.length() - 1).append("]").toString();
    }

    public static void printResult(List<List<String>> makingBridge) {
        System.out.println("최종 게임 결과");
        printMap(makingBridge);
    }

    public static void printSuccessOrFail(boolean flag, int count) {
        String result = "실패";
        if (flag) {
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + count);
    }
}
