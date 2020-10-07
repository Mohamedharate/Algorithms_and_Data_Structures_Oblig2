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

* Hanna Nilsen, S341879, s341879@oslomet.no

* Andreas Torres Hansen, S338851, s338851@oslomet.no


Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Mohamed K. Harate har hatt hovedansvar for oppgave 1, 2, og 7. 
* Andreas Torres Hansen har hatt hovedansvar for oppgave 3, 6, og 9. 
* Fatima har hatt hovedansvar for oppgave 7 og 8. 
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
* Oppgave 5:
* Oppgave 6:

Fjern(index):
Denne metoden har jeg valgt å løse ved hjelp av en enkelt if-statement som sjekker etter alle de ulike spesialtilfellene
som kan oppstå. Dersom den ikke finner noen av disse, antar den at noden vi leter etter har både en neste- og forrige-peker 
og at disse kan festes til hverandre.

Fjern(verdi): 
Denne metoden har jeg valgt å løse ved å implementere en for-løkke som går gjennom hele listen fram til den finner verdien vi leter etter.
Da vil den slette denne verdien på samme måte som fjern(indeks)-metoden gjør, ved å sjekke etter spesialtilfellene. Denne alternerer i effektivitet fordi den noen ganger må gå gjennom hele listen.

* Oppgave 7:
Denne oppgaven valgte jeg å løse ved å gå gjennom alle elementer fra hode til hale 
ved bruk av en while-løkke. Etter å ha slettet alle elementer, setter jeg hode = hale = null, 
nullstiller antall og øker endringer med 1. 

* Oppgave 8:
* Oppgave 9:
Denne oppgaven har jeg valgt å løse med samme fjerningsmetodikk som jeg har brukt i oppgave 6. Den sjekker om hvorvidt noden vi skal fjerne ligger
mellom to noder, ved hjelp av if-else-setninger.Så retter den neste-pekeren og forrige-pekeren på de nodene rundt den til hverandre, og "lar" java slette noden selv.
* Oppgave 10:
I denne sorterings-metoden har jeg valgt å bruke insertion-sort algoritmen. Den antar altså at første element i listen
er sortert, og sjekker deretter om resten av tallene som kommer etter er mindre. Dersom de er mindre flyttes de bak den. Dette gjøres parvis for alle verdiene.
