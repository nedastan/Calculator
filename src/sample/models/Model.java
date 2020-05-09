package sample.models;

public class Model {

    public float calculate(float firstNum, float secondNum, String operator) {

        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "x":
                return firstNum * secondNum;
            case "/":
                return firstNum / secondNum;

            default:
                return 0;
        }

    }

}
