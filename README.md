# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Joacim Siring Sørlle, S341549, s341549@oslomet.no
* Jonas Olsson, S364699, s364699@oslomet.no
* ...

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Jonas har hatt hovedansvar for oppgave 1, 3, 5 og 7 
* Joacim har hatt hovedansvar for oppgave 2, 4, 6 og 8
# Oppgavebeskrivelse

OPPGAVE 1:
    Først ble de to metodene tom() og antall() implementert. tom() sjekker om hode
    er null med en enkel if-setning og returnerer true om den er det. ellers returneres false.
    antall() returnerer kun variablen antall som behandles flere steder i koden.
    KONSTRUKTØREN:
    Konstruktøren tar inn lista a og sjekker om denne er tom. om den er tom kastes en
    exception. Hvis a er større enn 0 kjøres en for-løkke. en if-setning finner at første
    element ikke er null og gjør dette elementet til hode, og bryter ut av for-løkken.
    Etter dette er det skrevet hale=hode. dette fordi vi nå kun har et element i den lenkede listen.
    videre lages resten av listen gjennom en ny for-løkke med en if-setning. som opprettter
    en ny node om a[i] ikke er null. opprettingen og tildelingen av pekere skjer ved at hale sin 
    neste-peker tildeles den nye verdien, etter dette tildeles selve halen verdien til nevnte peker.

OPPGAVE 2:
    I oppgave 2 brukte jeg kompendiet (4.3.2) som hjelpemiddel/mal.
    Gikk frem ved å lage toString for vårt formål,
    for så å lage omvendtString som var relativt lik bare omvendt.
    Deretter brukte jeg 3.3.2 f fra kompendiet som hjelpemiddel/mal igjen for leggInn.

OPPGAVE 3a:
    finnNode() ble implementert ved å først deklarere en node "gjeldende". Videre er det
    skrevet en if-setning som sjekker om indeksen er mindre enn lista sin størrelse delt på 2.
    når denne testen slår ut letes det fra starten av lista med en for-løkke som løper helt
    til i sin verdi har nådd verdien til indeksen det søkes etter. gjeldende blir tildelt gjeldende.neste  
    for hver runde i løkka. if-setningen returnerer gjeldende.
    funksjonaliteten i leting fra hale er helt lik bortsett fra at parametere i for-løkka
    er reversert og at gjeldende tildeles gjeldene sin forrige.
    hent() er en metode som kaller indekskontroll med gitt indeks som parameter og så kaller
    finnNode() med indeksen som parameter i sitt return statement.
    Oppdater() kaller indekskontroll, og sjekker i tillegg om nyverdi er en null-verdi.
    Om disse to testene passeres lages noden gjeldende. denne noden får verdien sin tildelt
    gjennom finnNode() med indeks som parameter. 
    så lages T skalUt som blir tildelt verdien til gjeldende.
    noden gjeldende blir tildelt nyverdi som metoden tar inn som parameter.
    til slutt returneres T skalUt.



OPPGAVE 3b:
    subliste() begynner med å kalle fratilKontroll() for å sjekke at intervallet som angis
    er gyldig. Så deklareres en Liste<T> subliste som er den dobbeltlenkede listen vi skal returnere
    variblen lengde opprettes for bruk i to if-setninger. den første if-setningen sjekker
    om lengden er mindre enn 1 og returnerer sublista med en gang om testen slår inn.
    node gjeldende blir nå tildelt verdi gjennom finnNode med fra som parameter. dette for at   
    noden som opprettes skal få verdien til indeksen spesifisert med fra i metodekallet.
    så kjøres en while-løkke helt til lengden (som minkes pr iterasjon) er 0. inne i løkken
    kalles leggInn som legger inn gjeldende i lista. så tildeles gjeldende gjeldende sin neste
    og telleren lengde minkes med 1.

OPPGAVE 4:
    Her brukte jeg programkode 3.3.3 fra kompendiet. Lagde indeksTil først for så å
    sette noden til å være hodet til løkken, og verdien å være lik i.

OPPGAVE 5:
    blæblæblæ

OPPGAVE 6:
    Her er metodene veldig like, men "letingen" av koden er annerledes. 
    Fjern med boolean bruker "while" og en haug av if/elseif statements for å lete seg frem å gjøre gitt endring.
    Mens fjern int bruker "for" og en masse if's.

OPPGAVE 7:
    De to versjonene av metodene starter med å deklarere en node gjeldende som blir tildelt hode.
    en for-løkke løper så lenge gjeldende ikke er null, og for hver runde blir gjeldende (som fungerer som teler)
    gjeldende sin neste. 
    Den første metoden har kode i kroppen til for-løkken som sier:
    for hver iterasjon setter gjeldende sin verdi til null, samt dens forrige og neste-peker.
    Den andre metoden har et metodekall til fjern(0) i kroppen til for-løkken.

OPPGAVE 8:
    Gjorde deloppgavene først med å bringe inn public iteratorene. Så brukte vi iteratoren som returnerer
    DobbeltLenketListeIterator. Deretter funksjonen next() som sjekker om verdien gitt er gyldig,
    for så å iterere videre i listen.
    
ERRORS:
