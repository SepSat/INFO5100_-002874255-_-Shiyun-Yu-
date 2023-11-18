package com.example.exercise9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class CalculatorController {
    @FXML
    private TextField displayField;

    @FXML
    public void onButtonClicked(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();
        switch (buttonText) {
            case "C":
                displayField.clear();
                break;
            case "=":
                calculateResult();
                break;
            default:
                displayField.appendText(buttonText);
                break;
        }
    }
    private void calculateResult() {
        String expression = displayField.getText();
        try {
            double result = evaluateExpression(expression);
            displayField.setText(new DecimalFormat("#.###").format(result));
        } catch (Exception e) {
            displayField.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=op)|(?=op)".replace("op", "[-+*/]"));

        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand == 0) throw new ArithmeticException("Division by zero");
                    result /= operand;
                    break;
            }
        }
        return result;
    }
}