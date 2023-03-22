# Chess Game - Versione terminale

[![Java CI with Maven](https://github.com/ec25p5e/ChessTerminal/actions/workflows/maven.yml/badge.svg)](https://github.com/ec25p5e/ChessTerminal/actions/workflows/maven.yml)
[![License](https://img.shields.io/github/license/ec25p5e/ChessTerminal)](https://github.com/ec25p5e/ChessTerminal/blob/master/LICENSE)
[![Release](https://img.shields.io/github/v/release/ec25p5e/ChessTerminal?include_prereleases)](https://github.com/ec25p5e/ChessTerminal/releases)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)]()
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/ec25p5e/ChessTerminal/issues)


Semplice gioco degli scacchi implementato a oggetti in Java.
Il progetto è nato nell'anno 2022 come progetto scolastico di metà corso.

<br />

## Indice  
1. [Descrizione del problema](#descrizione-del-problema)  
2. [Analisi soluzione proposta](#analisi-soluzione-proposta)  
    - [Gestione delle pedine](#gestione-delle-pedine)
    - [Gestione delle coordinate](#gestione-delle-coordinate)
    - [Gestione dei file](#gestione-dei-file)
    - [GUI (Terminale)](#gui-terminale)
3. [Progettazione](#progettazione)
4. [Installazione](#installazione)
5. [Struttura delle cartelle (package)](#struttura-delle-cartelle-package)
6. [Librerie implementate](#librerie-implementate)
7. [Volete contribuire?](#volete-contribuire-)
8. [Licenza](#licenza-)

<br />


## Descrizione del problema

Definire una struttura di dati in grado di registrare lo stato di una scacchiera su file ed implementare un’applicazione con le seguenti funzionalità.
  1. Leggere la struttura dati definita
  2. Scrivere tale struttura dati
  3. Posizionare sulla scacchiera le pedine alle coordinate definite dall’utente
  4. Implementare i seguenti controlli 
      - Controllare che non ci siano più pedine su una cella
  6. Rappresentare testualmente la struttura di dati definita
  7. Rappresentare la scacchiera in formato ASCII
  8. Non essere in grado di muovere le pedine


## Analisi soluzione proposta

La soluzione proposta soddisfa tutte le richieste e presenta anche funzionalità aggiuntive, le quali sono:
  - Implementazione dei seguenti controlli:
      1. Controllare che la pedina esista
      2. Controllare le dimensioni della scacchiera
      3. Controllare che la pedina non abbia coordinate al di fuori della scacchiera
      4. Controllo di formattazione sul file di lettura
      5. Controllo dei dati di input (file di lettura)
  - Aggiunta di colori al terminale
  - Possibilità di personalizzare le cartelle (fileManager)
  
Di seguito gli aspetti principali della scacchiera analizzati più nel dettaglio. 


### Gestione delle pedine

Data l’esistenza di sei differenti pedine nel gioco ho implementato una soluzione a oggetti
sfruttando l’ereditarietà, astrazione e override dei metodi, così da poter rendere ottimale il tutto.

![image](https://user-images.githubusercontent.com/57130266/226833326-5a08d538-e118-4560-a14a-9b750aaaf00e.png)
 
Infatti, se si volesse aggiungere la possibilità di muovere le pedine all’interno della scacchiera, sarebbe necessario 
solamente aggiungere dei metodi alla classe “BoardPiece” e alle singole sottoclassi ed eventuali metodi ad alcuni pezzi 
particolari come “re” o “regina” senza dover modificare la struttura come si può notare nell’immagine sottostante.

![image](https://user-images.githubusercontent.com/57130266/226833382-48506eea-c431-4aaa-a4ab-af039c565872.png)


### Gestione delle coordinate

Nel gioco degli scacchi per far riferimento a una specifica cella si utilizza la combinazione lettera + numero. 
Questo sistema fa riferimento utilizzando la lettera quando si lega all’asse X, mentre il numero all’asse Y. 
Questo metodo fa si che questa rappresentazione non sia utilizzabile parlando di una matrice (che si localizza 
una cella mediante indici). Quindi i valori vengono convertiti. Più nel dettaglio il flusso.


Innanzitutto, il metodo “placeNewPiece” chiama il metodo “placePiece” per poter immettere alle specifiche coordinate 
il pezzo, dunque viene istanziato un oggetto “ChessCoordinate” (passandogli le coordinate di sorgente) il quale tramite 
il metodo “toBoardCoordinate” ritornerà un’oggetto di tipo “BoardCoordinate” utilizzato nel metodo “placePiece” per poter 
posizionare correttamente nella matrice la pedina.

![image](https://user-images.githubusercontent.com/57130266/226833798-804f006e-f639-41d4-96e6-a3e5807c33e3.png)

### Gestione dei file

Data la necessità di poter leggere e scrivere una struttura di dati in grado di memorizzare lo stato delle partite è 
sorta la necessità di avere un “FileManager” il quale ha il compito di eseguire dei controlli sulle cartelle, file, 
letture, scritture e dei controlli di base sui file “.json”. 

Dunque, pensato di organizzarlo in un’unica classe la quale sarà istanziata nel “TerminalManager” (classe che si occupa 
di tutte le interazioni tra il giocatore ed il programma) e sarà utilizzata come attributo nel “ChessGame” (classe il quale 
scopo è quello di gestire l’intera partita). Di seguito lo schema per illustrare la struttura ed i legami con altre classi.

### GUI (Terminale)

Per rendere più bella esteticamente la visualizzazione nel terminale utilizzando le sequenze di Escape ANSII. Tali sequenze 
sono uno standard per la segnalazione interna del controllore del cursore, colore, stile dei caratteri e altre opzioni eseguibili 
in terminale. In questo caso le ho utilizzate per aggiungere un po' di colore basandomi su questa [guida](https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/).

Inoltre, la scacchiera è possibile visualizzarla in formato ASCII o stampando una tabella contenente le pedine e le coordinate.


## Progettazione

N.B: Il seguente schema UML è stato generato dopo aver completato lo sviluppo del programma dato che lo schema iniziale era solo 
mentale e non schematizzato. Dunque, non è possibile confrontare il prima dello sviluppo con il dopo.

![image](https://user-images.githubusercontent.com/57130266/226834445-e224fbaa-93d1-488d-a062-0eda3d6f4b3a.png)

Schema UML con mostrati i costruttori, proprietà, attributi e metodi.

![image](https://user-images.githubusercontent.com/57130266/226834552-653449ed-1314-42fe-aea5-1c022c04f42d.png)

<br />


## Installazione
1. Estrarre i file dalla ZIP
2. Aprire la cartella all'interno di un IDE
3. Eseguire la build del progetto

<br />



## Struttura delle cartelle (package)📦
    
    ChessGame               
    ├── src                 
    │   ├── main            
    |   │   |__ java                # Package di origine con la logica dentro   
    |   |   |   |── board           # Logica della scacchiera virtuale
    |   |   |   |── chess           # Logica della scacchiera fisica
    |   |   |   |── pieces          # Classi delle pedine
    |   |   |   |── presentation    # Presentazione in terminale della scacchiera
    |   |   |   |── storage         # Gestione dei file (lettura e scrittura)
    |   |   |   |__ utils           # File di utility (come costanti)
    |   |   |       |__ exception   # Handler di eccezioni custom
 

<br />

## Librerie implementate

- [Lombok](https://projectlombok.org/)
- [JSON Simple](https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm)

<br />

## Volete contribuire? 🤝
Se vuoi contribuire a questa applicazione, sei sempre il benvenuto! Leggi [linee guida per contribuire](https://github.com/ec25p5e/ChessGame/blob/master/CONTRIBUTING.md). 

<br />

## Licenza 🔖
```
    Apache 2.0 License
    Copyright 2021 Spikey sanju
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
