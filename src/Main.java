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

        Integer [] array = new Integer[100];
        for (Integer a = 0; a < array.length; a++) {
            array[a] = a+1;
        }

        Liste<Integer> liste2 = new DobbeltLenketListe<>(array);

        DobbeltLenketListe. sorter (liste2, Comparator. naturalOrder ());
        long tid = System.currentTimeMillis();
        tid = System.currentTimeMillis() - tid;


        System. out .println(liste2);

    }
}
