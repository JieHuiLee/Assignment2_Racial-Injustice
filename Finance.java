package Assignment2;

import java.text.DecimalFormat;

public class Finance extends Event implements Payment{ //2.1 Inheritance & 2.5 Interface
	DecimalFormat df2 = new DecimalFormat("0.00");

	protected double sponsorFees;
	protected double eventFees; 
	protected int totalNumParticipant;
	protected double totalDonation, netIncome,adExpenses, extraExpenses;
	
	public Finance (String orgz,int totalNumParticipant,double sponsorFees, double eventFees) {  //Constructor with 2 arguments
		super(orgz);
		this.totalNumParticipant = totalNumParticipant;
		this.sponsorFees = sponsorFees;
		this.eventFees = eventFees;
		System.out.println("========Finance========");
		System.out.println("Sum With Us Income Statement");
		
		System.out.println("Total sponsor    : RM " + df2.format(this.sponsorFees));
		if (eventType == 'A'||eventType== 'B' || eventType == 'C')
		     System.out.println("The Number of Partipant For Event " + eventType + " We Have Now : "+totalNumParticipant + " person registered");   
		System.out.println("\nTotal Event Fees Collected : RM " + df2.format(getPayment()));
		calTotalExpenses();
		calSuccessOtherEvent();
		printInfo();
	}
	
	//Calculation 
 	public double calTotalExpenses(){
 		return this.adExpenses + this.extraExpenses;
 	}
 	
 	
 	public double calSuccessOtherEvent() { //NetIncome
 		return netIncome = totalDonation + sponsorFees + getPayment() - calTotalExpenses();
 	}
 	
 	//2.3 Encapsulation (Use setter)
 	public void setTotalDonation(double totalDonation) {
 		this.totalDonation = totalDonation;
 	}
 	
 	public void setAdExpenses(double adExpenses) {
 		this.adExpenses = adExpenses;
 	}
 	
 	public void setExtraExpenses(double extraExpenses) {
 		this.extraExpenses = extraExpenses;
 	}
 	
 	//2.3 Encapsulation (Use getter)	
 	public double getTotalDonation(){
 		return this.totalDonation;
 	}
 	
 	public double getAdExpenses() {
 		return this.adExpenses;
 	}
 	
 	public double getExtraExpenses() {
 		return this.extraExpenses;
 	}
	

	public double getPayment() {  //2.5 Interface-calTotalEventFeesCollected
  			return super.eventFees * this.totalNumParticipant;
  	}
	
	public void printInfo() { //2.2 Polymorphism
		System.out.println("Total donation   : RM " + df2.format(getTotalDonation()));
 		System.out.println("Total expenses   : RM " + df2.format(calTotalExpenses()));
 		System.out.println("\n===============================");
 		System.out.println("Net Income       : RM " + df2.format(calSuccessOtherEvent()));
 	}
} //end for class Finance extends
