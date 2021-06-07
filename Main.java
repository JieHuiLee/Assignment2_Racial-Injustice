package Assignment2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        //SumWithUs orgz= new SumWithUs(); //no need new object for super class
        System.out.print("Wecome to Sum With Us Website!");
        int optionCode,totalNumParticipant=0;
        do {
        	System.out.println("\nSelect option: \n1. Registration(Participant)"
					                          + "\n2. Finance(Admin)"
					                          + "\n3. Exit Website"); 
        	System.out.print("\nEnter your option (1/2/3): ");
        	optionCode = read.nextInt();            
        
        if (optionCode == 1) { //Registration
        	Event e= new Event("Sum With Us");
        	Event event= new Event("The community stands up for prohibition of racial injustice and fair.","04-981 4652","Sum With Us-NGO, Jalan Ru 1, Changlun, 06050 Bukit Kayu Hitam.");
            System.out.println("Which event do you prefer to participate(A/B/C)? ");
    		char eventType = read.next().charAt(0);
    		event.getEventType(eventType);
            Participant participate = new Participant("Sum With Us",eventType);
            
            
            for (int count = 1;count< 2;count++) {
          	  if(eventType =='A' || eventType =='a') 
          		   totalNumParticipant = 50 + count; 
          	  else if(eventType =='B' || eventType =='b') 
          		  totalNumParticipant= 70 + count; 
          	  else if(eventType =='C' || eventType =='c') 
          		  totalNumParticipant= 30 + count;
          	  else if(eventType =='D' || eventType =='d')
          		  totalNumParticipant= 10 + count; 
         	 Participant p = new Participant("Sum With Us",totalNumParticipant);
          	 }
        }
          
        else if (optionCode == 2) { //Finance
        	 Finance finance = new Finance("SumWithUs",51,500.00,30.00);
        	 finance.setTotalDonation(3000.00);
 	 		 finance.setAdExpenses(500.00);
 	 		 finance.setExtraExpenses(100.00);
        }
        else if(optionCode ==3){ //Exit Website   
        	Advertisement ad = new Advertisement("Sum With Us ");
        	ad.setSocialMedia("Instagram");
        	ad.setUrl("https://www.instagram.com/sumwithus_NgoRacialOrganization");
        	ad.onlineAd();
        	System.out.println("\n\t\t  ========Thank you for visiting Sum With Us!========");
        	System.exit(0);
        }
        } while(optionCode<=3); //It will repeat again the optionCode until the user choose 3, the program will end by advertise the organization!!!
	    }   
}//end main class
