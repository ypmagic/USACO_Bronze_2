import java.util.ArrayList;

/**
 * Practice program - USACO Bronze #2
 * Made by Young Park
 */
public class CowGenome {

   private ArrayList<String> spottyCow;
   private ArrayList<String> plainCow;
   private boolean potentialLocation;

   public CowGenome(ArrayList<String> spot, ArrayList<String> plain) {
       this.spottyCow = spot;
       this.plainCow = plain;
       this.potentialLocation = true;
       checkMatch();
   }

   private void checkMatch() {
       for (int i = 0; i < this.spottyCow.size(); i++) {
           for (int j = 0; j < this.plainCow.size(); j++) {
               if (this.spottyCow.get(i).equals(this.plainCow.get(j))) {
                   this.potentialLocation = false;
               }
           }
       }
   }

   public static void main(String[] args) {
       
   }

}
