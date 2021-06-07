package Assignment2;

import java.util.Scanner;

public class Event extends SumWithUs { //2.1 Inheritance
    protected String nameOfEvent, dateOfEvent, timeOfEvent, location; //Event description
	protected double eventFees;
	public char eventType;
	
	public Event(String orgz) {
		super(orgz);
		System.out.println("\t\t\t Welcome to Our NGO Organization: "+ super.name);
		System.out.println("====================================================================================================");
	}
	
	public Event(String m, String cN, String locate){ //constructor with 4 arguments
		super(m,cN,locate);
		//Organization Info: Sum With Us
		System.out.println("About Us      : Sum With Us congregations use their financial resources to invest in programs and"
			                       + "\n\t\tinitiatives that build better relationship between different race in community and"
			                       + "\n\t\talleviation of discrimination.They help to avoid the perpetuate racial injustice.\n");
	    System.out.println("Our Mission   : " + super.mission);   
	    System.out.println("Contact No    : " + super.contactNo);   
	 	System.out.println("Location      : " + super.location);  

	    Scanner read = new Scanner(System.in);	
		System.out.println(); //Next Line print the eventTypeName:
 		System.out.println("Recent Campaigns: \nA. Without Us, Without Country"
 				                           + "\nB. Be Justice to Racial: Everyone Is Same"
 				                           + "\nC. Try to Hear Other Voice"
 				                           + "\nD. Global village - Know different cultures from each others");	
 		System.out.println("\nEnter to View More Campaigns Details!");                       
	}
 		
	public void getEventType(char eventType){
		 switch (eventType){
         case 'A':
            setName("Without Us, Without Country");
            setDate("8 June to 12 June 2021");
	 	    setTime("9am to 4pm");
	 	    setLocation("Online");
	 	    setEventFees(30.00);
         break;
         case 'B':
            setName("Be Justice to Racial: Everyone Is Same");
            setDate("1 July to 5 July 2021");
	 	    setTime("11am to 2pm");
	 	    setLocation("Online Platform");
	 	    setEventFees(20.00);
         break;
         case 'C':
            setName("Try to Hear Other Voice");
            setDate("20 July to 22 July 2021");
	 	    setTime("4:30pm to 8:30pm");
	 	    setLocation("Online Platform");
	 	    setEventFees(10.00);
         break;
         case 'D':
             setName("Global village - Know different cultures from each others");
             setDate("8 August to 12 August 2021");
 	 	    setTime("5pm-10pm");
 	 	    setLocation("Online Platform");
 	 	    setEventFees(50.00);
          break;
         }
         printInfo(eventType);
 	}
 		
          
//2.3 Encapsulation (Use setter)
	void setName(String nameOfEvent) {
 		this.nameOfEvent = nameOfEvent;
 	}
    void setDate(String dateOfEvent) {
 		this.dateOfEvent = dateOfEvent;
 	}
 	void setTime(String timeOfEvent) {
 		this.timeOfEvent = timeOfEvent;
 	}
 	void setLocation(String location) {
 		this.location= location;
 	}
 	void setEventFees(double eventFees) {
 		this.eventFees = eventFees;
 	}
//2.3 Encapsulation (Use getter)
    public String getName() {
 	      return this.nameOfEvent;
 	}
    public String getDate() {
 	      return this.dateOfEvent;
 	}
 	public String getTime() {
 		return this.timeOfEvent;
 	}
 	public String getLocation() {
 		return this.location;
 	}
 	public double getEventFees() {
 		return this.eventFees;
 	}

    public void printInfo(char eventType) { //2.2 Polymorphism (EventInfo)
    	System.out.println("\nEvent "+ eventType);
        System.out.println("Event Name : " + getName());
 		System.out.println("Date       : " + getDate());   
 		System.out.println("Time       : " + getTime());   
 		System.out.println("Location   : " + getLocation());   
 		System.out.println("Fee        : RM " + Math.round(getEventFees()));   
 	}
 	
} //end for class Event extends
