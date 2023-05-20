# JavaLabs

### Lab 1

* Am facut partea obligatorie si tema, cum scrie in cerinta


### Lab 2:
* Am construit clasele specificate cu atributele specificate si metodele specificate
* La inceputul claselor Location si Road am definit enum-urile cu diferite tipuri
* Am creat niste exemple

### Lab 3 - compulsory :
* Am construit clasele Main, Person, Company si interfata Node
* Clasa Person are atributele nume(id unic), vectorul de nume "persons" care contine numele persoanelor cu care are relatie si vectorul de nume "companies" care contine numele companiilor cu care are relatie. De asemenea are constructor, override la functia compareTo, settere si gettere la nume si functii de adaugat persoane sau companii
* Clasa Company are atributele nume(id unic), vectorul de nume "persons" care contine numele persoanelor cu care are relatie. De asemenea are constructor, override la functia compareTo, settere si gettere la nume si functii de adaugat persoane
* Interfata Node are definitia functiei abstracte "getName"
* In Main am creat niste exemple de persoane si companii, si am facut un ArrayList cu ele

### Lab 3 - homework :
* Am construit clasele Main, Person, Company, Designer, Programmer, Network si interfata Node
* Clasa Person are atributele nume(id unic), mapa "relationships" care contine obiecte de tip node cu care persoana are relatii, care pot fi persoane sau companii. De asemenea are constructor, override la functia compareTo, settere si gettere la nume si functie de adaugat obiecte node la mapa "relationships"
* Clasa Company are atributele nume(id unic), vectorul de nume "persons" care contine numele persoanelor cu care are relatie. De asemenea are constructor, override la functia compareTo, settere si gettere la nume si functii de adaugat persoane
* Interfata Node are definitia functiei abstracte "getName"
* Clasa Designer mosteneste Person si are in plus atributul unic "favoriteTool"
* Clasa Programmer mosteneste Person si are in plus atributul unic "favoriteLanguage"
* Clasa Network contine o variabila de tip List cu obiecte de tip Node care pot fi persoane sau companii, o functie de adaugare a unui nod nou in lista si setter si getter
* In Main am creat niste exemple de persoane si companii, si am initializat un Network cu ele

### Lab 4 - compulsory :
* Am construit clasele Main, Student si Project
* clasele Student si Project au atributul name, settere, gettere si override la functia compareTo care compara in ordine alfabetica in functie de nume
* In Main, prin stream-uri, am facut un array students cu 3 obiecte Student si un array projects cu 3 obiecte Project, am facut un LinkedList studentList ce contine Studenti din array-ul students si l-am sortat cu Collections.sort() pentru afisare, am facut un TreeSet projectSet cu Projects din array-ul projects dar nu a trebuit sa-l sortez separat pentru afisare deoarece e sortat by default la fiecare adaugare a unui element
* La final am afisat elementele din studentList si din projectSet      

### Lab 4 - homework :
* Am construit clasele Main, Student, Project si Problem
* clasele Student si Project au atributul name, settere, gettere si override la functia compareTo care compara in ordine alfabetica in functie de nume si override la functia toString
* Clasa problem contine o lista de Students, un set de Projects, constructor, settere si gettere, functie de afisare a studentilor cu numarul de preferinte mai mic decat media si o functie care rezolva problema printr-un algoritm Greedy
* In Main am facut:
* Prin stream-uri, un array students cu 3 obiecte Student si un array projects cu 3 obiecte Project, am facut un LinkedList studentList ce contine Studenti din array-ul students
* 3 TreeSet-uri care corespund exemplului dat si apoi le-am setat ca atribut al obiectelor Student
* Am initializat un obiect Problem si la atributele studentList si projects am adaugat noi obiecte nu nume generate random prin libraria Faker
* La final am apelat functia de rezolvare a Probleme care returneaza un un Set de Pair<Student, Problem>

### Lab 5 - compulsory :
* Am construit clasele Main, Catalog, Document si Operation
* clasele Catalog, Document si Operation au settere, gettere si override la functia toString
* clasa Catalog mai are atributul name si un List cu Documents
* clasa Document mai are atributele name, ID, un map cu tags, si path
* clasa Operation contine un Catalog pe care face operatii de afisare toString, de save, de load si de add a new Document la Lista cu Documente ale catalogului 
* in Main, am creat 2 documente cu diferite atribute si le-am adaugat intr-o lista, apoi am facut Obiectul Operation la care i-am adaugat un catalog gol, dupa am folosit operatia add pentru a adauga cele 2 Documente, apoi am afisat catalogul text prin functia toString, apoi l-am salvat in fisierul catalog.json, apoi am dat load la acel fisier si am afisat in consola continutul

