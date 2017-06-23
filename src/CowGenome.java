import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

   public boolean getPotentialLocation() {
       return this.potentialLocation;
   }

   public static void main(String[] args) {
       for (int i = 0; i <= 10; i++) {
           File input = new File(i + ".in");
           try {
               // variables
               ArrayList<String> spottyCow = new ArrayList<String>();
               ArrayList<String> plainCow = new ArrayList<String>();
               Scanner sc = new Scanner(input);
               int n = sc.nextInt();
               int m = sc.nextInt();
               String[] allCows = new String[n];
               for (int j = 0; j < n; j++) {
                   String temp = sc.nextLine();
                   allCows[j] = temp;
               }
               int counter = 0;
               // putting variables into instance
               for (int l = 0; l < m; l++) {
                   for (int t = 0; t < n/2; t++) {
                      spottyCow.add(allCows[t].substring(l, l+1));
                   }
                   for (int p = n/2; p < n; p++) {
                      plainCow.add(allCows[p].substring(l, l+1));
                   }
                   CowGenome w = new CowGenome(spottyCow, plainCow);
                   if (w.getPotentialLocation()) {
                       counter++;
                   }
               }
               // output
               PrintWriter pw = new PrintWriter(i + ".out");
               pw.println(counter);
               pw.close();
           } catch (FileNotFoundException a) {
               System.out.println("File not found!");
           }
       }
   }

}
