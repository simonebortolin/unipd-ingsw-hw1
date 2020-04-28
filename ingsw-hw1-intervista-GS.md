# Lettura commentata con il committente Matteo Lando
# IS1: primo homework

Si consideri una mappa rettangolare su cui sia sovrapposta una griglia
di coordinate intere x,y che la divide in MxN celle.

> La dimensione della mappa dovrà essere equivalente a quella di una scacchiera perciò 8x8.

In ciascuna cella e’ possibile posizionare sino a cinque “pezzi”. Ogni pezzo e’ caratterizzato da un tipo {elfo/nano/orco}

1. E’ necessario sviluppare una classe specifica per ciascuna tipologia di pezzo.

2. Ogni cella della mappa ha una tipologia (pianura/bosco/montagna)

3. Esiste un riferimento temporale (giorno/notte)

4. I valori di attacco e difesa sono inizialmente definiti per tipologia (A/D) Elfo 5/2; Nano 2/5; Orco 4/4

5. I pezzi sono caratterizzati da modificatori di combattimento (+A%/+D%): elfi bosco +0%/+100%; nani montagna +100%/+0%; orco giorno -50%/-50%; orco notte +50%/+50%

> Per la parte tecnica di programmazione lo sviluppatore è libero di decidere quale sia per lui la strada migliore, e quindi in questo senso non ci sono limitazioni di alcun genere.

Si leggano i dati relativi ad i pezzi da disporre sulla mappa da un file
contenente gruppi di linee di testo secondo il formato:

***X***

***Y***

***tipo***

e li si disponga in una struttura dati adatta. 
> Il file di input è un file .txt formattato come segue: per ogni pezzo si ha che le prime due righe contengono le coordinate della posizione, mentre la seguente rappresenta il tipo. 
> Il nome del file deve venir passato come arg e dato che è già formattato non serve alcun controllo riguardante il testo.

Letti i dati, si calcoli:

1. Il numero di pezzi presenti sulla mappa per ciascuna tipologia;

2. La casella con il maggior valore di difesa di giorno

3. La casella con il maggior valore di difesa di notte

4. La casella con il maggior valore di attacco di giorno

5. La casella con il maggior valore di attacco di notte

6. La casella con il maggior numero di pezzi dello stesso tipo

> - L’applicazione non deve ricevere nessun input al di fuori del file  .txt
> - L’unico output è quello richiesto dai 6 punti precedenti quindi non c’è bisogno che venga visualizzata la mappa o altro.
> - In caso di errore deve venire scritto a schermo un semplice messaggio del tipo “qualcosa è andato storto”.
> - L’output deve venire espresso in sequenza e i dati devono essere separati da una riga vuota.

# Prima intervista

1.  La dimensione della mappa deve essere esattamente 8x8?

> Non è strettamente necessario, l'indicazione era semplicemente per
> dare un'idea della grandezza della mappa.

2.  In una cella è possibile non posizionare nessun elemento?

> Si è possibile, in quel caso semplicemente la cella sarà vuota.

3.  In che modo vengono rappresentati su file due elementi nella stessa     cella?

> Semplicemente si ripetono sia le coordinate che il tipo del pezzo
> rispettando la formattazione del file.

4.  La coordinata della matrice parte da (0,0) o da (1,1)

> Le coordinate della matrice partono da (0,0).

5.  Come vengono creati i territori su ogni cella della mappa: random, sono scritti da qualche parte, algoritmi strani, ...?

> La generazione del tipo della cella deve essere randomica.

6.  Come si comporta se nei punti 2-6 ci sono più celle che hanno un risultato uguale?

> Devono essere stampate tutte le celle che hanno quello specifico
> valore.

7.  Le abilità dei personaggi hanno un limite di incremento e decremento dei valori di attacco e difesa es: +/- 100%?

> Si, gli incrementi sono solo quelli già dati.

8.  L’input è possibile utilizzare tramite arg?

> Si, il nome del file di input viene passato tramite arg.

# Seconda intervista

1.  L’altro committente richiede che “*Viene letto un file di input il  quale descrive la struttura della mappa. Si ricava quindi il     numero di colonne e di righe e per ciascuna cella la sua tipologia      (pianura, bosco, montagna)”* mentre tu “*La dimensione della mappa     dovrà essere equivalente a quella di una scacchiera perciò 8x8.”.*      Si potrebbe fare che il suddetto file è opzionale ed in caso di     assenza di generi una matrice 8x8 con tipologia random? 
> Sì

2.  L’altro committente richiede che “*Semplicemente si inseriscono nelle successive righe gli altri tipi e senza ripetere le     coordinate*”, mentre tu richiedi che “*Semplicemente si ripetono     sia le coordinate che il tipo del pezzo*”. Dato che entrambi i      metodi sono equali e dato che le coordinate sono numeriche mentre     i nomi dei tipi iniziano per una lettera si può fare semplicemente     che il parser legga entrambi i formati?

> Sì

1.  Il file di testo che descrive la struttura della mappa che rappresentazione ha?

> Si possono usati i caratteri p: pianura, f: bosco, m: montagna. Si
> usano le andatura a capo per delimitare le righe. Esempio:\
> mmmmmmmmmmmmmmmm\
> fffmmmmmmmmmffff\
> fffffmmmmmmfffff\
> fffffffmmfffffff\
> ffffffffffffffff\
> ppfffffffffppppp\
> pppppfffffpppppp\
> pppppppppppppppp
# Terza intervista

1.  L’altro committente richiede che “Vengono usati i simboli “P, F, M” rispettivamente per pianura, bosco, montagna. Vengono utilizzate     le andatura a capo per delimitare le righe.” Mentre tu “Si possono     usati i caratteri p: pianura, f: bosco, m: montagna. Si usano le     andatura a capo per delimitare le righe.” Va bene se sono ammessi     entrambi i caratteri sia minuscolo che maiuscolo?

> *Sì*

1.  Sono ammesse dimensioni non regolari della mappa? Forme circolari, forme jagged, …

> *No*
