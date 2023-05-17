<h1>Gra Mastermind</h1>
<br>

<h2>Genesis</h2>
<p>Gra powstała w ramach zaliczenia przedmiotu <i>podstaw programowania obiektowego (semestr 2)</i>. Jest to już czwarte podejście, na szczęście zakończone sukcesem. Z poprzednich prób zachowały się repozytoria, więc można podejrzeć kolejne etapy rozwoju projektu (ostrzegam może boleć w oczy). Wszystkie elementy składające się na całość zostały wykonane samodzielnie. Łączna ilość godzin spędzona nad projektem kilkukrotnie przewyższa czas potrzebny na dobre przygotowanie się do egzaminu, więc mam nadzieję, że chociaż było warto.</p>
<br>

<h2>
<h2>Co to Mastermind?</h2>
<p>Mówiąc własnymi słowami mastermind to dość stara dwuosobowa gra logiczna, w której skład oryginalnie wchodzą plansza i kolorowe koraliki. W zależności od modelu były wersje na 4-5 kolumn oraz 8-12 kolorów do wyboru.<br>
Jeden z graczy zadawał wzór, czyli za osłoną układał w wymyślonej przez siebie kolejności korali, tak aby się nie powtarzały. (Chociaż nic nie stoi na przeszkodzie, żeby grać inaczej) Zadaniem drugiego gracza było odgadnięcie ukrytego wzoru. Układał koraliki w kolejnych rzędach, a pierwszy gracz je sprawdzał. W ramach odpowiedzi wstawiał odpowiednie kolory:<br>
<b>CZARNY</b> - jeżeli koralik znajdywał się w odpowiednim miejscu<br>
<b>BIAŁY</b> - jeżeli koralik występował, ale w innym miejscu<br>
<b>PUSTE</b> - brak koralika oznaczał, że któryś kolor z podanych nie występuje<br>
Posiadając tak okrojone informacje trzeba odgadnąć wzór, w jak najmniejszej ilości podejść. Domyślnie koraliki z odpowiedzią ustawia się w kolejności [czarny > biały > puste], jednak dla ułatwienia można je układać względem odpowiednich kolorów, do których się odwołują.</p>
<br>

<h2>Trochę o samym programie</h2>
<p>Projekt powstał w języku obiektowym java, korzystając z domyślnego framework'a JavaSwing. Ostatecznie został również utworzony plik Mastermind.jar ułatwiający uruchamianie programu. (Jeżeli wsytępują z nim problemy niżej postaram się pomóc) Cały program jest dość szczegółowo skomentowany, wewnątrz plików źródłowych, więc nie będę tutaj go opisywał. Zastosowałem strukturę opartą na paczkach, dla zwiększenia czytelności oraz bezpieczeństwa. Zapewne można było zrobić to inaczej, jednak po wcześniejszych próbach i napotkanych problemach na tamtą chwilę wydawał mi się to najlepszy sposób.</p>
<br>

<h2>Co dalej?</h2>
<p>Jeżeli ktoś to czyta, to dzień dobry :D. Zachęcam do zagrania, może nawet przejrzenia kodu. W przypadku jakiś uwag, problemów, lub pomysłów można pisać. (Tak się nie stanie) Następnym projektem raczej będzie generator i solver sudoku, ale to już raczej w innym języku. DOBRANOC</p>
<br>

<h2>Problem z Mastermind.jar</h2>
<p>Jeżeli występują problemy z plikiem .jar można sprawdzić następujące rzeczy:<br>
1. Czy na urządzeniu jest zainstalowana maszyna javy, żeby sprawdzić w cmd należy wpisać polecenie <b>java -version</b> powinna się wyświetlić inforamcja o wersji, jeżeli wyskakuje błąd -> youtube<br>
2. Można utworzyć od zera plik .jar. W tym celu należy posiadać JDK i wykonać następujące korki:<br>
-> otworzyć folder z projektem<br>
-> usunąć istniejący plik Mastermin.jar<br>
-> włączyć cmd w lokalizacji projektu<br>
-> wpisać polecenie <b>jar cvf Mastermind.jar source</b>, powinien się utworzyć nowy plik Mastermind.jar<br>
-> korzystając z WinRAR'a otworzyć Mastermind.jar > META-INF > MANIFEST.MF<br>
-> dopisać w pliku na dole <b>Main-Class: source.Main</b><br>
-> zapisać zmiany<br>
-> uruchomić plik Mastermind.jar, klikając dwukrotnie lub wpisujące polecenie <b>java -jar .\Mastermind.jar</b><br>
3. It works on my machine tho<br></p>
