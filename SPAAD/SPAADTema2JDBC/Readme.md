 Instruccions

    1 Crea un projecte anomenat SPADDTema2.

    2 Crea un paquet anomenat cat.iespaucasesnoves.spadd.jdbc.

    3 Crea la classe ProvesJDBC amb main al paquet cat.iespaucasesnoves.spadd.jdbc. Serà la única classe que pugui interactuar amb l'usuari (pantalla, teclat, ..)

    4 Crea els paquets cat.iespaucasesnoves.spadd.jdbc.baseDades, cat.iespaucasesnoves.spadd.jdbc.auxiliars i cat.iespaucasesnoves.spadd.jdbc.dades.

    5 Utilitzau la base de dades de la biblioteca per fer els exercicis.

    6 Prohibit modificar la definició de la base de dades, per exemple afegint cascades.

Exercicis

    1 Al paquet auxiliars crea una excepció, JDBCException, amb el constructor buid i un altre amb un paràmetre per el missatge.

    2 Al paquet baseDades crea la clase BaseDades amb un atribut String per a la url de la connexió i un altre de tipus  Properties per a les propietats.

        2.1 Crea un constructor amb paràmetres per a les dues dades, els getters i els setters.

        2.2 Ha de ser impossible assignar als atributs com a url un null o una cadena buida i com a propietats un null o un objecte sense cap propietat.

        2.3 Aquesta classe no pot mostrar res per pantalla, ni tan sols les excepcions.

    3 A la classe ProvesJDBC crea un objecte de la classe BaseDades configurat de manera que es pugui connectar a la biblioteca.

    4 Crea un mètode a la classe BaseDades que torni totes les llengües que hi ha a la base de dades. Ho pot fer com a una llista de String.

    5 A la classe ProvesJDBC mostra les llengües que torna el mètode anterior.