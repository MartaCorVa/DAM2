###############################
############ JUEGO ############
##### --- CODEBREAKER --- #####
## --No--Cerca--Acertaste--  ##
###############################

# El juego funciona de la siguiente manera:
# 1. El ordenador "pensara" un numero de 3 digitos no repetidos
# 2. Tu adivinaras un numero de 3 digitos
# 3. El ordenador devolvera pistas. Las posibles pistas seran:

#   Cerca: Has adivinado el numero correcto pero en la posicion erronea
#   Acertaste: Has acertado el numero correcto en la posicion correcta
#   No: No has acertado ni el numero ni la posicion correcta

# 4. Basandole en las pistas, iras adivinando numeros hasta que rompas el codigo con
# la combinacion perfecta

# Necesitaras investigar un poco para realizar el juego.
# No obstante, aqui hay algunas pistas:

# Intenta averiguar para que sirve este pedazo de codigo y como puede servirte en el juego:



import random
# se generan los numeros
lista = list(range(10))
random.shuffle(lista)
digits = lista[:3]
respuesta = [0,0,0]
contador = 0
print digits

while digits != respuesta:
    respuesta = raw_input("Cual es tu suposicion? ")
    respuesta = [int(respuesta[0]),int(respuesta[1]),int(respuesta[2])]

    # todos correctos
    if (digits[0] == respuesta[0] and digits[1] == respuesta[1] and digits[2] == respuesta[2]):
        print "Todos los numeros son correctos y en la posicion correcta"
    # ultimo
    elif digits[0] == respuesta[0] and digits[1] == respuesta[1] and digits[2] != respuesta[2]:
        print "Has acertado dos numeros en la posicion correcta"
    # segundo
    elif digits[0] == respuesta[0] and digits[1] != respuesta[1] and digits[2] == respuesta[2]:
        print "Has acertado dos numeros en la posicion correcta"
    # primero
    elif digits[0] != respuesta[0] and digits[1] == respuesta[1] and digits[2] == respuesta[2]:
        print "Has acertado dos numeros en la posicion correcta"
    # primero segundo
    elif digits[0] != respuesta[0] and digits[1] != respuesta[1] and digits[2] == respuesta[2]:
        print "Has acertado un numero en la posicion correcta"
    # primero tercero
    elif digits[0] != respuesta[0] and digits[1] == respuesta[1] and digits[2] != respuesta[2]:
        print "Has acertado un numero en la posicion correcta"
    # segundo tercero
    elif digits[0] == respuesta[0] and digits[1] != respuesta[1] and digits[2] != respuesta[2]:
        print "Has acertado un numero en la posicion correcta"
    # numero correcto en posicion incorrecta
    else:
        for x in range(0,len(digits)):
            for i in range(0,len(respuesta)):
                if digits[x] == respuesta[i]:
                    contador += 1
        print "Tienes " + str(contador) + " numeros correctos, pero en una posicion incorrecta"
        contador = 0

        # otra opcion
        for ind,elem in enumerate(digits):
            if digits[ind] == respuesta[elem]:
                contador += 1
        print "Tienes " + str(contador) + " numeros correctos, pero en una posicion incorrecta"
        contador = 0