### Lab 5 - homework :
* Am construit interfata Command si clasele MainHomework, Catalog, Document, Operation, AddCommand, ListCommand, LoadCommand, ReportCommand, SaveCommand, ToStringComannd, ViewCommand
* interfata Command contine functia abstracta "execute(Catalog catalog)" care da throw la exceptiile InvalidDataException si InvalidCommandException
* clasele Catalog, Document si Operation au settere, gettere si override la functia toString
* clasa Catalog mai are atributul name si un List cu Documents
* clasa Document mai are atributele name, ID, un map cu tags, path si Url
* clasa Operation contine un Catalog si toate clasele de tip Command
* clasa AddCommand adauga un document la catalogul dat ca atributul functiei execute
* clasa ListCommand afiseaza lista de documente a catalogului
* clasa SaveCommand salveaza catalogul in format .json
* clasa LoadCommand afiseaza catalogul din fisierul gasit in locatia din atributul "path"
* clasa ToStringCommand salveaza intr-un atribut reprezentarea textuala a catalogului
* clasa ViewCommand deschide fisierul documentului, care se gaseste la locatia din atributul "path", cu programul default al sistemului de operare
* clasa ReportCommand genereaza un report HTML cu ajutorul unui template dat ca parametru, si salveaza raportul in path-ul dat ca parametru

* in MainHomework, am creat 2 documente cu diferite atribute si le-am adaugat intr-un catalog cu ajutorul obiectului AddCommand, apoi am testat toate comenzile precizate mai sus

### Lab 6 - compulsory cu JavaFx:
* Am construit clasele MainApplication, Controller, GraphGenerator, Point si fisierul hello-view.fxml
* Clasa MainApplication creaza obiectele FXMLLoader(care da load la hello-view.fxml) si Scene si porneste aplicatia
* hello-view.fxml reprezinta GUI-ul si este exact la fel ca in exemplul de pe site, permitand posibilitatea de a modifica numarul nodurilor, probabilitatea muchiilor, un canvas care afiseaza graful si butoanele de Load Save Reset Exit
* clasa Controller este specificata la atributul fx:controller al tag-ului <Vbox> care este structura principala din aplicatie, astfel rolul ei fiind de a controla elementele din GUI. Clasa contine atribute care linked cu elementele din GUI prin denumirea lor, aparand in atributul fx:id. Clasa contine si functii care initializeaza si updateaza diferite elemente de GUI precum un Spinner, ChoiceBox, Butoane si Canvas.
* clasa Point are doar 2 atribute: x si y, si reprezinta un punct pe Canvas
* clasa GraphGenerator contine un ArrayList de Point0uri. Contructorul populeaza Lista cu noduri in functie de dimensiunea din parametrul size. Clasa mai are o functie care genereaza un graf cu nodurile din Lista, fiecare muchie avand o probabilitate de existenta data de parametrul lineProbability



