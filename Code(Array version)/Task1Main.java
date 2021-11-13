import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Task1Main {

    static String[] patientArr=new String[]{"Empty","Empty","Empty","Empty","Empty","Empty"};//hard codes the array to set empty
    //static String[] patientArr={"Messi","DeJong","Harden","Durant","Aguero","James","Neymar"};
    static int noOfVaccinations=150;

    public static void main(String[] args){
        String userChoice;
        do{
            userChoice=getUserInput();
            if(userChoice.equals("999") || userChoice.equals("EXT")){
                System.out.println("!!EXIT!!");
                break;
            }
            switch (userChoice) {
                case ("100"), ("VVB") -> viewAllVaccinationBooths();
                case ("101"), ("VEB") -> viewAllEmptyBooths();
                case ("102"), ("APB") -> addPatientToBooth();
                case ("103"), ("RPB") -> removePatientFromABooth();
                case ("104"), ("VPS") -> viewPatientsSortedInAlphabeticalOrder();
                case ("105"), ("SPD") -> storeProgramDataIntoAFile();
                case ("106"), ("LPD") -> loadProgramDataFromAFile();
                case ("107"), ("VRV") -> viewVaccinationsRemaining();
                case ("108"), ("AVS") -> addVaccinationsToTheStock();
            }

        }while (true);
    }

    //Shows users all the choices in the menu
    private static void showUserChoices() {
        System.out.println("----Vaccination Center--------");
        System.out.println("Enter 100 or VVB to view all vaccination booths");
        System.out.println("Enter 101 or VEB to view all empty booths");
        System.out.println("Enter 102 or APB to add patient to a booth");
        System.out.println("Enter 103 or RPB to remove patient from a booth");
        System.out.println("Enter 104 or VPS to view patients in alphabetical order");
        System.out.println("Enter 105 or SPD to store program data into file");
        System.out.println("Enter 106 or LPD to load program data from file");
        System.out.println("Enter 107 or VRV to view remaining vaccinations");
        System.out.println("Enter 108 or AVS to add vaccinations to the stock");
        System.out.println("Enter 999 or EXT to exit the program");
        System.out.println("---------------------------------------------------");
    }

    //Initialising customer array
    /*private static void initializeCustomerArray(){
        for(int i = 0; i<6; i++){
            customerName[i]="Empty";
            boothNumber[i]="Empty";
            System.out.println("Initialize");
        }
    }*/

    //User enters the choice
    private static String getUserInput(){
        Scanner input=new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        showUserChoices();
        System.out.print("Enter your choice:");
        String userChoice=input.nextLine(); //user enters data
        while(userChoice.isEmpty()){
            System.out.println("Please enter your choice:");
            userChoice=input.nextLine();
        }
        userChoice=userChoice.toUpperCase(); //converts user entered data into uppercase
        return userChoice;
    }

    //User checks the vaccination booths
    private static void viewAllVaccinationBooths(){
        System.out.println("---All Vaccination Booths---");
        for(int i=0;i<6;i++){
            System.out.println("Vaccination Booth "+(i+1)+":"+patientArr[i]);
        }
    }

    //User checks for all the empty booths
   private static void viewAllEmptyBooths() {
       System.out.println("---All Empty or Occupied Booths---");
       for (int i = 0; i < 6; i++) {
           if ((patientArr[i]).equals("Empty")) {
               System.out.println("Empty Booth:" +(i+1)+" "+ patientArr[i]); //shows all the empty booths

           }
           else{
               System.out.println("This booth is occupied:"+(i+1)+" "+ patientArr[i]);
           }
       }
   }

   //User adds patients to the necessary booths
   private static void addPatientToBooth(){
        Scanner input=new Scanner(System.in);
        int v=0;
        System.out.println("---Add Patient To Booth---");
        while ( v < 6 ) {
            System.out.println("Enter booth number (1-6) or 7 to stop:");
            int i = input.nextInt(); //user enters desired booth number
            if(i>=1 && i<=7) {
                if (i == 7) {
                    break;
                }
                noOfVaccinations -= 1;
                if(noOfVaccinations <=20){
                    System.out.println("Vaccinations are almost out of stock!");
                }
                System.out.println("Enter customer name for booth " + (i) + " :");
                String customerNameInput = input.next(); //user enters name
                patientArr[i - 1] = customerNameInput; //user entered data is passed onto the array
                for (int x = 0; x < 6; x++) {
                    System.out.println("booth " + (x+1) + " occupied by " + patientArr[x]);
                }
                v++; //counter incremented
            }
            else{
                System.out.println("Invalid Input");
            }
        }
       System.out.println(Arrays.toString(patientArr));
   }

   //Remove a patient from a booth
   private static void removePatientFromABooth(){
        System.out.println("--Remove patient from a booth--");
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the patient to remove");
        String userEnterName=input.next(); //user enters patient to remove
        //int i=0;
        //while (i < 7){
            for(int x = 0;x < 6; x++){
                if(userEnterName.equals(patientArr[x])){ //checks if the patient is in the array
                    patientArr[x] ="Empty";
                }
                else{
                    System.out.println(userEnterName+" not in booth:"+(x+1));
                }
            }
        //i++;
        //}
       System.out.println(Arrays.toString(patientArr));
   }

    //Sort the data in alphabetical order(https://www.geeksforgeeks.org/sorting-strings-using-bubble-sort-2/)
    private static void viewPatientsSortedInAlphabeticalOrder(){
        System.out.println("--View patients sorted in alphabetical order--");
        String temp;
        int n=6;
        String[]newCustomerName=new String[patientArr.length];
        for(int x=0;x<newCustomerName.length;x++){
            newCustomerName[x]=patientArr[x]; //the data in the patientArr is passed the new array called newCustomerName for sorting
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(newCustomerName[j].compareTo(newCustomerName[i])<0){
                    temp =newCustomerName[i];
                    newCustomerName[i] =newCustomerName[j];
                    newCustomerName[j]=temp;
                }
            }
            System.out.println((i+1)+":"+newCustomerName[i]);
        }
        System.out.println("Sorted in alphabetical order:");
        System.out.println(Arrays.toString(newCustomerName)+"\n");
    }

    //Write data to a text file(https://www.w3schools.com/java/java_files_create.asp)
    private static void storeProgramDataIntoAFile(){
        System.out.println("--Store data in a text file--");
        try {
            FileWriter storeDataFile = new FileWriter("PatientDataFile.txt");
            for(int i=0;i<6;i++){
                storeDataFile.write(("Booth Number: "+(i+1)+" : "+patientArr[i]+"\n"));//writes data into the file
            }
            storeDataFile.close();//closes file after entering all the data
        }catch(IOException e){
            System.out.println("File not found");
            e.printStackTrace(); //to check where the problem occurred
        }

    }

    //View data from  a text file(https://www.w3schools.com/java/java_files_read.asp)
    private static void loadProgramDataFromAFile(){
        System.out.println("--Load data from a file--");
        try {
            File loadDataFile = new File("PatientDataFile.txt");//opens file
            Scanner fileReader = new Scanner(loadDataFile);
            while(fileReader.hasNextLine()){
                String data=fileReader.nextLine();//passing data from each line to data
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    //View remaining vaccinations
    private static void viewVaccinationsRemaining() {
        System.out.println("--View vaccinations remaining--");
        if (noOfVaccinations <= 20) { //if vaccines is less than or equal 20 warning message is displayed
            System.out.println("LOW number of vaccines remaining");
        } else {
            System.out.println("Number of remaining vaccines:" + noOfVaccinations);

        }
    }

    //Add vaccines to stock
    private static void addVaccinationsToTheStock(){
        Scanner input =new Scanner(System.in);
        System.out.println("--Add vaccines to the stock--");
        System.out.print("Enter the number of vaccines to update stock:");
        int updateVaccinations=input.nextInt();
        noOfVaccinations+=updateVaccinations; //number of current vaccines is updated
        System.out.println("Updated number of vaccines in stock:"+noOfVaccinations);
    }
}