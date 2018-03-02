import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {
    @FXML
    public TextField Assignment1;
    public TextField Assignment2;
    public TextField Assignment3;
    public TextField Assignment4;
    public TextField Assignment5;
    public TextField Assignment6;
    public TextField Assignment7;
    public TextField Assignment8;
    public TextField Assignment9;
    public TextField Assignment10;
    private List<TextField> TextFields = new ArrayList<>();
    public TextField FinalGrade;
    @FXML
    private boolean is_pressed = false;

    public void assignment_Adder() {
        is_pressed = true;
        int array[];

        if(areTextFieldsFilled() && is_pressed){
            array = assignment_Array();

            int i = 0;
            float sum = 0;
            while (i < 10) {
                sum = array[i] + sum;
                i++;
            }

            float grade = sum/30;
            String str = LetterGrade(grade);
            compareFinalGrade(str);
        }
    }

    private int[] assignment_Array(){
        int array[] = new int[10];
        array[0] = Integer.parseInt(Assignment1.getText());
        array[1] = Integer.parseInt(Assignment2.getText());
        array[2] = Integer.parseInt(Assignment3.getText());
        array[3] = Integer.parseInt(Assignment4.getText());
        array[4] = Integer.parseInt(Assignment5.getText());
        array[5] = Integer.parseInt(Assignment6.getText());
        array[6] = Integer.parseInt(Assignment7.getText());
        array[7] = Integer.parseInt(Assignment8.getText());
        array[8] = Integer.parseInt(Assignment9.getText());
        array[9] = Integer.parseInt(Assignment10.getText());

        return array;
    }

    private boolean areTextFieldsFilled() {
        for (TextField field : TextFields) {
            if (field.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private String LetterGrade(float percentage){
        if (percentage > 8/9.0) {return "A";}
        else if (percentage > 13/18.0) {return "B";}
        else if (percentage > 8/15.0) {return "C";}
        else if (percentage > 1/3.0) {return "D";}
        else {return "F";}
    }

    private void compareFinalGrade(String finalGrade) {
        if (Objects.equals(finalGrade, FinalGrade.getText())) {
            FinalGrade.setText("Correct!");
        }
        else {
            FinalGrade.setText("Try Again!");
        }
    }

    @FXML
    public void openTriageRubric() {
        if (Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    File file = new File("assets/Triage_Grading.pdf");
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