![Gif Example](https://github.com/stefali1-dev/JavaLabs/blob/main/Lab6/compulsory/lab6_compulsory.gif?raw=true)

### Lab 6 - homework cu JavaFx:
* Am construit clasele MainApplication, Controller, GraphGenerator, Point, Player, clasa enum Color si fisierul hello-view.fxml
* Clasa MainApplication creaza obiectele FXMLLoader(care da load la hello-view.fxml) si Scene si porneste aplicatia
* hello-view.fxml reprezinta GUI-ul si este exact la fel ca in exemplul de pe site, permitand posibilitatea de a modifica numarul nodurilor, probabilitatea muchiilor, un canvas care afiseaza graful si butoanele de Load Save Reset Exit
* clasa Player contine informatii despre player precum nume, culoarea si o structura de date ce reprezinta liniile trasate de el pana in momentul actual
* clasa enum Color contine culorile RED si BLUE
* clasa Controller este specificata la atributul fx:controller al tag-ului <Vbox> care este structura principala din aplicatie, astfel rolul ei fiind de a controla elementele din GUI. Clasa contine atribute care linked cu elementele din GUI prin denumirea lor, aparand in atributul fx:id. Clasa contine si functii care initializeaza si updateaza diferite elemente de GUI precum un Spinner, ChoiceBox, Butoane si Canvas. De asemenea, clasa Controller atribuie functionalitatea butonului "Save" de a salva imaginea de pe canvas ca PNG si salveaza starea obiectelor Player prin object serialization, si butonului "Load" de a relua starea obiectelor Player prin object serialization. De asemenea in functia updateCanvas a clasei am implementat verificarea unui click daca este pe o linie, printr-un mouse listener
* clasa Point are doar 2 atribute: x si y, si reprezinta un punct pe Canvas
* clasa GraphGenerator contine un ArrayList de Point0uri. Contructorul populeaza Lista cu noduri in functie de dimensiunea din parametrul size. Clasa mai are o functie care genereaza un graf cu nodurile din Lista, fiecare muchie avand o probabilitate de existenta data de parametrul lineProbability

### Lab 7 - compulsory:
* Am construit clasele Robot, Supervisor, SharedMemory, MatrixMap si Main
* clasa Robot va reprezenta robotii care exploreaza harta. Va avea un nume si o pozitie curenta pe harta
* clasa Map va reprezenta matricea patrata n x n care reprezinta harta
* clasa SharedMemory va reprezenta memoria partajata care contine token-urile
* clasa Supervisor va reprezenta supraveghetorul care poate porni si intrerupe robotii
* clasa Main va fi punctul de intrare al programului. Va crea harta, memoria partajata, robotii si supervizorul

### Lab 8 - compulsory:
* Am construit clasele Database, DatabaseTest, ArtistDAO si Main si script-ul SQL "sql_script.sql"
* clasa singleton Database contine atribute si metode necesare gestionarii conectarii la baza de date, precum URL, USERNAME, PASSWORD si metode de creare si de oprire a conexiunii
* clasa DatabaseTest contine 3 teste pentru cele 3 metode ale clasei Database si anume GetInstance(), GetConnection() si CloseConnection(). Inainte de fiecare se va initializa singleton-ul, iar dupa fiecare test se va inchide conexiunea. Toate testele au trecut
* clasa DAO ArtistDAO contine metode pentru crearea entry-urilor in tabelul artists, si metode pentru cautarea entry-urilor dupa nume si id
* in Main initializam singleton-ul Database, executam scriptul sql si adaugam 2 entry-uri in tabelul artists initializand de asemenea un obiect ArtistDAO, la final fiind gata sa prindem exceptii legate de comenzile SQL si IO.

### Lab 10 - compulsory:
* Am construit clasele ClientThread, GameClient, GameServer si Main
* In clasa GameServer se asteapta si se executa clienti daca este cazul
* In ClientThread avem override la functia run in care trimitem un mesaj simplu si gestionam exceptiile
* In GameClient se citeste de la tastatura si se tranmite serverului
* In Main se initializeaza clientul

### Lab 11 - compulsory:
* Am construit clasele DemoApplication, Player, PlayerRepository si PlayerController
* Clasa Player contine datele jucatorului(id, nume si scor) si este reprezenta si de un tabel in postgres denumit "players"
* Clasa PlayerRepository reprezenta repository-ul destinat jucatorului, care ne ajuta sa gestionam datele din baza de date
* in clasa PlayerController initializam prin @Autowired PlayerRepository-ul si avem o metoda de Get pentru a obtine toti jucatorii din tabelul "players"
* clasa DemoApplication initializam aplicatia

### Lab 11 - homework:
* clasa GameController contine endpoint-urile aplicatiei si metode precum getPlayers, addPlayer, updatePlayerName, deletePlayer, getGames
* clasele Game si Player contin datele referitoare la un joc sau un jucator, si sunt reprezentate si de un tabel in baza de date
* clasele GameRepository si PlayerRepository mostenesc clasa JpaRepository pentru a gestiona tabelele cu Games si Players
* clasa DemoApplication este folosita pentru a initializa aplicatia
* clasa RestClient serveste drept client care se foloseste si testeaza serviciile serverului, apeland toate endpoint-urile
* clasa SwaggerConfig reprezinta un setup pentru swagger, ce ne permite sa generam o documentatie pentru api-ul nostru