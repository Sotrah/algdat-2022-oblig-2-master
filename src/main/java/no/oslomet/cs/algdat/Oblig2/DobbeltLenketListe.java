package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
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

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {


    }

    // Jonas
    public DobbeltLenketListe(T[] a) {
        // Del av oppgave 1
        /*
        * sjekk om a er null og kast evt exception
        * sjekk a ikke er null og skriv så en for-løkke som oppretter
        et hode med den første noden i tabellen.
        * øk tellevariabel med 1
        * bryt ut av gjeldende løkke når hode er opprettet
        * sett hale til å være hode. (denne endres for hver gang det legges til en node)
        * gjør sjekk på om hode != null. hvis ikke økes hjelpevariabel som ble brukt
        i forrige løkke med 1.
        * lag en for løkke som går så lenge hjelpevariabelen i er mindre enn størrelsen
        på a.
        * hvis den neste verdien i a ikke er null opprettes en ny node, og antall økes med 1.
        */

        if (a == null) throw new NullPointerException("Lista er tom");
        Node<T> gjeldende = null;
        Node<T> gamle;
        antall = 0;
        endringer = 0;
        if (a.length > 0) {
            int i = 0;
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i]);
                    gjeldende = hode;
                    antall++;
                    break;
                }
            }
            if (hode != null) {
                gamle = gjeldende;
                i++;
                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        gjeldende.neste = new Node<>(a[i], gjeldende, null);
                        gjeldende = gjeldende.neste;
                        antall++;
                    }
                }
                hale = gjeldende;
            }
        }
    }

    public Liste<T> subliste(int fra, int til) {
        // Første metode i Oppgave 3b
        // Pseudo:
        /*
        * sjekk om intervallet er lovlig. med bruk av fratilKontroll(). denne hentes fra kompendiet og legges inn
        som privat metode. (bytt ut exception typen for å få riktig feilmelding)
        * Opprett/instansier en liste og sett riktig lengde med en variabel basert på til - fra.
        * hvis intervallet er 0/ikke et intervall returneres en tom liste
        * hvis intervallet er 1 eller større returneres en subliste:
        * lag en "gjeldende" node (fra)
        * løkke som kjører så mange ganger som "lengde"-variablen lar den gå. lengde minkes med 1 pr loop
        * kalle leggInn() og tilegne "gjeldende" en ny verdi før neste runde i løkken
        * tilegn gjeldende gjeldende sin neste
        */
        fratilKontroll(antall, fra, til);

        Liste<T> subliste = new DobbeltLenketListe<>(); //  kalle denne subliste eller kun liste?
        int lengde = til - fra;

        if (lengde < 1) {
            return subliste;
        }
        Node<T> gjeldende = finnNode(fra);
        while (lengde > 0) {
            subliste.leggInn(gjeldende.verdi);
            gjeldende = gjeldende.neste;
            lengde--;
        }
        return subliste;
    }


    // Hjelpemetode til 3b (limt inn fra kompendiet)
    private void fratilKontroll(int antall, int fra, int til) {
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
    // Jonas
    public int antall() {
        return antall;
    }

    @Override
    // Jonas
    public boolean tom() {
        // Andre metode i oppgave 1.
        /*
        gjør sjekk om hode har en verdi. om hodet
        er null skal det returneres true da hodet
        hadde hatt noe annet enn nullverdi om lista ikke var tom.
        */
        return antall == 0;
    }

    @Override
    public String toString() { //2 Joacim
        // If-setning som sjekker om listen er tom
        if (antall == 0) {
            // Returnerer en tom String
            return "[]";
        }

        // Oppretter en node for tar vare på verdien til hode
        Node<T> p = hode;
        // Oppretter en StringBuilder som skal legge sammenen String verdiene
        StringBuilder s = new StringBuilder();
        // Setter en klamme først
        s.append('[');
        // Setter inn verdien til hode først i listen som skal ut
        s.append(p.verdi);
        // Setter at noden p nå skal være den neste noden for p
        p = p.neste;
        // While-løkke som kjører sålenge p ikke er null
        while (p != null) {
            // Setter inn verdiene med et komma først
            s.append(", ");
            s.append(p.verdi);
            p = p.neste;
        }

        // Legger inn en klamme til slutt
        s.append(']');
        return s.toString();
    }

    public String omvendtString() { //2 Joacim
        // If-setning som sjekker om listen er tom
        if (antall == 0) {
            return "[]";
        }

        // Samme prinsipp som i toString, bare at vi traverserer baklengs
        Node<T> c = hale;
        StringBuilder s = new StringBuilder();

        s.append('[').append(c.verdi);
        c = c.forrige;

        while (c != null) {
            s.append(',').append(' ').append(c.verdi);
            c = c.forrige;
        }
        s.append(']');

        return s.toString();
    }

    @Override
    public boolean leggInn(T verdi) { //2 Joacim
        // Programkode 3.3.2 f)
        // Verdi kan ikke være null
        Objects.requireNonNull(verdi, "Ikke lov med null-verdier!");
        // If-setning som sjekker om listen er tom
        if (antall == 0) {
            // Ny node som tar vare på verdi
            Node<T> p = new Node<>(verdi);
            hode = hale = p;
        }
        // Hvis ikke skal den siste verdien oppdateres
        else {
            // Hale får ny verdi, som er sist i rekken
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        // Oppdaterer teller variablene
        antall++;
        endringer++;
        return true;
    }


    @Override
    public void leggInn(int indeks, T verdi) {

        if (verdi == null){throw new NullPointerException("verdi kan ikke være null");}
        if(indeks < 0 || indeks > antall){throw new IndexOutOfBoundsException("negativ eller for høy indeks!");} // del?

        Node<T> ny = new Node<>(verdi);
        Node<T> h = hode;
        Node<T> t = hale;


        if(antall == 0){ // sett som eneste node i lista
            hode = ny;
            hale = ny;
        }
        else if(indeks == 0){ // sett node først i lista
            Node<T> temp = hode;
            hode = ny;
            ny.neste = temp;
            temp.forrige = hode;
        }
        else{ // om node hverken skal stå først eller bli eneste i lista loopes det igjennom lista
            int i = 1;
            Node<T> temp = hode;
            for(; i<indeks; i++){
                h = h.neste;
            }
            if(indeks == antall){
                // legges sist
                temp = hale;
                hale = ny;
                ny.forrige = temp;
                temp.neste = hale;
            }
            else{
                //legges i midten
                t = h;
                h.neste = ny;
                t.forrige = ny;
                ny.neste = t;
                ny.forrige = h;
            }
        }
        antall ++;
        endringer ++;
    }




    private Node<T> finnNode(int indeks) {
        // Hjelpemetode i oppgave 3a
        /*
        * indeksKontroll() er kjørt fra hent()
        * gjør en sjekk på indeks sin størrelse i forhold til antall. et utfall starter leting fra hale til hode
        og det andre utfallet starter leting fra hode til hale.
        * løp igjennom listen fra hode til hale om indeks er mindre enn antall/2
        * løp igjennom listen fra hale til hode om indeks er større enn antall/2
        * returner verdien til noden som matcher med indeksen
        */

        Node<T> gjeldende;

        if (indeks < antall / 2) {
            gjeldende = hode;
            for (int i = 0; i < indeks; i++) { // let fra hode
                    gjeldende = gjeldende.neste;
            }
            return gjeldende;
        }
        else { // let fra hale
            gjeldende = hale;
            for (int i = antall - 1; i > indeks; i--) { // pass på større/lik her
                    gjeldende = gjeldende.forrige;
            }
            return gjeldende;
        }
    }


    @Override
    public T hent(int indeks) {
        // Metode i oppgave 3a
        // Sliter litt med å forstå oppgaveteksten. går utifra at denne skal kalle finnNode().
        /*
         * kjør indeksKontroll() Her for å sjekke gyldigheten av gitt indeks
         * kall finnNode()
         */
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
        // holder denne eller skal det dannes en node eksplisitt?
    }

    @Override //4 Joacim
    public int indeksTil(T verdi) {
        if (verdi==null) return -1;

        Node<T> p=hode;

        for (int i=0; i<antall; i++, p=p.neste){
            if (p.verdi.equals(verdi)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean inneholder(T verdi){//returnerer true om verdien er i listen
        return indeksTil(verdi) != -1; //kall
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        // Metode i oppgave 3a
        /*
        * kall først indeksKontroll() for å sjekke gyldigheten av gitt indeks
        * Sjekk at nyverdi ikke er en null-verdi.
        * finn indeksen hvor nyverdi skal legges inn og returner den tidligere verdien
        * øk variabel endringer
        */

        indeksKontroll(indeks, false);
        if (nyverdi == null){
            throw new NullPointerException("kan ikke legge inn en null-verdi!");
        }
        Node<T> gjeldende = finnNode(indeks);

        T skalUt = gjeldende.verdi;

        gjeldende.verdi = nyverdi;
        endringer ++;
        return skalUt;
    }

    @Override //6 Joacim
    public boolean fjern(T verdi) {
        if (verdi==null)
            return false;
        Node<T> p=hode;

        while(p!=null){//ser etter verdi
            if (p.verdi.equals(verdi))
                break;
            p=p.neste;
        }
        if (p==null){
            return false;
        }
        else if (antall==1){
            hode=hale=null;
        }
        else if (p==hode){ //if tester til å sjekke hvor noden ligger, endrer.
            hode=hode.neste;
            hode.forrige=null;
        }
        else if (p==hale){
            hale=hale.forrige;
            hale.neste=null;
        }
        else{
            p.forrige.neste=p.neste;
            p.neste.forrige=p.forrige;
        }
        p.verdi=null;
        p.forrige=p.neste=null;

        antall--;
        endringer++;
        return true;
    }

    @Override
    public T fjern(int indeks)  {       //indekskontroll
    indeksKontroll(indeks, false);

    //initialisering av kode
    T temp;
    Node<T> p=hode;

    //leting av node ved hjelp av for-løkke
        for(int i=0; i<indeks; i++){
        p=p.neste;
    }
    //fanger verdien av noden
    temp=p.verdi;

    //if testinger hvor i lenken den ligger og derreter flytter på pekere
        if(p==hode){
        hode=p.neste;
    }
        if(p==hale){
        hale=p.forrige;
    }
        if(p.neste!=null){
        p.neste.forrige=p.forrige;
    }
        if(p.forrige!=null){
        p.forrige.neste=p.neste;
    }

    endringer++;
    antall--;
        return temp;
}

    @Override
    public void nullstill() {
        // Metode i oppgave 7
        // Måte 1
        Node<T> gjeldende = hode;
        for (; gjeldende != null; gjeldende = gjeldende.neste){
            gjeldende.verdi = null;
            gjeldende.forrige = gjeldende.neste = null;
        }
        hode.neste = null;
        hale.forrige = null;
        antall = 0;
        endringer++;
        // Måte 1 velges da den har færre operasjoner sammenliknet med metoden fjern() som kalles i Måte 2

        // Måte 2
        /*for (Node<T> gjeldende = hode; gjeldende != null; gjeldende = gjeldende.neste){
            fjern(0);
        }*/
    }

    @Override                           //8
    public Iterator<T> iterator() {
    //Returner funksjon
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
    return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne=finnNode(indeks);
            iteratorendringer=endringer;
            fjernOK=false;
            //Peker "denne" til noden indeks
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Iteratorendringer er feil");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Ingen flere elementer");
            }
            fjernOK = true;
            T hold= denne.verdi;
            denne=denne.neste;
            return hold;

        }


        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe




