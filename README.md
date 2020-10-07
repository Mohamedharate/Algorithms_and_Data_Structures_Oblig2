# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende studenter:

* Mohamed Khir Harate, S338672, s338672@oslomet.no

* Hanna Bækken Nilsen, S341879, s341879@oslomet.no

* Andreas Torres Hansen, S338851, s338851@oslomet.no


Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Mohamed K. Harate har hatt hovedansvar for oppgave 1, 2, og 7. 
* Andreas Torres Hansen har hatt hovedansvar for oppgave 3, 6, og 9. 
* Hanna Bækken Nilsen har hatt hovedansvar for oppgave 4, 5 og 8. 
* Vi har i fellesskap løst oppgave 10. 

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: Løste ved å implementere variabelen index som skal finne det første elementet i tabellen 
som ikke er null. Dette gjorde jeg ved bruk av en while-løkke som går gjennom tabellen fra index=0 og plusser 
index med 1 for for a[index] == null. Vi går ut av løkken når vi finner et element som ikke er null. Deretter sjekker 
jeg om indexen er mindre enn a.length, altså indexen til et tall i tabellen a. Hvis ja, setter jeg hode = hale = det
første elementet som ikke er lik null. Vi har nå en liste består av kun et element. Så går vi gjennom tabellen a fra index
til a.length. Vi sjekker om a[index] != null. Hvis ja, lager vi en ny node som skal plasseres etter hale og setter hale 
lik det nye elementet.
        
                                                          
* Oppgave 2: 
2A - toString og omvendtString løste jeg ved å opprette en stringBuilder som inneholder "[". Det først jeg gjør er
å sjekke at listen har innhold. Hvis ikke returner jeg "[]", men hvis listen har innhold, bruker jeg en for-løkke
for å gå gjennom listens elementer og legger til verdien til hvert element til i stringBuilder-en. returner så ut stringBuileren. 


2B - Denne oppgaven valgte jeg å løse ved først å sjekke om listen er tom. Hvis listen er tom da skal verdi være
både hode og hale. Hvis listen har 1 eller flere elementer, skal verdi legges bakerst. Altså vi lager en node og setter 
den til ny hale.



* Oppgave 3:

3A:
finnNode() valgte jeg å løse ved hjelp av en enkel if-else-statement, der jeg sjekker om hvorvidt vi befinner oss i første eller
andre halvdel av den lenkede listen. Hent() og oppdater() bruker finnNode()-metoden, for å finne verdien de skal jobbe med og returnerer eller bytter
ut en gammel verdi henholdsvis.

3B:
I metoden sub-liste har jeg valgt å opprette et array av den generiske klassen T, som jeg fyller med verdiene
fra "fra"-indeksen til "til"-indeksen som blir tatt inn som parametere. Deretter bruker jeg bare konstruktøren 
DoubleLinkedList(T[]), og oppretter en ny lenket liste av arrayet.

* Oppgave 4:

Denne oppgaven har jeg løst ved å bruke if-setninger ved å sjekke om verdien finnes i lista eller ikke. Om verdien fins skal jeg returnere 1
hvis ikke skal jeg returnere -1. Jeg skal også returnere -1 hvis veriden er en null-verdi. Jeg lager også en metode, boolean inneholder, som 
returnerer false eller true om den finner verdien i lista. Hvis den returerer true skal indeksTil metoden 
finne indeksen - ved hjelp av forløkke - og returnere denne.


* Oppgave 5:

Metoden leggInn(int indeks, T verdi) skal legge inn en verdi på ønsket indeks inn i en liste. Ved hjelp av if-setninger får jeg sjekket om 
man skal legge inn verdien, først, sist eller mellom to verdier. Utifra disse utfallene laget jeg kode som tilfredstiller både posisjon og 
om pekerne blir korrekte.  


* Oppgave 6:

Fjern(index):
Denne metoden har jeg valgt å løse ved hjelp av en enkelt if-statement som sjekker etter alle de ulike spesialtilfellene
som kan oppstå. Dersom den ikke finner noen av disse, antar den at noden vi leter etter har både en neste- og forrige-peker 
og at disse kan festes til hverandre.

Fjern(verdi): 
Denne metoden har jeg valgt å løse ved å implementere en for-løkke som går gjennom hele listen fram til den finner verdien vi leter etter.
Da vil den slette denne verdien på samme måte som fjern(indeks)-metoden gjør, ved å sjekke etter spesialtilfellene.

* Oppgave 7:

Denne oppgaven valgte jeg å løse ved å gå gjennom alle elementer fra hode til hale 
ved bruk av en while-løkke. Etter å ha slettet alle elementer, setter jeg hode = hale = null, 
nullstiller antall og øker endringer med 1. 

* Oppgave 8:

8a - T next metoden skal sjekke om iteratorendringer blir lik endringer for å informere at listen er endret. 
Motoden skal også sjekke om hasNext er sann, hvsi ikke kastes det en feilmelding om at det ikke er flere igjen i listen. 

8b - I denne oppgaven skal man bare returnere en instans av iteratorklassen.

8c - Konstruktøren skal være nesten helt lik som den fertdigkodet kontruktøren, men denne noden skal 
skal peke på den indeksen som skal inn i konstruktøren. Da bruker jeg metoden finnNode som setter riktig peker på 
denne. 

8d - I denne oppgaven sjekker jeg ved hjelp av indeksKontroll om indeksen er riktig. Hvis denne er riktig 
returnerer jeg en instans av iteratorklassen ved hjelp av kontruktøren i oppgave c. 

* Oppgave 9:
* Oppgave 10:
