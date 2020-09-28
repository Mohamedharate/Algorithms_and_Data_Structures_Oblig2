public class Main {
    public static void main(String[] args) {

        Integer[] s = {null,9,null,9,8,0};

        Liste<Integer> liste = new DobbeltLenketListe<>(s);


        System.out.println(liste.antall() + " " + liste.tom());





        /* Oppgave 4
        Integer[] s1 = {1,2,3,4,5,6};

        DobbeltLenketListe<Integer> l1 = new DobbeltLenketListe<>(s1);

        l1.inneholder(3);

         */


    }
}
