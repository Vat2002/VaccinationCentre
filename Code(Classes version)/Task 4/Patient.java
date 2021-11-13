public class Patient{
    String firstName;
    String lastName;
    int patientAge;
    String patientCity;
    String patientNumber;
    String userData;
    String waitingPatientName;

    //constructor
    public Patient(String fName, String lName,int pAge,String pCity,String pNum){
        this.firstName=fName;
        this.lastName=lName;
        this.patientAge=pAge;
        this.patientCity=pCity;
        this.patientNumber=pNum;
        System.out.println("Name:"+firstName+" "+lastName+" "+"Age:"+patientAge+" "+"City:"+patientCity+" "+"Number:"+patientNumber);
    }
   public Patient(){
   }

    public Patient(String patientName) {
        this.waitingPatientName=patientName;
    }
}