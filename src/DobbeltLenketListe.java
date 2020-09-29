////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;

import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }

    }

    // hjelpemetode
    private Node<T> finnNode(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    // instansvariabler
    private Node hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;

    }

    public DobbeltLenketListe(T[] a) {
        // Hvis tabellen er null skal brukeren få feil melding

        Objects.requireNonNull(a,"Tabellen a er null!");

        antall = 0;


        // Det første vi gjør er å finne verdien til "hode". Det gjør vi ved å finne indexen første verdien i
        // arrayet som ikke er null.
        int index = 0;
        while (index < a.length && a[index] == null)
            index++;

        /*Hvis indexen er mindre enn lengden på arrayet, hode og hale skal være lik den første verdien i arrayet
        som er a[index]
         */

        if (index < a.length){
            hode = hale = new Node<>(a[index]);
            index++;
            antall++;
        }


        /*
        * Når vi kommer hit, da er alle verdiene til index er null.
        * Både hode og hale er lik a[index] som er første verdien i arrayet som ikke er null
        * Vi looper gjennom arrayet fra index siden vi allerede har sjekket de tidligere verdiene
        * Vi sjekker at verdien ikke er null, hvis ja så blir denne verdien den nye hale-verdien.
        * Vi øker antall med en for hver gang vi får en ny node. Det vil si at antall er lik antall noder i listen.
        */
        for(index = index;index<a.length;index++){
            if (a[index] != null){
                hale.neste = new Node<>(a[index],hale,null);
                hale = hale.neste;
                antall++;
            }
        }
        // Hvis a inneholder en eller flere null-verdier, skal de ikke tas med. Dvs listen skal skal inneholde
        // de verdiene av a som ikke er null.


        // Verdiene skal ligge i samme rekkefølge

        // Første verdi skal peke til hode og siste til hale.
        // Hver node skal ha neste og forrige
        // hale.neste skal være null
        // Hvis tabellen inneholder kun en verdi, skal både hode og hale peke til samme node.

    }

    public Liste<T> subliste(int fra, int til){
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        Node temp = hode;
        int count  = 0;

        while (temp != null){
            temp = temp.neste;
            count++;
        }
        return count;
    }

    @Override
    public boolean tom() {
       return antall() == 0;
    }

    @Override
    public boolean leggInn(T verdi) {

        //Hvis verdien er null, får brukeren en feil melding
        Objects.requireNonNull(verdi,"Null verdier er ikke tillatt!");

        //Sjekker om listen er tom, hvis ja så skal både hode og hale ha samme verdi som er "verdi"
        if (hode == null){
            hode = hale = new Node<>(verdi);
            hale.forrige = null;//forrigepekeren til hale skal være null i og med at hale = hode = newnode
        }
        else {
            //Hvis listen inneholder 1 eller flere elementer skal vi gjør den nye node-en til hale
            hale.neste = new Node<>(verdi,hale,null);
            hale = hale.neste;

        }
        //Antall økes
        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) { //oppgave 5
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) { //oppgave 4
        boolean inneholder = false;

        Node temp = hode;

        while(temp != null) {
            temp = temp.neste;
            if(temp == verdi) {
                inneholder = true;
            }
        }

        return inneholder;
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) { //oppgave 4
        int count = 0;
        int indeks;
        Node temp = hode;

        if(inneholder(verdi)) {
            while(temp != null) {
                temp = temp.neste;
                if(temp == verdi) {
                    indeks = count;
                    break;
                }
            count++;
            }
        }

        else {
            return -1;
        }

        return count;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        if (tom())
            return "[]";

        Node current = hode;

        while (current != null){
            res.append(current.verdi);
            if (current.neste != null){
                res.append(", ");
            }
            current = current.neste;
        }
        return "[" + res + "]";

    }

    public String omvendtString() {
        StringBuilder innholdOmvendt = new StringBuilder();

        if (tom())
            return "[]";

        if (antall()==1){
            hale = hode;
        }

        Node current = hale;

        while (current != null){
            innholdOmvendt.append(current.verdi);
            if (current.forrige != null){
                innholdOmvendt.append(", ");
            }
            current = current.forrige;
        }
        return "[" + innholdOmvendt + "]";
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


