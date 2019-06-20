# ANALISI INCARICHI COMUNE DI BOLOGNA
La seguente applicazione Java legge ed effettua il parsing dell'elenco degli incarichi esterni che il comune di Bologna autorizza ai propri dipendenti.
Il dataset in questione è l'elenco del 2018 (dataset con piu righe) del seguente json https://www.dati.gov.it/api/3/action/package_show?id=d75a0f5f-729b-4b3c-8c5a-f70e6ff112a2
Si possono inoltre ottenere i dati, metadati o le statistiche in formato json mediante richieste GET tramite la REST API

## AVVIO
- Windows: avviare il file batch [launcher](target/launcher.bat) presente nella cartella /target
- Altri OS: avviare tramite command line Incarichi-1.0.jar nella cartella /target
- In alternativa compilare manualmente l'applicazione

All'avvio se il dataset non fosse presente verrà scaricato automaticamente. Al completamento verrà effettuato il parsing dei dati. 
Successivamente verrà avviata l'applicazione Spring Boot che permetterà di effettuare le richieste GET. Al termine dell'inizializzazione la console stamperà su schermo PRONTO!

## UTILIZZO RICHIESTE GET
Si possono effettuare le richieste sia da un web browser o dal software Postman, si consiglia quest'ultimo per avere una visualizzazione del json più ordinata e per avere più controllo sulle query string.

Il server su cui vanno effettuate le richieste è [http://localhost:8080/](http://localhost:8080/)
Aggiungere all'url le seguenti query string per le richieste (o cliccare sul link se si utilizza un browser)

**RICHIESTE:**
- [/data](http://localhost:8080/data) Per la restituzione di tutti i dati del dataset in formato json (JsonArray)
- [/metadata](http://localhost:8080/metadata) Per la restituzione dei metadati, specificando nome completo, tipo di dato e alias utilizzato per la richiesta di calcolo delle statistiche
- [/stats](http://localhost:8080/stats) Per la restituzione di statistiche sulla colonna di dati richiesta, se non si specifica il field verranno restituite le statistiche sulla colonna "Tipologia Incarico" . Per specificare il campo aggiungere all'url    __?field=nome__ (ovvero __localhost:8080/stats?field=nome__) e sostituire __nome__ con l'alias del campo desiderato: 

Campo | Alias
-------- | -----
Numero PG Atto | n_atto
Anno PG Atto | anno_atto
Tipologia Incarico | tipologia
Compenso presunto (in euro) | compenso
Soggetto conferente | soggetto
Data inizio incarico | inizio
Data fine incarico | fine
Durata incarico (giorni) | durata
Se il campo richiesto contiene stringhe verrà restituito il conteggio degli elementi unici (ricorrenze di ogni elemento unico). Il numero dell'atto e l'anno dell 'atto pur essendo numeri sono passati durante il parsing come stringhe, questo perchè il numero dell'atto è un codice univoco mentre l'anno è identico per tutti i dati, in entrambi casi ha poco senso calcolare le statistiche numeriche.
Se il campo richiesto contiene numeri restituisce il conteggio di tutti i dati non vuoti, somma, media, minimo, massimo e deviazione standard. Per la durata le statistiche sono arrontondate.


```
