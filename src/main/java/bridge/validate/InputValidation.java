package bridge.validate;

public class InputValidation {

    public static void checkNumBetween3And20(String input) {
        if (onlyNumber(input)) {
            if (between3And20(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 3과 20 사이의 숫자만 입력 가능합니다.");
    }

    private static boolean between3And20(String input) {
        int num = Integer.parseInt(input);
        return num >= 3 && num <= 20;
    }

    private static boolean onlyNumber(String input) {
        String reg = "[0-9]+";
        return input.matches(reg);
    }

    public static void onlyUorD(String input) {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] U나 D만 입력 가능합니다.");
    }

    public static void onlyRorQ(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] R이나 Q만 입력 가능합니다.");
    }
}
