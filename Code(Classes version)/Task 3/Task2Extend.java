import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Task2Extend {

    //static String[] patientArr=new String[]{"Empty","Empty","Empty","Empty","Empty","Empty"};//hard codes the array to set empty
    static int noOfVaccinations=150;
    static Booth[] patientArr=new Booth[6];
    public static void main(String[] args){
        initializeArr(patientArr);
        //showUserChoices();
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
    //Initialising array
    private static void initializeArr(Booth patientArr[]){
        System.out.println("--Initializing--");
        for(int i=0;i<6;i++){
            patientArr[i]=new Booth("Empty");
            patientArr[i].occupiedBooth=false;
        }
    }

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
        for(int i = 0; i <6; i++) {
            //String var=patientArr[i].patientName;
            try{
                System.out.println("Vaccination Booth:"+i+" "+patientArr[i].patientVar.firstName);
            }
            catch(Exception e){
                System.out.println("Vaccination Booth:"+i+" "+"Empty");
            }
        }
    }

    //User checks for all the empty booths
    private static void viewAllEmptyBooths() {
        System.out.println("---All Empty or Occupied Booths---");
        for (int i = 0; i < 6; i++) {
            if (!patientArr[i].occupiedBooth) {
                try {
                    System.out.println("Occupied booths:" + (i) + " " + patientArr[i].patientVar.firstName);
                }
                catch(Exception e){
                    System.out.println("Empty booth:"+i);
                }
            }
        }
    }

    //User adds patients to the necessary booths
    private static void addPatientToBooth(){
        Scanner input=new Scanner(System.in);
        System.out.println("---Add Patient To Booth---");
        //runs infinite times but when array is full data cannot be entered
        while (true) {
            //instantiating
            Patient newPatient = new Patient();
            noOfVaccinations -= 1;
            if(noOfVaccinations <=20){
                System.out.println("Vaccinations are almost out of stock!");
            }
            System.out.println("Enter first name for booth " +" :");
            newPatient.firstName= input.next(); //accessing instance variable
            System.out.println("Do you wish to enter more data \nIf yes enter Y if No enter N");
            String userChoiceData=input.next();
            if(userChoiceData.equals("y")){
                System.out.println("Enter your last name:");
                newPatient.lastName= input.next();
                System.out.println("Enter your age:");
                newPatient.patientAge= input.nextInt();
                System.out.println("enter patient city:");
                newPatient.patientCity= String.valueOf(input.next());
                System.out.println("enter nic or passport number");
                newPatient.patientNumber= String.valueOf(input.next());
            }
            else{
                System.out.println("--Loading vaccinations--");

            }
            System.out.println("Enter your type of vaccination:");
            String vaccinationType= input.next();
            String passVaccType=vaccinationType.toUpperCase();
            switch(passVaccType) {
                case ("ASTRAZENECA"):
                    if(patientArr[0].occupiedBooth && patientArr[1].occupiedBooth){
                        System.out.println("Booth of them already used!!");
                    }
                    else if(!patientArr[0].occupiedBooth) {
                        patientArr[0].patientVar=newPatient;
                        System.out.println("Booth 0:"+patientArr[0].patientVar.firstName);
                        patientArr[0].occupiedBooth=true;
                    }
                    else {
                        patientArr[1].patientVar=newPatient;
                        System.out.println("Booth 1:"+patientArr[1].patientVar.firstName);
                        patientArr[1].occupiedBooth=true;
                    }
                    break;
                case ("SINOPHARM"):
                    if(patientArr[2].occupiedBooth && patientArr[3].occupiedBooth){
                        System.out.println("Booth of them already used!!");
                    }
                    else if(!patientArr[2].occupiedBooth) {
                        patientArr[2].patientVar=newPatient;
                        System.out.println("Booth 2:"+patientArr[2].patientVar.firstName);
                        patientArr[2].occupiedBooth=true;
                    }
                    else {
                        patientArr[3].patientVar=newPatient;
                        System.out.println("Booth 3:"+patientArr[3].patientVar.firstName);
                        patientArr[3].occupiedBooth=true;
                    }
                    break;
                case ("PFIZER"):
                    if(patientArr[4].occupiedBooth && patientArr[5].occupiedBooth){
                        System.out.println("Booth of them already used!!");
                    }
                    else if(!patientArr[4].occupiedBooth) {
                        patientArr[4].patientVar=newPatient;
                        System.out.println("Booth 4:"+patientArr[4].patientVar.firstName);
                        patientArr[4].occupiedBooth=true;
                    }
                    else {
                        patientArr[5].patientVar=newPatient;
                        System.out.println("Booth 5:"+patientArr[5].patientVar.firstName);
                        patientArr[5].occupiedBooth=true;
                    }
                    break;
                default:
                    System.out.println("--Invalid input Please enter again--");
            }
            System.out.println("Enter Y to proceed or N to exit");
            String userProceed=input.next();
            userProceed=userProceed.toUpperCase();
            if(!userProceed.equals("Y")){
                System.out.println("--EXIT--");
                break;
            }
        }
        for(int i = 0; i <6; i++) {
            //String var=patientArr[i].patientName;
            try{
                System.out.println("Vaccination Booth:"+i+" "+patientArr[i].patientVar.firstName);
            }
            catch(Exception e){
                System.out.println("Vaccination Booth:"+i+" "+"Empty");
            }
        }
    }

    //Remove a patient from a booth
    private static void removePatientFromABooth(){
        System.out.println("--Remove patient from a booth--");
        viewAllVaccinationBooths();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the booth number of the patient to remove");
        int userEnterNumber=input.nextInt(); //user enters patient to remove
          patientArr[userEnterNumber].patientVar=null; //resetting a object by making a new object
        viewAllVaccinationBooths();
    }

    //Sort the data in alphabetical order(https://www.geeksforgeeks.org/sorting-strings-using-bubble-sort-2/)
    private static void viewPatientsSortedInAlphabeticalOrder(){
        System.out.println("--View patients sorted in alphabetical order--");
        String temp;
        int n=6;
        String[]newCustomerName=new String[patientArr.length];
        for(int x=0;x<newCustomerName.length;x++){
            try {
                newCustomerName[x] = String.valueOf(patientArr[x].patientVar.firstName); //the data in the patientArr is passed the new array called newCustomerName for sorting
            }
            catch(Exception e){
                newCustomerName[x]="Empty";
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(newCustomerName[j].compareTo(newCustomerName[i])<0){
                    temp =newCustomerName[i];
                    newCustomerName[i] =newCustomerName[j];
                    newCustomerName[j]=temp;
                }
            }
            System.out.println((i)+":"+newCustomerName[i]);
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
                    //String var=patientArr[i].patientName;
                    try{
                        //System.out.println("Vaccination Booth:"+i+" "+patientArr[i].patientVar.firstName);
                        storeDataFile.write(("Booth Number: "+(i)+" : "+"Name:"+patientArr[i].patientVar.firstName+" "+patientArr[i].patientVar.lastName
                                +" |Age:"+patientArr[i].patientVar.patientAge+" |City:"+patientArr[i].patientVar.patientCity+"|Number:"+patientArr[i].patientVar.patientNumber
                                +"\n"));//writes data into the file
                    }
                    catch(Exception e){
                        System.out.println("Empty Booth:"+i);
                }
                //storeDataFile.write(("Booth Number: "+(i+1)+" : "+"Name:"+patientArr[i].patientVar.firstName+" "+patientArr[i].patientVar.lastName
                       // +" |Age:"+patientArr[i].patientVar.patientAge+" |City:"+patientArr[i].patientVar.patientCity+"|Number:"+patientArr[i].patientVar.patientNumber
                       // +"\n"));//writes data into the file
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


/*Implementing the classes version was much easier than the arrays version because you have to create a new array for each data to be added but when
using classes the constructor of the class is the only one thing to be implemented*/