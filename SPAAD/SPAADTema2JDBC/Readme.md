Exercicis JDBC
Instruccions

    Crea un projecte anomenat SPADDTema2.

    Crea un paquet anomenat cat.iespaucasesnoves.spadd.jdbc.

    Crea la classe ProvesJDBC amb main al paquet cat.iespaucasesnoves.spadd.jdbc. Serà la única classe que pugui interactuar amb l'usuari (pantalla, teclat, ..)

    Crea els paquets cat.iespaucasesnoves.spadd.jdbc.baseDades, cat.iespaucasesnoves.spadd.jdbc.auxiliars i cat.iespaucasesnoves.spadd.jdbc.dades.

    Utilitzau la base de dades de la biblioteca per fer els exercicis.

    Prohibit modificar la definició de la base de dades, per exemple afegint cascades.

Exercicis

    Al paquet auxiliars crea una excepció, JDBCException, amb el constructor buid i un altre amb un paràmetre per el missatge.

    Al paquet baseDades crea la clase BaseDades amb un atribut String per a la url de la connexió i un altre de tipus Properties per a les propietats.

        Crea un constructor amb paràmetres per a les dues dades, els getters i els setters.

        Ha de ser impossible assignar als atributs com a url un null o una cadena buida i com a propietats un null o un objecte sense cap propietat.

        Aquesta classe no pot mostrar res per pantalla, ni tan sols les excepcions.

    A la classe ProvesJDBC crea un objecte de la classe BaseDades configurat de manera que es pugui connectar a la biblioteca.

    Crea un mètode a la classe BaseDades que torni totes les llengües que hi ha a la base de dades. Ho pot fer com a una llista de String.

    A la classe ProvesJDBC mostra les llengües que torna el mètode anterior.

    Crea un mètode a la classe BaseDades que rebi com a paràmetre el valor d'una llengua i torni els títols de tots els llibres (una llista d'String) que contenguin aquest valor com a clau forana. Prova'l desde ProvesJDBC.

    Repeteix l'exercici anterior, però ara utilitzant un PreparedStatement.

    Crea les classes:

        Al paquet dades dos POJOS per les taules Nacionalitat i Autor.

            Han de tenir un constructor amb paràmetres per a tots els atributs i els getters.

            El nom de la nacionalitat no pot ser null o una cadena només de blancs o buida.

            Autor ha de tenir atributs per els camps de la taula ID_AUT, NOM_AUT que no poden ser null ni buids, i FK_NACIONALITAT que si pot ser nul.

    A la classe BaseDades crea els mètodes:

        getNacionalitats() torna un objecte ArrayList<Nacionalitat> amb les files de la taula.

        getAutor (Clau primaria Autor) torna un objecte Autor amb les dades de la fila de la taula amb aquesta clau primaria.

        getAutors(Nacionalitat nacionalitat) torna un ArrayList<Autor> amb les files de la taula Autors que tenen com a clau forana la clau primària de Nacionalitats.

        A la classe ProvesJDBC prova els mètodes anteriors:

            Mostra per pantalla la informació de totes les nacionalitats de la base de dades.

            Mostra per pantalla la fila Autor amb una certa clau primària.

            Mostra per pantalla els autors associats a una determinada nacionalitat.

    Crea a la classe BaseDades un mètode anomenat insereixNacionalitatAutors() que rebi com a paràmetre una nacionalitat i una llista d'autors d'aquesta nacionalitat. Els ha d'inserir a la base de dades.

    Comprova que la base de dades s'ha actualitzat correctament, pots utilitzar els mètodes fets anteriorment per comprovar-ho.

    Crea el mètode esborraNacionalitat() que donada una nacionalitat com a paràmetre l'esborri de la base de dades, juntament amb tots els autors d'aquesta nacionalitat.

    Crea el mètode insereixNacionalitatAutorsTransaccio() que rebi com a paràmetre una nacionalitat i una llista d'autors d'aquesta nacionalitat. Els ha d'inserir a la base de dades utilitzant una transacció. Captura l'SQLException i si hi ha hagut un error fes un rollback.

    Provoca una errada al mètode anterior insertant una fila a la taula Autors amb una clau forana inexistent. Comprova que la fila insertada a la taula Nacionalitats no existeix.

    * Ens adonam que a la base de dades tenim una llengua mal escrita. Com que és clau primària i té registres associats, no la podem esborrar directament. Per arreglar-ho, dins d'una transacció farem el següent:

        Insereix una llengua amb les dades corregides.

        Actualitza tots els llibres que tenen com a clau forana la que està mal escrita, de manera que ara tenguin la correcta.

        Esborra la llengua mal escrita.

    * Programa un miniWorkbench o miniSqldeveloper. Dissenya un JFrame amb un textarea per entrar una consulta Select, un botó per executar-la i un altre textarea per mostrar el resultats. Es pot connectar automàticament a la base de dades. Utilitza ResultSet.getMetadata().getColumnCount() per saber quantes columnes té el resultset.
    NOTA: Pots tractar totes les dades recuperades com si fossin cadenes.

    * Modifica el miniWorkbench de forma que es pugui canviar la connexió de base de dades. Pots fer un menú. L'opció connectar ha d'obrir un diàleg que demani totes les dades necessàries per a construir la url de connexió. Ha d'aparèixer també l'opció desconnectar. Els textarea i botons de la pantalla de consulta només han d'estar actius si hi ha una connexió activa. Inicialment han d'estar desactivats i si es tanca la desconnexió també.

    * Modifica el miniWorkbench de manera que es puguin fer inserts, updates i deletes a més dels select.
