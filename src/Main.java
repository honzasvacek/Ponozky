import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N = 0;
        int[] ponozky = new int[0];
        boolean[] nalezene = new boolean[0];

        int vzdalenost = 0;
        int soucasnaVzdalenost = 0;

        for (int i = 0; i < T; i++) {
            //načtení problému do pole

            N = sc.nextInt();
            ponozky = new int[(N*2)];
            for (int j = 0; j < ponozky.length; j++) {
                ponozky[j] = sc.nextInt();
            }

            //řešení problému

            nalezene = new boolean[N + 1];
            int p = 0; //barva ponožky
            int hotovo = 0;
            for (int j = 0; j < ponozky.length; j++) {
                soucasnaVzdalenost = 0;
                if (!nalezene[ponozky[j]]) {
                    p = ponozky[j];

                    for (int k = j + 1; k < ponozky.length; k++) {
                        soucasnaVzdalenost ++;
                        vzdalenost ++;
                        if (p == ponozky[k]) {
                            hotovo ++;
                            if (hotovo != nalezene.length - 1) {

                                //vracím se k začátku
                                vzdalenost += soucasnaVzdalenost - 1;

                                nalezene[p] = true;
                                break;
                            } else {
                                if (soucasnaVzdalenost == 1) {
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
    }
}