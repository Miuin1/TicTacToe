# TicTacToe

Public GitHub Repository:  
https://github.com/Miuin1/TicTacToe

## Projektbeschreibung

Dieses Projekt ist eine Java-Maven-Implementierung des Spiels **TicTacToe**.

Das Spiel läuft über die Konsole und erlaubt zwei Spielern abwechselnd ihre Spielzüge einzugeben. Das Spielfeld besteht aus 3x3 Feldern. Spieler 1 verwendet den Marker `X`, Spieler 2 verwendet den Marker `O`.

Das Projekt wurde als Gruppenprojekt umgesetzt. Dabei wurden Git, Feature Branches, Pull Requests, ein Kanban Board, automatisierte Tests und GitHub Actions verwendet.

## Technologien

- Java
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions
- Kanban Board / GitHub Projects

## Projektstruktur

```text
TicTacToe/
├── .github/
│   └── workflows/
│       ├── ci.yml
│       └── build-main.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── board/
│   │       ├── game_master/
│   │       ├── main_game_package/
│   │       └── player/
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## Klassendesign

Das Projekt orientiert sich an einem Klassendiagramm mit folgenden Hauptklassen:

- `Player`
- `Board`
- `TicTacToe`
- `Main`

Zusätzlich werden Interfaces verwendet, um die Implementierung besser zu strukturieren und testbarer zu machen.

### Player

Die Klasse `Player` speichert den Marker eines Spielers, also `X` oder `O`.

Wichtige Methode:

```java
char getMarker()
```

### Board

Die Klasse `Board` verwaltet das 3x3-Spielfeld.

Wichtige Methoden:

```java
boolean isCellEmpty(int x, int y)
void place(int x, int y, char marker)
boolean isFull()
void clear()
void print()
```

Das Board verwendet Koordinaten von `0` bis `2`.

Beispiele:

```text
0,0 = oben links
1,1 = Mitte
2,2 = unten rechts
```

### TicTacToe

Die Klasse `TicTacToe` enthält die Spiellogik.

Sie verwaltet:

- aktuellen Spieler
- Spielablauf
- Spielerwechsel
- Gewinnerprüfung
- ungültige Eingaben
- belegte Felder
- Unentschieden

### Main

Die Klasse `Main` startet das Spiel.

Sie enthält außerdem:

- Welcome Banner mit ASCII Art
- Spielwiederholung
- Möglichkeit zum Beenden
- Exception Handling
- Exit Codes

## Anwendung starten

Das Projekt kann über Maven gebaut werden.

### Tests ausführen

```bash
mvn clean test
```

### JAR bauen

```bash
mvn clean package
```

### JAR ausführen

```bash
java -jar target/TicTacToe-1.0-SNAPSHOT.jar
```

## Bedienung

Beim Start erscheint ein Welcome Banner. Danach geben die Spieler abwechselnd Zeile und Spalte ein.

Gültige Werte sind jeweils:

```text
0, 1, 2
```

Beispiel:

```text
Zeile eingeben (0-2): 1
Spalte eingeben (0-2): 1
```

Dieser Zug setzt den Marker in die Mitte des Spielfeldes.

Das Spiel kann beendet werden mit:

```text
Windows: Ctrl+Z, danach Enter
macOS/Linux: Ctrl+D
```

Alternativ kann bei der Eingabe verwendet werden:

```text
q
quit
exit
```

Nach einem abgeschlossenen Spiel kann der Benutzer entscheiden, ob er erneut spielen möchte.

## Software Lifecycle

Für das Projekt wurde ein einfacher Software Lifecycle verwendet:

```text
User Story auswählen
→ Feature Branch erstellen
→ Implementierung durchführen
→ Tests schreiben oder erweitern
→ Commit erstellen
→ Push auf Feature Branch
→ Pull Request erstellen
→ Code Review durchführen
→ Merge nach staging
→ finaler Pull Request nach main
→ automatischer Build und JAR Upload
```

## Kanban Board

Die User Stories wurden über ein Kanban Board verwaltet.

Das Board enthielt typische Spalten wie:

```text
To Do
In Progress
Review
Done
```

Jedes Gruppenmitglied konnte eine User Story aus dem Board übernehmen. Dadurch war jederzeit sichtbar, welche Aufgaben offen, in Bearbeitung oder abgeschlossen waren.

### Screenshot Kanban Board

<img width="1861" height="835" alt="image" src="https://github.com/user-attachments/assets/fd95897d-76ca-48b0-ba11-721fcfaba483" />

## Feature Branch Workflow

Für jede größere Aufgabe wurde ein eigener Feature Branch verwendet.

Beispiele für Branches:

```text
Board
Player
TicTacToe
staging
main
```

Die Feature Branches wurden verwendet, damit mehrere Gruppenmitglieder parallel arbeiten konnten, ohne direkt Änderungen auf `main` vorzunehmen.

Beispiel:

```bash
git checkout -b Board
```

Nach der Implementierung wurde der Branch gepusht:

```bash
git push origin Board
```

## Pull Request Workflow

Änderungen wurden nicht direkt in `main` committed.

Stattdessen wurde für jede abgeschlossene Aufgabe ein Pull Request erstellt.

Typischer Ablauf:

```text
Feature Branch pushen
→ Pull Request öffnen
→ Änderungen prüfen
→ Tests ausführen lassen
→ Pull Request mergen
```

Dadurch konnten Änderungen kontrolliert überprüft werden, bevor sie in den Hauptstand übernommen wurden.

### Screenshot Pull Request

<img width="1161" height="896" alt="image" src="https://github.com/user-attachments/assets/a77fbdd0-85c2-47b7-ba50-82fc4210788d" />

## Beispielprozess für eine User Story

Beispiel-User-Story:

<img width="1038" height="578" alt="image" src="https://github.com/user-attachments/assets/d51fc3a8-5f84-4de0-9bfd-04da7e86da47" />

### 1. User Story übernehmen

Die User Story wurde im Kanban Board von `To Do` nach `In Progress` verschoben.

### 2. Feature Branch erstellen

Für die Aufgabe wurde ein Branch erstellt:

```bash
git checkout -b Board
```

### 3. Implementierung

In der Klasse `Board` wurden Methoden wie `isCellEmpty()` und `place()` implementiert.

Dabei wurde darauf geachtet, dass:

- nur gültige Koordinaten akzeptiert werden
- belegte Felder nicht überschrieben werden
- das Spielfeld Koordinaten von `0` bis `2` verwendet

### 4. Tests

Für die Board-Logik wurden Unit Tests geschrieben.

Dabei wurden positive und negative Testfälle verwendet.

Beispiele:

- Feld ist leer
- Feld ist belegt
- Marker wird korrekt gesetzt
- belegtes Feld wird nicht überschrieben
- ungültige Koordinaten werden abgefangen

### 5. Commit

Die Änderungen wurden mit einer sinnvollen Commit Message gespeichert:

```bash
git commit -m "Fix board coordinate validation and printing"
```

### 6. Push und Pull Request

Der Branch wurde gepusht:

```bash
git push origin Board
```

Danach wurde ein Pull Request erstellt und nach erfolgreicher Prüfung gemerged.

## Git

Im Projekt wurden mehrere Branches verwendet:

```text
main
staging
Board
Player
TicTacToe
```

`main` enthält den stabilen Stand des Projekts.

`staging` wurde verwendet, um Features vor dem finalen Merge nach `main` zusammenzuführen.

Feature Branches wurden für einzelne Aufgaben verwendet.

Beispiele für Commit Messages:

```text
Implement Player class
Implement Board logic
Fix board coordinate validation and printing
Implement TicTacToe game loop
Add unit tests for TicTacToe
Add CI tests and JAR build workflow
```

## Testing

Für das Projekt werden Unit Tests mit JUnit 5 verwendet.

Die Testkonfiguration befindet sich in der `pom.xml`.

Wichtige Maven-Konfiguration:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

Zusätzlich wird das Maven Surefire Plugin verwendet, damit die Tests zuverlässig über Maven ausgeführt werden können.

Die Tests enthalten positive und negative Testfälle.

Beispiele:

- Spieler `X` gewinnt über eine Zeile
- Spieler `O` gewinnt über eine Spalte
- Spieler gewinnt über eine Diagonale
- Spiel endet unentschieden
- belegte Felder werden nicht überschrieben
- ungültige Eingaben werden behandelt

Tests können lokal ausgeführt werden mit:

```bash
mvn clean test
```

### Screenshot Testlauf

<img width="1830" height="928" alt="image" src="https://github.com/user-attachments/assets/14c8a3fb-0ae6-4dbc-b9de-87a2f0661136" />

## DevOps

Für DevOps wurden GitHub Actions verwendet.

Es gibt zwei Workflows:

```text
ci.yml
build-main.yml
```

### Automatische Tests

Bei jedem Push auf einen Feature Branch werden automatisch Tests ausgeführt.

Workflow:

```text
.github/workflows/ci.yml
```

Dieser Workflow führt aus:

```bash
mvn clean test
```

Dadurch wird geprüft, ob neue Änderungen die bestehenden Tests bestehen.

### JAR Build auf main

Bei jedem Merge nach `main` wird automatisch eine JAR-Datei gebaut und als GitHub Actions Artifact hochgeladen.

Workflow:

```text
.github/workflows/build-main.yml
```

Dieser Workflow führt aus:

```bash
mvn clean package
```

<img width="1829" height="912" alt="image" src="https://github.com/user-attachments/assets/f88931c0-e63c-4f80-aeea-a80bae1d8f39" />

Danach wird die generierte JAR-Datei aus dem `target/`-Ordner als Artifact hochgeladen.

Das Artifact ist in GitHub unter folgendem Pfad sichtbar:

```text
Repository → Actions → Build Main JAR → Workflow Run → Artifacts
```

### Screenshot GitHub Actions

<img width="1171" height="508" alt="image" src="https://github.com/user-attachments/assets/605d731a-23bf-4300-a247-d21380ca231c" />

<img width="1155" height="933" alt="image" src="https://github.com/user-attachments/assets/f7c96a06-981d-485b-b0e0-78f814e12186" />

### Screenshot JAR Artifact

<img width="1155" height="945" alt="image" src="https://github.com/user-attachments/assets/2e0a4597-ce9f-4462-803e-9429ca7a31c9" />

## Exit Codes

Die Anwendung verwendet Exit Codes, um das Programmende sauber zu kennzeichnen.

```text
0 = erfolgreich beendet
1 = unerwarteter Fehler
2 = Eingabe wurde geschlossen
```

## Fazit

Das Projekt erfüllt die Anforderungen eines kleinen Java-Gruppenprojekts mit Git, Maven, Unit Tests und GitHub Actions.

Durch Feature Branches, Pull Requests und ein Kanban Board wurde ein strukturierter Software Lifecycle umgesetzt.

Automatisierte Tests und ein automatischer JAR Build unterstützen die Qualitätssicherung und den DevOps-Prozess.
