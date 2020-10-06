import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        //Integer[] s = {null,9,null,9,8,0};

        //Liste<Integer> liste = new DobbeltLenketListe<>(s);


        //System.out.println(liste.antall() + " " + liste.tom());

       /* String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);


        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString());
        System.out.println(l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());
         */
/*


/*        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        System.out.println(liste.toString() + " " + liste.omvendtString());
        for (int i = 1; i <= 3; i++)
        {
            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
            liste.nullstill();

            System.out.println(liste.toString());
        }

*/
/*
        Integer [] array = new Integer[100];
        for (int a = 0; a < 99;  a++) {
            array[a] = a;
        }

        Liste<Integer> liste2 = new DobbeltLenketListe<>(array);

        long tid = System.currentTimeMillis();
        DobbeltLenketListe. sorter (liste2, Comparator.naturalOrder ());
        tid = System.currentTimeMillis() - tid;

        Liste<Integer> liste3 = new DobbeltLenketListe<>(array);
        Integer [] array2 = new Integer[200];
        for (int a = 0; a < 200;  a++) {
            array2[a] = a;
        }

        long tid2 = System.currentTimeMillis();
        DobbeltLenketListe. sorter (liste3, Comparator.naturalOrder ());
        tid2 = System.currentTimeMillis() - tid2;

        System.out.println(tid);
        System.out.println(tid2);



 */

    String[] navn = {"Lars", "Anders", "Bodil", "Kari", "Per", "Berit"};
    Liste<String> liste = new DobbeltLenketListe<>(navn);

    liste.forEach(s -> System.out.print(s + " "));
    System.out.println();
    for (String s : liste) System.out.print(s + " ");

    }
}
