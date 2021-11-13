package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    Scanner input=new Scanner(System.in);
    Alert alertBox=new Alert(Alert.AlertType.NONE);
    Alert newBox=new Alert(Alert.AlertType.INFORMATION);
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //http://javafxportal.blogspot.com/2012/03/java-how-to-get-current-date-time-date.html
    Calendar getCalender=Calendar.getInstance();

    @FXML
    public TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField boothNumField;
    @FXML
    private RadioButton radio1,radio2,radio3;

    @FXML
    private Button viewReceiptButton;

    @FXML
    public void viewReceipt(){
        boolean checkValue=false;
        String firstName=fNameField.getText();
        if(fNameField.getText().equals("")){
            fNameField.setText("--Enter First Name--");
            checkValue=true;
        }
        String lastName=lNameField.getText();
        if(lNameField.getText().equals("")){
            lNameField.setText("--Enter Last Name--");
            checkValue=true;
        }
        String userAge=ageField.getText();
        if(ageField.getText().equals("")){
            ageField.setText("--Enter your age--");
            checkValue=true;
        }
        String userCity=cityField.getText();
        if(cityField.getText().equals("")){
            cityField.setText("--Enter your city--");
            checkValue=true;
        }
        String numField=numberField.getText();
        if(numberField.getText().equals("")){
            numberField.setText("--Enter your NIC or Passport Number--");
            checkValue=true;
        }
        String boothNumber=boothNumField.getText();
        int boothIntNumber=Integer.parseInt(boothNumber);
        if(boothIntNumber >=0 && boothIntNumber<=5){
            System.out.println("--Valid--");
            checkValue=true;
        }
        if(boothNumField.getText().equals("")){
            boothNumField.setText("--Enter your booth number--");
            checkValue=false;
        }
        else{
            boothNumField.setText("--In-Valid booth--");
        }


        if(radio1.isSelected() && checkValue){
            alertBox.setTitle("Receipt");
            alertBox.setHeaderText("User Vaccination Details");
            alertBox.setContentText("First Name: "+firstName+"\n"+"\n"+"Last Name: "+lastName+"\n"+"\n"+"Age: "+userAge+"\n"+"\n"+"City: "+
                    userCity+ "\n" +"\n"+"NIC or Passport Number: "+numField+"\n"+"\n"+"Booth Number: "+boothNumber+"\n"+"\n"+"Type of vaccine: "+
                    radio1.getText() +"\n"+"\n" +"Date & Time: "+dateFormat.format(getCalender.getTime()));
            alertBox.showAndWait();
        }
        else if(radio2.isSelected()&& checkValue){
            alertBox.setTitle("Receipt");
            alertBox.setHeaderText("User Vaccination Details");
            alertBox.setContentText("First Name: "+firstName+"\n"+"\n"+"Last Name: "+lastName+"\n"+"\n"+"Age: "+userAge+"\n"+"\n"+"City: "+
                    userCity+ "\n" +"\n"+"NIC or Passport Number: "+numField+"\n"+"\n"+"Booth Number: "+boothNumber+"\n"+"\n"+"Type of vaccine: "+
                    radio2.getText() +"\n"+"\n" +"Date & Time: "+dateFormat.format(getCalender.getTime()));
            alertBox.showAndWait();
        }
        else if(radio3.isSelected()&&checkValue){
            alertBox.setTitle("Receipt");
            alertBox.setHeaderText("Patient Vaccination Details");
            alertBox.setContentText("First Name: "+firstName+"\n"+"\n"+"Last Name: "+lastName+"\n"+"\n"+"Age: "+userAge+"\n"+"\n"+"City: "+
                    userCity+ "\n" +"\n"+"NIC or Passport Number: "+numField+"\n"+"\n"+"Booth Number: "+boothNumber+"\n"+"\n"+"Type of vaccine: "+
                    radio3.getText() +"\n"+"\n" +"Date & Time: "+dateFormat.format(getCalender.getTime()));
            alertBox.showAndWait();
        }
        else {
            alertBox.setTitle("Error");
            alertBox.setHeaderText("Enter user Details");
            alertBox.setContentText("Enter your details in the form");
            alertBox.showAndWait();
        }
        //String radioButtons2=radio2.getText();
        //String radioButtons3=radio3.getText();

        /*if(checkValue){
        alertBox.setTitle("Receipt");
        alertBox.setHeaderText("User Vaccination Details");
        alertBox.setContentText("First Name: "+firstName+"\n"+"\n"+"Last Name: "+lastName+"\n"+"\n"+"Age: "+userAge+"\n"+"\n"+"City: "+
                userCity+ "\n" +"\n"+"NIC or Passport Number: "+numField+"\n"+"\n"+"Booth Number: "+boothNumber+"\n"+"\n"+"Type of vaccine: "+
                radioButtons1+radioButtons2+radioButtons3 +"\n"+"\n" +"Date & Time: "+dateFormat.format(getCalender.getTime()));
        alertBox.showAndWait();
        }*/
        /*else if(checkValue){
            alertBox.setTitle("Error");
            alertBox.setHeaderText("Enter user Details");
            alertBox.setContentText("Enter your details in the form");
            alertBox.showAndWait();
        }*/
    }

    /*@FXML
    public void receiptPageNav(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ReceiptPage.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();

        newStage.setTitle("Receipt");
        Stage prevStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }*/
}