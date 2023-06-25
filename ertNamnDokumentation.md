# Projekt TODO

## Clara Brorson

### Beskrivning
Projektet är en Todo - applikation som använder en mondoDB databas för att lagra hantera todos. Projektet består av olika klasser som ansvarar för olika områden av programmet. MongoDBFacade klassen hanterar exempelvis anslutningen till databasen samt innehåller metoder för att utföra CRUD - operationer. KeyReader klassen har hand om anslutningssträngen till databasen, om anslutningssträngen inte kan lokaliseras ansluter den till en lokal databas.

Todo klassen kan beskrivas som en modell för en todo, den innehåller dess egenskaper samt metoder. Klassen TodoTests innehåller enhetstest som testar metoderna i Todo klassen. 

Menu klassen hanterar menyn i programmet. Den skapar en instans av Apllication klassen och anropar dess metoder. Application klassen ansvarar för logiken och använder sig av MongoDBFacade för att utföra CRUD - operationer. Den hanterar inmatning från användaren. 

## Planering
Jag skapade en backlog på Github och delade inte arbetet i klasser. Syftet var att få en grundläggande bild av projektet och arbete utefter den. 

[TODO Backlog](https://github.com/orgs/Campus-Molndal-JIN23/projects/49)

### Lösningsförslag innan uppgiften påbörjas

#### Skisser (exempelvis)

#### Hur du tänker försöka lösa uppgiften.(exempelvis)

#### Pseudokod.(exempelvis)

#### Diagram.(exempelvis)

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban

## Arbetet och dess genomförande

### Vad som varit svårt

### Beskriv lite olika lösningar du gjort

### Beskriv något som var besvärligt att få till

### Beskriv om du fått byta lösning och varför i sådana fall

## Reflektion & Slutsatser

### Vad gick bra

### Vad gick dåligt

### Vad har du lärt dig

### Vad hade ni gjort annorlunda om ni gjort om projektet

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
