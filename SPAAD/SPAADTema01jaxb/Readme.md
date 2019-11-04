Exercicis JAXB
Instruccions

    Crea un projecte al teu IDE, amb el nom SPADDjaxb

    Afegeix al projecte els jar que trobaràs al fitxer llibreries.zip

    Crea el package cat.paucasesnovescifp.spadd i una classe amb main dins d'aquest package.

    Crea el package cat.paucasesnovescifp.spadd.model.

    Crea el package cat.paucasesnovescifp.spadd.recursos. Copia a aquest package els fitxers xml que trobaràs a l'aula virtual.

    Crea el package cat.paucasesnovescifp.spadd.controlador. Dins aquest paquet crea una classe d'utilitat anomenada Controller.

    La única classe que pot interactuar amb l'usuari (demanar dades o mostrar res per pantalla) és la que té el main.

Exercicis

    Has de tractar amb JAXB el fitxer que trobareu a l'aula virtual anomenat modul.xml:

        Dins el package cat.paucasesnovescifp.spadd.model crea una classe que ha de poder contenir tota la informació que trobareu al fitxer xml, als elements i als atributs. Programa els getters, els setters, un constructor sense paràmetres, un amb paràmetres per a tots els atributs i el toString.

        Anota la classe de manera que l'API JAXB la pugui omplir amb les dades del fitxer.

        A la classe Controlller crea el mètode llegeixModul. Ha de tenir un paràmetre on passarem la ruta del fitxer i ha de tornar un objecte mòdul amb les dades del fitxer.

        Des del main crida el mètode i mostra per pantalla les dades del mòdul que ha tornat.

        A la classe Controlller crea el mètode escriuModul. Ha de tenir com a paràmetres la ruta on guardarem el fitxer i l'objecte mòdul que hi volem guardar.

        Des del main, crea un mòdul (o reaprofita el que has llegit) i passa'l al mètode de l'exercici anterior. Comprova que es genera el fitxer amb l'xml correcte.

    Repeteix l'exercici 1 (amb tots els subexercicis) amb el fitxer curs.xml. Fixa't que els mòduls són elements descendents directes de curs. Per guardar-los heu de crear un atribut del tipus ArrayList<Modul>. En generar el fitxer xml per un curs t'has d'assegurar que el nom del curs apareix abans que els mòduls.

    Nota: Els atributs que contenen llistes solen tenir el nom en plural i en canvi els elements xml tenen el nom en singular. Com ho podem resoldre? (Posar el nom de la llista en singular no és una resposta vàlida).

    (Opcional) Repeteix l'exercici 1 (amb tots els subexercicis) amb el fitxer cursV2.xml. Fixa't que ara els mòduls apareixen dins d'un element addicional. Copia la classe creada per l'exercici 2 i modifica el necessari per que funcioni amb aquesta nova versió.

    Nota: Has de canviar el nom de la classe i segurament el nom de l'XmlRootElement.

    (Opcional) No seria més eficient crear un sol mètode per llegir qualsevol xml (de les classes mapejades) i un altre per generar l'xml a partir d'un objecte de qualsevol de les classes mapejades? Fes-ho.
