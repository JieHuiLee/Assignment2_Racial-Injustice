package Assignment2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Participant extends Event implements Payment{ //2.1 Inheritance & 2.5 Interface
    Scanner scan = new Scanner(System.in);	
    DecimalFormat df2 = new DecimalFormat("0.00");
   
    protected String registration,name, email; 
	protected int age, race, state, contactNo,totalNumParticipant,count;
	protected char gender,donateTimes;    
	protected boolean malaysian, haveAcc = true;
	protected double donateAmount, donationFee;
	protected int donateMethod,securityCode,bankName, bankAccNo;
	protected String cardType,creditCardNo,expires,tacNo;
	
    protected String stateOfMalaysia[] = {"Johor","Kedah", "Kelantan", "Melaka","Negeri Sembilan", "Pahang", 
    		                       "Perak", "Perlis","Penang", "Selangor","Terengganu","Sabah", "Sarawak"};
    protected String bankNameList [] = {"Maybank","CIMB", "Public Bank Bhd", "RHB Bank", "Hong Leong Bank",
			                            "AmBank", "UOB Bank", "Bank Rakyat","OCBC Bank","HSBC Bank Malaysia"};
    
      public Participant(String orgz,char eType){ //constructor with 4 arguments
   			super(orgz);
            this.eventType = eType;
             if (eventType == 'A'||eventType== 'B' || eventType == 'C'){
                  System.out.println("\nRegistration for event " + eventType);
             }
             System.out.println("Please provide your information to complete registration!");
             registration();
             printInfo();
             calDonationFee();
             getDonateMethod();
             getDonationFee();
             donateChange();
             System.out.println("Total need to pay: RM " +getPayment());
       }

       public void registration(){  //Constructor with 1 argument
 		System.out.print("Enter name: ");
 		name= scan.nextLine();
 		System.out.print("Enter age: ");
 		age= scan.nextInt();
 		System.out.print("Enter gender(F/M): ");
 		gender= scan.next().charAt(0);
 		System.out.println("\nSelect race: \n1. Chinese \n2. Indian"
 										+ "\n3. Malay    \n4. Others");
 		System.out.print("Enter your race(1/2/3/4): ");
 		race = scan.nextInt();
 		
 		System.out.print("Are you Malaysian(true/false)? ");
 		malaysian = scan.nextBoolean(); 
 		//If user enter false, that mean the participant is foreigner, not need to fill which state
 		if (malaysian == true) {
 			System.out.println("\nSelect state: ");
 			//Print the list of 13 states in Malaysia by using for loop
 				for(int n = 0; n < stateOfMalaysia.length; n++) {
 					System.out.println((n+1) +". "+ stateOfMalaysia [n] );
 				}
 			System.out.print("Choose your state(1 to 13): ");
 			state = scan.nextInt();
 		}
 		System.out.print("\nEnter email: ");
 		email= scan.next();
 		System.out.print("Enter contactNo(without'-'): ");
 		contactNo= scan.nextInt();	
 	}
 

      public void printInfo() { //2.2 Polymorphism
        System.out.println("\nPlease check with your information!");
 		System.out.println("Name      : " + name);
		System.out.println("Age       : " + age);
		if(gender == 'F'||gender == 'f')
			System.out.println("Gender    : Female");
		else 
			System.out.println("Gender    : Male");
		
		switch (race) {
		case 1:
			System.out.println("Race      : Chinese");
			break;
		case 2:
			System.out.println("Race      : Indian");
			break;
		case 3:
			System.out.println("Race      : Malay");
			break;
		default:
			System.out.println("Race      : Others");
			break;
		}
		if (malaysian ==  true) 
		System.out.println("State     : " + stateOfMalaysia[state-1]);
		System.out.println("Email     : " + email);
		System.out.println("Contact No: " + contactNo); 
 	}
    
       public Participant(String orgz,int totalNumParticipant) {
    	   super(orgz);
    	   this.totalNumParticipant = totalNumParticipant;
   		 System.out.println("The Number of Participant We Have Now: " +  totalNumParticipant+ " person registered for "+ eventType);
    	}
      
      void calDonationFee() {
   		System.out.print("Enter donate amount: RM/USD ");
  		donateAmount= scan.nextDouble();
  		System.out.println("\nSelect Donate Times: A Give Once  B Monthly");
  		System.out.print("Enter donateTimes(A/B): ");
  		donateTimes= scan.next().charAt(0);
  		
  		if(donateTimes == 'B'||donateTimes == 'b') {
  			System.out.print("How many month would you like to donate? ");
  			int donateMonth = scan.nextInt();
  			donationFee = this.donateAmount * donateMonth;
  		}
  		else
  			donationFee = this.donateAmount;
  		
  		if(haveAcc == false)
  			getDonateMethod();
   	}
   	
   	void getDonateMethod() { //int
   		System.out.println("\nSelect Donate Method: \n1.Cash  2.Credit/Debit  3.Account  4. Online Banking");
  		System.out.print("Enter donateMethod(1/2/3/4): ");
  		donateMethod= scan.nextInt();
  		
  		switch (donateMethod) {
  		case 1: //Cash
  			System.out.println();
  			break;
  		case 2: //Credit/Debit
  			System.out.println("Enter card type: "); //Exp: MasterCard, Visa
  			cardType = scan.next();
  			System.out.println("Please enter the credit card number: ");
  			creditCardNo = scan.next();
  			System.out.println("Expires: "); //Write Month & Year
  			expires = scan.next();
  			System.out.println("Security Code: ");
  			securityCode = scan.nextInt();
  			break;
  		case 3: //Account
  			System.out.println("Have an PayPal account? Sign in to give faster.(true/false) ");
  			haveAcc = scan.nextBoolean();
  			if (haveAcc ==  true) 
  				System.out.println("Yes. Please click to complete donation!");
  			else
  				calDonationFee();
  		    break;
  		case 4: //Online Banking
  			System.out.println("\nBank Name:");
  			for(int i = 0; i < bankNameList.length; i++) {
  				System.out.println((i+1) +". "+ bankNameList[i] );
  			}
  			System.out.print("Choose bank name: "); //Exp: Use Array to store bankname
  			bankName = scan.nextInt();			
  			System.out.println("Select Bank Name: " + bankNameList[bankName-1]);
  			System.out.println("Please enter the bank account no: ");
  			bankAccNo = scan.nextInt();
  			System.out.print("Please Key in Tac No: ");
  			tacNo = scan.next(); 
  			do{
  			if (!tacNo.equals("520947")) {
  				System.out.println("Incorrect!Please Request TacNo and Key In Again!");
  				System.out.print("Please Key in Tac No: ");
  				tacNo = scan.next(); 
  			}
  			}while(!tacNo.equals("520947"));
  			break;
  		}		
  		System.out.println("Congratulation! You have succesfully done the registration!");
   	}
   	
   	void getDonationFee() { //(double) after calTotalDonationFee(double donateAmount, char donateTimes)
   		if(malaysian == false) //If the participant is Foreigner
   			System.out.println(" ");
   		else 
   			System.out.println("\nDonation Fee: RM " + df2.format(donationFee));
   	}
   	
  	void donateChange(){ //double
   		if(malaysian == false){ //If the participant is Foreigner
   			System.out.println("1 USD= RM 4.13"); // USD Dollar > MalaysiaDollar
   			double donateChange = donationFee * 4.13; 	
   			System.out.println(df2.format(donationFee)+ " USD = Donation Fee: RM " + df2.format(donateChange)); 
   	}
  	}
    
  	public double getPayment() {  //2.5 Interface
  		if(malaysian == true) {
  			return super.eventFees + this.donationFee;
  		}
  		else 
  			return super.eventFees + this.donationFee * 4.13;
  	}
   

} //end for class Participant extends

