Examen pràctic streams i jaxb

Instruccions

    Crea un nou projecte.

    Pots utilitzar el codi que trobaràs a l'aula virtual. Descomprimeix-lo dins
	la carpeta src del teu projecte. Modifica tot el que necessitis per fer els exercicis.

    Els mètodes han de poder funcionar amb qualsevol conjunt d'arguments.

    La classe Examen és la única que pot interactuar amb l'usuari (pantalla i teclat).

    El control d'errades es farà utilitzant excepcions. El main no ha de propagar
	excepcions.

Lliurament

Heu de lliurar a l'aula virtual el codi font del projecte, la carpeta src. 
En cas de dubte lliurau el projecte complet.
Exercicis

    (4 punts) Heu de fer tot el necessari per poder recuperar les dades que hi ha 
	dins del fitxer 001.xml que trobareu a l'aula virtual. Heu d'utilitzar JAXB.

    Al paquet jaxb crea una classe d'utilitat amb un mètode que rebi com a mínim un
	paràmetre amb la ruta del fitxer i torni un objecte de la classe Film.

    Al main de la classe Examen utilitza aquest mètode passant-li la ruta del 
	fitxer 001.xml i ha de mostrar per pantalla les dades de l'objecte que torna.

    No podeu modificar el fitxer 001.xml. Per corregir utilitzaré el que hi ha
	a l'aula virtual.


    (3 punts) Tenim una altra aplicació, escrita en C, un llenguatge sense
	el concepte d'objectes, amb la qual hem d'intercanviar informació. 
	En concret informació dels objectes Film. Hem d'intercanviar tota la 
	informació de l'objecte excepte la llista d'actors i l'idioma.

    Ho farem utilitzant només tipus de dades primitius i Strings.

    Necessitam una classe d'utilitat amb dos mètodes:

        (1,5 punts) Un que rebi com a paràmetres la ruta del fitxer i un objecte 
		Film i guardi aquest objecte dins del fitxer.

        (1,5 punts) Un altre mètode que rebi com a paràmetre la ruta d'un fitxer 
		i torni l'objecte Film que contengui el fitxer.

Ara que hem recuperat l'objecte Film del fitxer 001.xml podem utilitzar-lo per les proves.
 Si no ho has fet pots crear un objecte Film a ma.

    (3 punts) Tenim una tercera aplicació, en aquest cas Java, amb la qual hem
	d'intercanviar informació. En concret informació dels objectes Film.

    Necessitam dos mètodes, que podeu afegir a la classe de l'exercici anterior:

        (1,5 punts) Un que rebi com a paràmetres la ruta del fitxer i un objecte 
		Film i guardi aquest objecte dins del fitxer.

        (1,5 punts) Un altre mètode que rebi com a paràmetre la ruta d'un fitxer i
		torni l'objecte Film que contengui el fitxer.

    Ara que hem recuperat l'objecte Film del fitxer 001.xml podem utilitzar-lo per 
	les proves. Si no ho has fet pots crear un objecte Film a ma.
