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
    private boolean possibleLocation;

    public CowGenome(ArrayList<String> spot, ArrayList<String> plain) {
        this.spottyCow = spot;
        this.plainCow = plain;
        this.possibleLocation = true;
        checkMatch();
    }

    private void checkMatch() {
        for (int i = 0; i < this.spottyCow.size(); i++) {
            if (this.plainCow.contains(this.spottyCow.get(i))) {
                this.possibleLocation = false;
                break;
            }
        }
    }

    public static void main(String[] args) {
        File input = new File("1.in");
        try {
            // variables
            Scanner sc = new Scanner(input);
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] allCows = new String[n*2];
            for (int j = 0; j < allCows.length; j++) {
                String temp = sc.next();
                allCows[j] = temp;
            }
            int counter = 0;
            // get the counter
            for (int l = 0; l < m; l++) {
                ArrayList<String> spottyCow = new ArrayList<String>();
                ArrayList<String> plainCow = new ArrayList<String>();
                for (int p = 0; p < 2*n; p++) {
                    String temp = allCows[p].substring(l, l+1);
                    if (p < n) {
                        spottyCow.add(temp);
                    } else if (p >= n) {
                        plainCow.add(temp);
                    }
                }
                CowGenome w = new CowGenome(spottyCow, plainCow);
                if (w.possibleLocation) {
                    counter++;
                }
            }
            // output
            PrintWriter pw = new PrintWriter("1.out");
            pw.println(counter);
            pw.close();
        } catch (FileNotFoundException a) {
            System.out.println("File not found!");
        }
    }

    /*public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            File input = new File(i + ".in");
            try {
                // variables
                ArrayList<String> spottyCow = new ArrayList<String>();
                ArrayList<String> plainCow = new ArrayList<String>();
                Scanner sc = new Scanner(input);
                int n = sc.nextInt();
                int m = sc.nextInt();
                String[] allCows = new String[n*2];
                for (int j = 0; j < allCows.length; j++) {
                    String temp = sc.next();
                    allCows[j] = temp;
                }
                int counter = 0;
                // get the counter
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
    }*/

}
