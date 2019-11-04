Practica 4 (entrega opcional)

Crear una sola classe amb 3 mètodes:


    Mètode 1: El mètode et demana dos valors per pantalla, realitza la suma i imprimeix el resultat per pantalla.
    Mètode 2: El mètode rep per paràmetre un String i l'imprimeix per pantalla.
    Mètode 3: Parteix de dos valors predeterminats i calcula la 5ena iteració de la successió de fibonacci. Retorna el valor "int". (Return resultat)

Seguidament, crear un procés pare, que mostrarà un menú per pantalla amb 4 opcions:

    Executa mètode 1
    Executa mètode 2
    Executa mètode 3
    Sortir

ERROR NO ES POT FER: Executar mètode 1 implica cridar un un procés (fill). Aquest procés fill t'ha de demanar per pantalla dos valors, calcular la suma i mostrar per pantalla el resultat. Per tant, no te cap mena d'interacció amb el pare.

Executa mètode 2 implica interacció amb el pare. En concret, el pare demanarà una frase per pantalla, quan l'usuari l'hagui introduida, el pare enviarà aquesta frase al fill (interconnectant els pipes out del pare amb in del fill mitjançant proces_fill.getOutputStream).


Executa mètode 3 implica interacció amb el pare. En concret, el pare executa el fill, aquest, parteix de dos valors predeterminats i realitza un càlcul. Quan el procés fill finalitzi aquest càlcul, l'envia al pare. El procés pare, rep del procés fill el resultat, mitjançant proces_fill.getInputStream. Finalment el procés pare imprimirà per pantalla el resultat.


MOLT IMPORTANT!!!

Els missatges des del pare començaràn per:

EL PARE DIU:

Els missatges des del fill diran:

EL FILL 1/2/3 DIU:


(1/2/3) Depenent de si es el mètode1, mètode2 o mètode3.