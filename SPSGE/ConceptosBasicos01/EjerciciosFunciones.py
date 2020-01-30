###################################
####  EJERCICIOS DE FUNCIONES #####
###################################


#
# Completa los problemas mostradas a continuacion escribiendo funciones! Se trata de dividir cada problema
#en pasos mas pequenyos para poder solucionarlos
#
######################
## -- PROBLEMA 1 -- ##
######################

# Dada una lista de enteros, devuelve True si la secuencia de numeros 1, 2, 3
# aparece en la lista de alguna manera.

# Por ejemplo:

# arrayCheck([1, 1, 2, 3, 1]) -> True
# arrayCheck([1, 1, 2, 4, 1]) -> False
# arrayCheck([1, 1, 2, 1, 2, 3]) -> True

def arrayCheck(nums):
    list_num = [1, 2, 3]
    if len(nums) < 3:
        for i in nums:
            if list_num == nums[i:i + 3]:
                return True
            return False
        return False


######################
## -- PROBLEMA 2 -- ##
######################

# Dada una cadena de caracteres, devuelve una nueva cadena que contenga
# Given a string, return a new string made of every other character starting
# with the first, so "Hello" yields "Hlo".

# For example:

# stringBits('Hello') -> 'Hlo'
# stringBits('Hi') -> 'H'
# stringBits('Heeololeo') -> 'Hello'

def stringBits(str):
    result = ""
    for i in range(len(str)):
        if i % 2 == 0:
            result = result + str[i]
        return result


######################
## -- PROBLEMA 3 -- ##
######################

# Dadas dos cadenas de caracteres, devuelve True si alguna de las cadenas aparece al final
# de la otra cadena, ignorando las mayusculas y las minusculas (en otras palabras, no debe ser
# "case sensitive")
#
# Nota: s.lower() devuelve la version en minusculas de una cadena de caracteres
#
# Ejemplos:
#
# end_other('Hiabc', 'abc') -> True
# end_other('AbC', 'HiaBc') -> True
# end_other('abc', 'abXabc') -> True


def end_other(a, b):
    a = a.lower()
    b = b.lower()

    return (a.endswith(b) and b.endswith(b))

######################
## -- PROBLEMA 4 -- ##
######################

# Dada una cadena de caractes, devuelve una cadena en la que cada caracter de
# la cadena original se duplique.
#
# Ejemplos:
#
# doubleChar('The') -> 'TThhee'
# doubleChar('AAbb') -> 'AAAAbbbb'
# doubleChar('Hi-There') -> 'HHii--TThheerree'

def doubleChar(str):
    result = ""
    for c in str:
        result += c*2
    return result


######################
## -- PROBLEMA 5 -- ##
######################

# Lee este enunciado con atencion!

# Dados 3 valores enteros, a,b ,c, devolver su suma. Sin embargo, si cualquier valor
# es un  numero del 13 al 19 incluidos ambos, entonces este valor cuenta como 0, excepto el 15
# y el 16  que no se tienen en cuenta en este rango. Escribe una funcion separada "def fix_teen(n):"
# que coja como parametros los valores del 13 al 19 y los devuelva como se ha indicado.
# De esta manera, evitaremos tener que comprobar los valores 3 veces.
# Define la nueva funcion al mismo nivel de indentacion
#
# Ejemplos:
#
# no_teen_sum(1, 2, 3) -> 6
# no_teen_sum(2, 13, 1) -> 3
# no_teen_sum(2, 1, 14) -> 3

def no_teen_sum(a, b, c):
    return fix_teen(a) + fix_teen(b) + fix_teen(c)

def fix_teen(n):
  if n in [13,14,17,18,19]:
      return 0

######################
## -- PROBLEMA 6 -- ##
######################

# Devuelve el numero de numeros pares que se han introducido a la funcion.
#
# Ejemplos:
#
# count_evens([2, 1, 2, 3, 4]) -> 3
# count_evens([2, 2, 0]) -> 3
# count_evens([1, 3, 5]) -> 0

def count_evens(nums):
  count = 0
  for e in nums:
      if e % 2 == 0:
          count += 1
  return count