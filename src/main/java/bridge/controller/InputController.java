package bridge.controller;

import bridge.validate.InputValidation;
import bridge.view.InputView;

public class InputController {

    private final InputView inputView;

    public InputController(){
        inputView = new InputView();
    }

    public String readBridgeSize(){
        try{
            String input = inputView.readBridgeSize();
            InputValidation.checkNumBetween3And20(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving(){
        try{
            String input = inputView.readMoving();
            InputValidation.onlyUorD(input);
            return input;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readRestart(){
        try{
            String input = inputView.readGameCommand();
            InputValidation.onlyRorQ(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readRestart();
        }
    }
}
