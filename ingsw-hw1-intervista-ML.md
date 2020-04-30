# IS1: primo homework
# Lettura commentata con il committente Matteo Lando

Si consideri una mappa rettangolare su cui sia sovrapposta una griglia di coordinate intere x,y che la divide in MxN celle.

In ciascuna cella e’ possibile posizionare sino a cinque “pezzi”. Ogni pezzo e’ caratterizzato da un tipo {elfo/nano/orco}

> *Ci sono solo queste 3 tipologie di pezzi.*

1. E’ necessario sviluppare una classe specifica per ciascuna tipologia di pezzo.

2. Ogni cella della mappa ha una tipologia (pianura/bosco/montagna)

3. Esiste un riferimento temporale (giorno/notte)

4. I valori di attacco e difesa sono inizialmente definiti per tipologia (A/D) Elfo 5/2; Nano 2/5; Orco 4/4

5. I pezzi sono caratterizzati da modificatori di combattimento (+A%/+D%): elfi bosco +0%/+100%; nani montagna +100%/+0%; orco giorno -50%/-50%; orco notte +50%/+50%

Si leggano i dati relativi ad i pezzi da disporre sulla mappa da un file
contenente gruppi di linee di testo secondo il formato:

***X***

***Y***

***tipo***

e li si disponga in una struttura dati adatta.

Letti i dati, si calcoli:

1. Il numero di pezzi presenti sulla mappa per ciascuna tipologia;

2. La casella con il maggior valore di difesa di giorno

3. La casella con il maggior valore di difesa di notte

4. La casella con il maggior valore di attacco di giorno

5. La casella con il maggior valore di attacco di notte

6. La casella con il maggior numero di pezzi dello stesso tipo

# Prima intervista


1.  Qual’è la dimensione della mappa e/o come si ottiene?

> *Viene letto un file di input il quale descrive la struttura della mappa. Si ricava quindi il numero di colonne e di righe e per ciascuna cella la sua tipologia (pianura, bosco, montagna)*

2.  è necessario memorizzare in ogni cella e/o a livello globale lo stato del dì (giorno/notte) oppure è necessaria solamente a fini dei calcoli?

> *Con il riferimento temporale ha effetto su tutta la mappa senza distinzione per le celle.*
> *Lo stato temporale può essere modificato dall’utente e deve essere salvato nel file che descrive la mappa.*

3.  In che modo vengono rappresentati su file due elementi nella stessa cella?

> *Semplicemente si inseriscono nelle successive righe gli altri tipi e senza ripetere le coordinate:*

***Xa***

***Ya***

***tipo1a***

***tipo2a***

***tipo3a***

***Xb***

***Yb***

***tipo1b***

***tipo2b***

***tipo3b***

4.  In una cella è possibile non posizionare nessun elemento?

> *In una calla ci posso essere da 0 a 5 elementi.*

5.  Come scelgo la tipologia della cella (montagna/pianura/bosco)?

> *Viene letta dal file che va a descrivere la mappa, come indicato sopra.*

7.  La coordinata della matrice parte da (0,0) o da (1,1)

> *La prima cella inizia da 0,0 e si trova nell’angolo superiore sinistro*

8.  Come vengono creati i territori su ogni cella della mappa: random, sono scritti da qualche parte, algoritmi strani, ...=?

> *Vengono letti dal file (vedi punto 1)*

9.  Come si comporta se nei punti 2-6 ci sono più celle che hanno un risultato uguale?

> *Vengono stampate tutte le celle che soddisfano la data condizione*

10.  Le abilità dei personaggi hanno un limite di incremento e decremento dei valori di attacco e difesa es: +/- 100%?

> *Non vengono definiti altri modificatori di combattimento oltre a quelli già descritti e non *
> *possono essere modificati*

11.  L’input è possibile utilizzare tramite arg?

> *Si, vengono passati i file in input*

12.  Oltre al file di input ed eventualmente la dimensione della mappa e la posizione di (montagna/pianura/bosco) sono richiesti altri input?

> *no*

13.  In caso di errore cosa di deve fare?

> *Si deve avvisare che c’è ma lasciar comunque proseguire il programma*

14.  È necessario che nell’output venga mostrata la mappa?

> *Si, deve essere mostrata una griglia della mappa contenente la tipologia della mappa e i personaggi presenti*

15.  Come vengono separati i dati 1 - 6?

> *Vengono stampati tutti i dati in una sola volta in sequenza*

**Seconda intervista**

1.  L’altro committente richiede che “*La dimensione della mappa dovrà essere equivalente a quella di una scacchiera perciò 8x8.”* mentre tu *“Viene letto un file di input il quale descrive la struttura della mappa. Si ricava quindi il numero di colonne e di righe e per ciascuna cella la sua tipologia (pianura, bosco, montagna)”.* Si potrebbe fare che il suddetto file è opzionale ed in caso di assenza di generi una matrice 8x8 con tipologia random?

> *Sì*

2.  Richiedi che in caso di errore bisogna lasciar comunque proseguire il programma, nel senso che avvisi l’utente dell’errore ma se esso non è fatale continui con l’esecuzione del programma?

> *Sì*

3.  L’altro committente richiede che “*Semplicemente si ripetono sia le coordinate che il tipo del pezzo*”, mentre tu richiedi che“*Semplicemente si inseriscono nelle successive righe gli altri tipi e senza ripetere le coordinate*”. Dato che entrambi i metodi sono equali e dato che le coordinate sono numeriche mentre i nomi dei tipi iniziano per una lettera si può fare semplicemente che il parser legga entrambi i formati?

> *Sì*

4.  Il file di testo che descrive la struttura della mappa cherappresentazione ha?

> *Vengono usati i simboli “P, F, M” rispettivamente per pianura, bosco, montagna. Vengono utilizzate le andatura a capo per delimitare le righe. Esempio:* \
```
PPPPPPPPPPMMMMMM 
PPPPPPPPPPMMMMMM 
PPPPPPPPFFFFMMMM 
PPPPPPPPFFFFMMMM
PPPPPPFFFFFFFFMM 
PPPFFFFFFFFFFFMM 
PPPPPFFFFFFFFFFF 
PPPPFFFFFFFFFFFF 
```

# Terza intervista

1.  L’altro committente richiede che “Si possono usati i caratteri p: pianura, f: bosco, m: montagna. Si usano le andatura a capo perdelimitare le righe.” Mentre tu “Vengono usati i simboli “P, F, M” rispettivamente per pianura, bosco, montagna. Vengono utilizzate le andatura a capo per delimitare le righe.” Va bene se sono ammessi entrambi i caratteri sia minuscolo che maiuscolo?

> *Sì*

2.  Sono ammesse dimensioni non regolari della mappa? Forme circolari, forme jagged, …

> *No*
