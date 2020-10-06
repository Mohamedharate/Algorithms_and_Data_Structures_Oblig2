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
        Node<T> p;

        //Sjekker om indeksen vi skal finne er i første eller siste halvdel av arrayet
        if (indeks < (antall/2)){
            //Vi leter etter en indeks i første halvdel av arrayet
            p = hode;
            for (int i = 0; i<indeks; i++) p=p.neste; //Fra kompendiet

            return p;
        }
        else{
            //Vi leter etter en indeks i andre halvdel av arrayet
            p = hale;
            for (int i = antall-1; i>indeks; i--) p=p.forrige;

            return p;
        }
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
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
        endringer = 0;

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
    }

    public Liste<T> subliste(int fra, int til){
        //Kontrollerer at intervalet er gyldig
        fratilKontroll(antall, fra, til);

        //Opprette sublisten
        int lengde = til-fra;
        T[] a = (T[])new Object[lengde];

        Node<T> s = finnNode(fra);

        for (int i = 0; i<lengde; i++){
            a[i] = s.verdi;
            s=s.neste;
        }

        return new DobbeltLenketListe<>(a);
    }

    public static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    @Override
    public int antall() {
        return antall;
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
        int count = 0;

        //Sjekker nullverider
        if(verdi == null) {
            throw new NullPointerException("Aksepterer ikke null-verider.");
        }

        //Sjekker indeksen
        if(indeks > antall || indeks < 0) {
            throw new IndexOutOfBoundsException("Indeksen kan ikke bare negativ eller større enn antall!");
        }

        //Hvis lista er tom
        if(hode == null) {
            hode = hale = new Node<>(verdi);
            hale.forrige = null;
        }

        for (Node<T> n = hode; n!=null; n = n.neste) {
            if(count == indeks) {
                //Når verdien legges inn først
                if(count == 0) {
                    hode = new Node<>(verdi);
                    hode.neste = n;
                    hode.forrige = null;
                }

                //Når verdien legges inn sist
                else if(indeks == antall-1) {
                    hale.neste = new Node<>(verdi);
                    hode.neste = null;
                }

                else {
                    Node temp = n;
                    n = new Node<>(verdi);
                    n.neste = n;
                }
            }
/*
        //Når listen er tom fra før
        if(hode == null){
            hode = hale = new Node<>(verdi);
            hale.forrige = null;
        }

        //Når verdien legges inn først
        else if(indeks == 0) {
            Node temp = hode;
            hode = new Node<>(verdi);

            for (int i = 0; i < antall; i++) {
                hode.neste = temp;
                temp = hode.neste;
            }
        }

        //Når veriden legges inn sist
        else if(indeks == antall-1) {
                hale.neste = new Node<>(verdi);
                hale = hale.neste;
            }

        //Når verdien legges inn mellom to verdier
        else {
            for(int i = 0; i<antall;i++){
                Node temp = hode;
                temp = temp.neste;
                if(i==indeks){
                    hode = new Node<>(verdi);
                    hode.neste = temp;
                }
            }


        }
*/

            count++;

        }

        antall++;
        endringer++;


    }

    @Override
    public boolean inneholder(T verdi) { //oppgave 4
        boolean inneholder = false;

        Node temp = hode;

        for(int i = 0; i<antall-1; i++) {
            temp = temp.neste;
            if(temp.verdi.equals(verdi)) {
                inneholder = true;
            }
        }

        return inneholder;
    }

    @Override
    public int indeksTil(T verdi) { //oppgave 4
        int count = 0;
        int indeks = 0;
        Node temp = hode;

        if (verdi == null) {
            indeks = -1;
        }

        else if(inneholder(verdi)) {
            for(int i = 0; i < antall; i++){
                temp = temp.neste;
                if(temp.verdi.equals(verdi)) {
                    indeks = count;
                    System.out.print(indeks);
                    return indeks;
                }
                count++;
            }

        }

        else {
            indeks = -1;
        }

        return indeks;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {

        //Kontrollerer at nyverdi ikke er null
        if (nyverdi == null){
            throw new NullPointerException();
        }
        //Kast indexoutofbounds-exception dersom indeks er større eller lik antall

        else if(indeks >= antall){
            throw new IndexOutOfBoundsException("Indeksen er utenfor listen");
        }



        Node<T> node = finnNode(indeks);

        T temp = node.verdi;
        node.verdi = nyverdi;
        endringer++;

        return temp;
    }

    @Override
    public boolean fjern(T verdi) {

        if (verdi == null){
            return false;
        }

        Boolean endret = false;

        //For løkke gjennom hele listen, sletter og returnerer når den finner første instans
        for (Node<T> n = hode; n!=null; n = n.neste) {
            if (n.verdi.equals(verdi)){
                if (hode==hale) {//Kun ett element
                    hode=hale=null;

                }else if (n == hode){ //Det er det første elementet vi skal fjerne
                    hode = n.neste;
                    hode.forrige = null;

                }else if(n == hale){ //Det er det siste elementet vi skal fjerne
                    hale = n.forrige;
                    hale.neste = null;
                }
                else {
                    Node<T> p = n.forrige;
                    Node<T> r = n.neste;
                    p.neste = r;
                    r.forrige = p;
                }

                endringer++;
                antall--;
                endret = true;
                return endret;
            }
        }
        return endret;

    }

    @Override
    public T fjern(int indeks) {


        if (hode == null || indeks > antall-1 || indeks < 0){ //Listen er tom
            throw new IndexOutOfBoundsException("Arrayet er tomt");
        }

        if(hode == hale){ //Listen har kun ett element
            Node<T> node = hode;
            hode=hale=null;
            antall--;
            endringer++;
            return node.verdi;
        }
        else if (indeks == 0){ // Vi fjerner første verdi en liste
            Node<T> node = hode;
            hode = hode.neste;
            hode.forrige = null;

            antall--;
            endringer++;

            return node.verdi;
        }
        else if(indeks == antall-1){ //Vi fjerner siste elementet i en liste
            Node<T> node = hale;
            hale=hale.forrige;
            hale.neste = null;
            antall--;
            endringer++;

            return node.verdi;
        }

        Node<T> q = finnNode(indeks);

        //Vi lar java slette noden selv, ved å fjerne koblingene til noden q
        Node<T> p = q.forrige;
        Node<T> r = q.neste;

        p.neste=r;
        r.forrige = p;

        antall--;
        endringer++;

        return q.verdi;
    }

    @Override
    public void nullstill() {

        //Metode 1
        Node<T> current = hode.neste;

        while(current != null) {
            current.forrige = null;
            current = current.neste;
        }
        hode = hale = null;
        antall = 0;
        endringer++;
    }

    @Override
    public String toString() {

        if (tom())
            return "[]";

        StringBuilder res = new StringBuilder("[");


        for(Node<T> i = hode ; i != hale ; i = i.neste)
            res.append(i.verdi).append(", ");

         /*
        Node current = hode;

        while (current != null){
            res.append(current.verdi);
            if (current.neste != null){
                res.append(", ");
            }
            current = current.neste;
        }
          */

        return res.append(hale.verdi).append("]").toString();
    }

    public String omvendtString() {
        StringBuilder innholdOmvendt = new StringBuilder("[");

        if (tom())
            return "[]";

        for (Node<T> i = hale; i != hode; i=i.forrige)
            innholdOmvendt.append(i.verdi).append(", ");

        if (antall()==1){
            hale = hode;
        }

        /*
        Node current = hale;

        while (current != null){
            innholdOmvendt.append(current.verdi);
            if (current.forrige != null){
                innholdOmvendt.append(", ");
            }
            current = current.forrige;
        }

         */
        return innholdOmvendt.append(hode.verdi).append("]").toString();
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
            if (!fjernOK){
                throw new IllegalStateException("Denne metoden kan ikke kalles");
            }
            fjernOK = false; //Vi kan ikke fjerne denne igjen

            //Sjekker etter spesialtilfeller
            if(antall == 1){ //Vi har kun ett element
                hode=hale=null;
            }else if (denne == null){ //Vi er på siste element
                hale = denne.forrige;
                hale.neste = null;
            }
            else if(denne.forrige == hode){ //Vi skal fjerne den første
                hode = denne;
                hode.forrige = null;
            }
            else{
                Node<T> p = denne.forrige.forrige;
                Node<T> q = denne.forrige;
                Node<T> r = denne;

                p.neste = r;
                r.forrige = p;
            }
            antall--;
            endringer++;
            iteratorendringer++;
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {


        T max;
        T temp;

        //Går gjennom tabellen
        for(int i = 0;i <liste.antall();i++){
            //i første runden blir max = første verdien i tabellen.
            max = liste.hent(i);
            int j = 0;
            //max = første verdien i tabellen. Nå går vi gjennom tabellen fra i = 1 og sjekker om verdiene er større
            // enn max, hvis ja, oppdaterer vi max
            for (j = i+1; j<liste.antall()-1;j++){
                T a = liste.hent(j);
                if ((c.compare(a,max)>0)){
                    max = a;
                }
            }

            temp = liste.hent(liste.antall()-1-i);//Lagerer siste verdien i tabellen
            liste.oppdater(liste.antall()-1-i,max);//Max-verdien bakerst
            liste.oppdater(j,temp);//temp får indeksen til max

        }
    }

} // class DobbeltLenketListe


