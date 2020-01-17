"""
Son la version de Python de una matriz asociativa (hashtable)
son un sistema de pares de valores clave
se define con {}
"""

diccionario = {"clave1":"valor1", "clave2":"valor2", "clave3":{"dentro":[1, 2, 3]}}
print(diccionario)
print(diccionario["clave3"]["dentro"])
print(diccionario["clave3"]["dentro"][0])
print(diccionario["clave2"].upper())
print(sorted(diccionario["clave3"]["dentro"], reverse = True))
print(list(reversed(diccionario["clave3"]["dentro"])))

plato = {"desayuno":"cafe con leche", "cena":"sopa"}
print(plato)
plato["comida"] = "pasta"
print(plato)
plato["desayuno"] = "croisant"
print(plato)

# No se pueden agregar metodos a los diccionarios