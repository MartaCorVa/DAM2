# listas
# son los arrays de Python
# se define con []

milista = [1, 2, 3]
milista2 = ["hola", 1, 2.3, [0, 0, 0], 'adios']

print(milista)
print(milista2)

# indexado
print(milista[0])
print(milista[-1])
print(milista[2:])
print(milista[:3])

milista[0] = "prueba"
print(milista)

# metodos de las listas
milista.append("nuevo")
print(milista)

milista3 = [3, 5, 6, 1, 4, 2]
milista3.sort()
print(milista3)

a = milista3.pop()
print(a)
print(milista3)

milista3.reverse()
print(milista3)

milista4 = [1, 2, [3, 4]]
print(milista4[2][0])

# matrices
matriz = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(matriz[1][1])

primera_columna = []

for col in matriz:
    primera_columna.append(col[0])
print (primera_columna)

primera_columna2 = [col[0] for col in matriz]
print(primera_columna2)

lista = [4,2,6,1]
lista.insert(0,8)

# ver la lista ordenada
print(sorted(lista))
# lista al reves
print(list(reversed(lista)))
# ordena y devuelve resultado inverso
print(sorted(lista, reverse= True))
#
print(",".join(str(col[0]) for col in matriz))
print([col[0] for col in matriz])