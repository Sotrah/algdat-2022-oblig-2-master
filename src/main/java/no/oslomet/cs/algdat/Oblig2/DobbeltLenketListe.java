package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;


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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
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




