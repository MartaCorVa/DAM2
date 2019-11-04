Exercicis streams
Instruccions

    Crea un projecte anomenat SPADDTema1.

    Crea un paquet anomenat cat.paucasesnovescifp.spadd

    Crea una classe amb un main a dins aquest paquet anomenada ProvesStreams.

    Crea un altre paquet anomenat cat.paucasesnovescifp.spadd.eines dins del 
	qual crearàs totes les classes a no ser que es digui el contrari.

    Descarrega de l'aula virtual els fitxers amb l'Himne dels pirates de Mar i Cel
	i el Tirant lo Blanc.

    Els exercicis o apartats marcats amb un asteriscs són opcionals. Els podeu
	fer si acabau els altres abans d'hora.

Exercicis

    Crea una classe d’utilitat (abstracta i amb tots els mètodes de classe) anomenada 
	EinesByteStream.

        A la classe ProvesStreams crea un mètode anomenat provesByte des d'on cridis
		tots els mètodes que programaràs als exercicis següents. Per l'exercici 5, 
		utilitza una imatge o un pdf o zip que tenguis al disc dur. La còpia ha de
		quedar idèntica a l'original.

        escriuByte(String desti, byte[] dades) Guarda al fitxer destí el text contingut
		dins dades. Prova'l creant un array de bytes i també passant-li els bytes d'un
		String ("Hola".getBytes()).

        mostraBytes(String origen) Rep com a paràmetre un String amb la ruta d'un fitxer.
		Llegeix el fitxer byte a byte i el mostra per consola. Prova'l amb els dos fitxers
		creats al punt anterior.

        * tornaBytes(String origen) Rep com a paràmetre un String amb la ruta d'un fitxer.
		Llegeix el fitxer byte a byte i torna un array amb aquest bytes, de manera que
		l'aplicació pugui tractar-los de la manera més adequada. Suggerència: Posa'ls 
		dins d'un ArrayList<Byte> i després passa el seu contingut a un byte[].

        copiaBytes(String origen, String desti) Copia dins el fitxer destí el contingut
		del fitxer origen. Prova-ho amb una imatge o un zip que tenguis a l'ordinador.

        Nota: Fes qualque exercici amb el bloc finally i qualque un amb el try with
		resources.

    Crea una altra classe d'utilitat anomenada EinesCharacterStream amb els mètodes

        mostraCharacters(String origen). Rep com a paràmetre un String amb la ruta del
		fitxer Himne dels pirates de Mar i Cel . Llegeix el fitxer caràcter a caràcter
		i el mostra per consola.

        escriuCharacters(String desti, String dades) Guarda al fitxer destí el text 
		contingut dins dades.

        copiaCharacters(String origen, String desti). Copia dins el fitxer destí el 
		contingut del fitxer origen.

        A la classe ProvesStreams crea un mètode provesCharacterStream que cridi 
		els mètodes creats anteriorment. Utilitza l'Himne dels pirates.

        * Cronometra el temps que tarda en llegir un fitxer llarg.

            Copia la classe Cronometre de l'aula virtual al paquet 
			cat.paucasesnovescifp.spadd.auxiliar.

            Copia el mètode mostraCharacters amb el nom inutil. Lleva-li la sortida 
			per consola.

            Utilitza la classe Cronometre per a mostrar per pantalla el temps
			que tarda el mètode inutil per llegir el fitxer del Tirant lo Blanc.

    Crea una altra classe d'utlitat EinesBufferedStream amb els mètodes

        mostraLine. Rep com a paràmetre un String amb la ruta del fitxer amb el text 
		amb accents. Llegeix el fitxer línia a línia, el mostra per consola i torna
		un array amb les línies que ha llegit.

        escriuLine(String desti, String[] dades) Guarda al fitxer destí el text
		contingut dins l'array de cadenes dades. Al fitxer s'ha de veure cada string en
		una línia(out.newLine());

        copiaLine(String origen, String desti) . Copia dins el fitxer destí el contingut
		del fitxer origen.

        A la classe ProvesStreams crea un mètode provesBufferedStream que cridi els
		mètodes creats anteriorment. Utilitza la versió adequada de l'Himne dels pirates.

        *A la classe EinesBufferedStream crea un mètode inutil que llegeixi les línies
		del fitxer Tirant lo Blanc sense mostrar-les per pantalla ni tornar-les dins cap 
		array..

        * Utilitza la classe Cronometre per a mostrar per pantalla el temps que tarda 
		el mètode inutil en executar-se. Compara el resultat amb el de llegir el mateix 
		fitxer caràcter a caràcter.

    Crea una altra classe EinesDataStream amb els mètodes estàtics:

        guardaArray(String desti, double[] dades) Escriu al fitxer desti la longitud 
		de l'array i després un a un tots els elements de l'array.

        double[] recuperaArray(String origen) Llegeix les dades que s'han escrit al fitxer
		origen i torna un array amb les dades que ha llegit.

        A la classe ProvesStreams crea un mètode provesDataStream que cridi els mètodes
		creats anteriorment. Contestau amb un println:Que passa si no les llegiu en el
		mateix ordre que s'han escrit?

    Ens queda fer una última prova amb ObjectStream's. Per això:

        Crea al paquet cat.paucasesnovescifp.spadd.streams.auxiliar una classe Dades amb 
		un atribut numeric de tipus int i un alfanumeric de tipus String. Afegeixi-li un
		constructor amb els dos paràmetres, els getters i els setters. Genera 
		automàticament l'equals i el hashCode, i el toString.

        Fes el que s'hagi de fer per que els objectes de la classe Dades es puguin 
		enviar a un stream.

        Crea una última classe d'utilitat EinesObjectStream amb els següents mètodes 
		estàtics:

            escriuObjecte. Rep com a paràmetre el fitxer destí on es guardarà l'objecte, i 
			qualsevol objecte que es pugui enviar a un Stream.

            llegeixObjecte. Rep com a paràmetre el fitxer origen i torna un objecte que
			haurà llegit d'aquest fitxer.

            A la classe ProvesStreams afegeix el mètode provesObjecteSimple. Dins crea un 
			objecte de la classe Dades i utilitza els mètodes anteriors per a guardar-lo a
			un fitxer i recuperar-lo. Mostra per pantalla l'objecte que has llegit i el
			resultat d'equals comparant l'objecte que has escrit i el que has llegit.

        * Crea una nova classe DadesComplexes al paquet auxiliar. Tendrà com a atributs un 
		String identificador i un objecte dades de la classe Dades. Afegeixi-li un 
		constructor amb els dos paràmetres, els getters i els setters. 
		Genera automàticament l'equals i el hashCode i el toString.

            A la classe ProvesStreams afegeix el mètode provesObjecteComplexe. Dins crea un
			objecte de la classe DadesComplexes i utilitza els mètodes de la classe 
			EinesObjectStream per a guardar-lo a un fitxer i recuperar-lo. Mostra per 
			pantalla l'objecte que has llegit i el resultat de equals comparant l'objecte 
			que has escrit i el que has llegit.

            Afegeix ara el mètode provesObjectLlista. Dins aquest mètode crea un 
			ArrayList<Dades> i utilitzau un for per a guardar-hi 10 objectes amb el camp
			numèric=index i el camp alfanumeric=”Som l'objecte “+index, on index és la
			variable del for. Passa la llista al mètode escriuObject. Utilitza el mètode 
			llegeixObject per a recuperar la llista dins d'una altra variable. Comprova per
			pantalla que la llista original i la llegida tenen la mateixa longitud.
			Mostra-les per pantalla, mostrant a la mateixa línia l'objecte original i el 
			llegit.

            Crea finalment el mètode provesMantenirReferencies.

                Dins aquest mètode crea un ArrayList<Dades>.

                Crea un objecte original de la classe Dades. Afegeix-lo dues vegades a la
				llista.

                Canviau el valor del camp numeric de l'objecte i escriviu la llista
				sencera per pantalla. Ha d'haver canviat als dos objectes que apareixen.

                Guarda la llista a un fitxer. Recupera-la i assigna-la a la variable 
				recuperada. Mostra el contingut d'aquesta llista per pantalla. Ha de ser
				el mateix que ha escrit abans.

                S'hauran mantingut les referències? Canvia el camp numèric al primer
				element de la llista. Torna mostrar la llista per pantalla. S'han
				mantingut les referències?