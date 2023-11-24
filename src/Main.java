import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Čtení ze souboru
        Scanner sc = vytvorScanner("C-lehky.txt");

        //Zadanné proměnné
        int T = sc.nextInt();
        int N = 0;

        //Proměnné pro vyřešní úlohy
        int[] ponozky = new int[0];
        boolean[] nalezene = new boolean[0];
        int vzdalenost = 0;
        int soucasnaVzdalenost = 0;

        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            ponozky = nactiPole(sc, N);

            //řešení problému

            nalezene = new boolean[N + 1];
            int p = 0; //barva ponožky
            int hotovo = 0; //kolik jsem jich nalezl

            for (int j = 0; j < ponozky.length; j++) {
                soucasnaVzdalenost = 0;

                if (!nalezene[ponozky[j]]) {
                    //ještě jsem ji nenalezl
                    p = ponozky[j];

                    for (int k = j + 1; k < ponozky.length; k++) {
                        //posunul jsem se o ponožku dál => vzdálenost ++
                        soucasnaVzdalenost ++;
                        vzdalenost ++;

                        if (p == ponozky[k]) {
                            hotovo ++;
                            if (hotovo != nalezene.length - 1) {
                                //nenalezl jsem všechny => vracím se k začátku
                                vzdalenost += soucasnaVzdalenost - 1;

                                nalezene[p] = true;
                                break;
                            } else {
                                //všechny jsem nalezl
                                if (soucasnaVzdalenost == 1) {
                                    //vyjímečný případ -> poslední dvě ponožky z páru se nacházejí vedle sebe
                                    vzdalenost += 1;
                                }
                                nalezene[p] = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(vzdalenost);
            vzdalenost = 0;
        }
        sc.close();
    }

    public static int[] nactiPole (Scanner sc, int N) {
        int[] arr = new int[N*2];

        for (int i = 0; i < arr.length; i++) {
            int data = sc.nextInt();
            arr[i] = data;
        }

        return arr;
    }

    public static Scanner vytvorScanner (String name) throws FileNotFoundException {
        File myObj = new File(name);
        Scanner sc = new Scanner(myObj);

        return sc;
    }

    public static File vytvorSoubor (String name) throws IOException {
        File file = new File("filename.txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }

        return file;
    }
}