package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.models.Model;

public class CalcController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label result;
    private float firstNum = 0;
    private float secondNum = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    public void processNumbers(javafx.event.ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processOperators(javafx.event.ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (value.equals("C")) {
            try {
                result.setText(result.getText().substring(0, result.getText().length() - 1));
            } catch (Exception e) {
                result.setText("");
            }
        } else if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = value;
            firstNum = Float.parseFloat(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;
            secondNum = Float.parseFloat(result.getText());
            try {
                float output = model.calculate(firstNum, secondNum, operator);
                result.setText(String.valueOf(output));
            } catch (Exception e) {
                result.setText("Cannot divide by zero!");
            }
            operator = "";
            start = true;
        }
    }

    @FXML
    void initialize() {

    }

}

