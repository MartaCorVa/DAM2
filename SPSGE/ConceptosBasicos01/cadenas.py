# strings
# se usan para almacenar textos de informacion
# y se indican con comillas simples o dobles

cadena1 = "hola"
cadena2 = 'hola'
cadena3 = "esto es una 'prueba'"
cadena4 = 'esto es una "prueba"'

manzanas = 5
peras = 7
nombre1 = "Maria"
nombre2 = "Juan"

# Imprimir por pantalla utilizando el metodo format de los strings
print("Maria tiene {a} manzanas y Juan tiene {b}".format(a = manzanas, b = peras))

# Imprimir por pantalla utilizando operadores
print("Maria tiene " + str(manzanas) + "manzanas y Juan tiene " + str(peras))

# Indexacion
cadena5 = "prueba"
print(cadena5[0])
print(cadena5[-1])
print(cadena5[2:])
print(cadena5[:3])
print(cadena5[2:3])
print(cadena5[::])
print(cadena5[::2])

# cadena5[2] = "x" -> No se puede hacer porque los strings son inmutables
cadena5 = "adios"
print(cadena5)

# metodos mas utilizados
cadena5 = cadena5.upper()
print(cadena5)
print(cadena5.lower())

cadena6 = "Belen"
print(cadena6.lower())

cadena7 = "esto es una prueba"
print(cadena7.capitalize())

# segmentacion
print(cadena7.split())
print(cadena7.split('e'))