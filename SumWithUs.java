package Assignment2;

public abstract class SumWithUs { //2.4 Abstraction (As superclass of Event)
          
    public String name, mission, contactNo, location; //Organization Name,m,cN,locate
         
         public SumWithUs(String orgz) {
          this.name = orgz;
         }
         
         public SumWithUs(String m, String cN, String locate){ //constructor with 3 arguments
         this.mission = m;
         this.contactNo = cN; 
         this.location = locate;
         }

    public abstract void printInfo();
} //end class of SumWithUs
