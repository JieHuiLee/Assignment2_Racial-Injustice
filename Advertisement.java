package Assignment2;

public class Advertisement extends Event { //2.1 Inheritance
    protected String socialMedia, postUrl;
    
	public Advertisement(String orgz){ //constructor with 5 arguments
		super(orgz); 
		SumWithUs();
		donationWebsite();
             if (eventType == 'A' || eventType == 'a'){
             System.out.println("Event A Website: https://www.sumwithus.org/en/articles/events/2021/June/without-us-without-country");   
             }
             else if (eventType == 'B'|| eventType == 'b'){
             System.out.println("Event B Website: https://www.sumwithus.org/en/articles/events/2021/July/everyone-is-same");
             } 
             else if (eventType == 'C'|| eventType == 'c'){
             System.out.println("Event C Website: https://www.sumwithus.org/en/articles/events/2021/July/try-hear-other-voice");  
             }
             else if (eventType == 'D'|| eventType == 'd'){
             System.out.println("Event D Website: https://www.sumwithus.org/en/articles/events/2021/August/global-village-know-different-culture-from-each-other");  
             }
             
       }     
       
       void SumWithUs() {
		System.out.println("For further information about Sum With Us, please visit the following website: ");
		System.out.println(super.name + " Website: https://www.sumwithus.org/en" );
 	}
       
	
 	void donationWebsite() {
 		System.out.println("Donation Website: https://www.sumwithus.org/en/blog/donation");   
 	}

//2.3 Encapsulation (Use setter)
    void setSocialMedia(String socialMedia) {
 		this.socialMedia= socialMedia;
 	}
 	void setUrl(String postUrl) {
 		this.postUrl = postUrl;
 	}
//2.3 Encapsulation (Use getter)
       public String getSocialMedia() {
 	      return this.socialMedia;
       }
       public String getUrl() {
 	      return this.postUrl;
       }
       
       void onlineAd(){
             System.out.println("\nBefore you exit, we have a good news to you!");
             System.out.println("Posted on " + super.name + getSocialMedia() + ": \n" + getUrl());	
             printInfo();
       }

       public void printInfo() { //2.2 Polymorphism
 		System.out.println("\nHi, there! Our community is going to organize a LUCKY DRAW in our coming soon event!");
		System.out.println("How to join it? Follow these 3 steps:");
		System.out.println("Step 1: Go to our webpage done the registration & donation and join our event!");
		System.out.println("Step 2: Like & share out this event post in public condition.");
		System.out.println("Step 3: Tag 5 friends and invite them join together.");
		System.out.println("We will welcome to anyone join with us! Let's raise the awareness about racial injustice and prohibit it.");
 	}
      
       public void Ad(double price, double disc) { //method with 2 parameters
 		System.out.println("");
 	}
} //end for class Advertisement extends
