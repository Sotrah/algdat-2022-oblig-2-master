package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


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
        throw new UnsupportedOperationException(); // fjerne???
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

        if (a.length > 0){
            int i = 0;
            for(;i < a.length; i++){
                if(a[i] != null) {
                    hode = new Node<>(a[i]);
                    antall++;
                    break;
                }
            }
            hale = hode;
            if (hode != null) {
                i++;
                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        hale.neste = new Node<>(a[i], hale, null);
                        hale = hale.neste;
                        antall++;
                    }
                }
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
        */
        throw new UnsupportedOperationException();
    }


    // Hjelpemetode til 3b
    private void fratilKontroll(int antall, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        //Lagt til fra 1.2.3.c
        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        // er exceptions på de tre siste i ok format?
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
        if (hode == null) return true;
        else return false;
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
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
        int midtVerdi = antall / 2;
        Node<T> gjeldende = null;

        if (indeks < midtVerdi) {
            gjeldende = hode;
            for (int i = 0; i <= midtVerdi; i++) { // let fra hode
                if (i == indeks) {
                    gjeldende = gjeldende.neste;
                }
            }
        }
        if (indeks >= midtVerdi) { // let fra hale
            gjeldende = hale;
            for (int i = antall; i >= midtVerdi; i--) { // pass på større/lik her
                if (i == indeks) {
                    gjeldende = gjeldende.forrige;
                }
            }

        }
        return gjeldende;
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
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException("kan ikke legge inn en null-verdi!");
        }
        Node<T> gjeldende = finnNode(indeks);

        T skalUt = gjeldende.verdi;
        endringer ++;

        gjeldende.verdi = nyverdi;

       return skalUt;
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
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
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




