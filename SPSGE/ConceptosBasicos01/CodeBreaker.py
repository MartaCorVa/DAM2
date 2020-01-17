###############################
############ JUEGO ############
##### --- CODEBREAKER --- #####
## --No--Cerca--Acertaste--  ##
###############################

# El juego funciona de la siguiente manera:
# 1. El ordenador "pensara" un numero de 3 digitos no repetidos
# 2. Tu adivinaras un número de 3 digitos
# 3. El ordenador devolverá pistas. Las posibles pistas serán:

#   Cerca: Has adivinado el numero correcto pero en la posición erronea
#   Acertaste: Has acertado el numero correcto en la posicion correcta
#   No: No has acertado ni el numero ni la posicion correcta

# 4. Basandole en las pistas, iras adivinando numeros hasta que rompas el codigo con
# la combinacion perfecta

# Necesitaras investigar un poco para realizar el juego.
# No obstante, aqui hay algunas pistas:

# Intenta averiguar para que sirve este pedazo de codigo y como puede servirte en el juego:
import random
digits = list(range(10))
random.shuffle(digits)
print(digits[:3])

# Otra pista:
guess = input("¿Cual es tu suposicion? ")
print(guess)

# Piensa en como compararias el valor que obtines del input con el numero aleatorio,
# ¿qué formato deberia tener? ¿Ves alguna secuencia?
