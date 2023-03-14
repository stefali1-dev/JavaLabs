# JavaLabs

### Lab 1

* Am facut partea obligatorie si tema, cum scrie in cerinta


### Lab 2:
* Am construit clasele specificate cu atributele specificate si metodele specificate
* La inceputul claselor Location si Road am definit enum-urile cu diferite tipuri
* Am creat niste exemple

### Lab 3 - compulsory part :
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

### Lab 4 - compulsory part :
* Am construit clasele Main, Student si Project
* clasele Student si Project au atributul name, settere, gettere si override la functia compareTo care compara in ordine alfabetica in functie de nume
* In Main, prin stream-uri, am facut un array students cu 3 obiecte Student si un array projects cu 3 obiecte Project, am facut un LinkedList studentList ce contine Studenti din array-ul students si l-am sortat cu Collections.sort() pentru afisare, am facut un TreeSet projectSet cu Projects din array-ul projects dar nu a trebuit sa-l sortez separat pentru afisare deoarece e sortat by default la fiecare adaugare a unui element
* La final am afisat elementele din studentList si din projectSet      
