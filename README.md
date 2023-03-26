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