# Set, tuplas y booleans

#set
# Set conjuntos desordenados de elementos unicos
# Se definen sets con {}
miset = {1,1,1,1,2,2,2,3,3,3}
print(miset)
# anyadir valores
s = {1,2,3}
s.add(4)
print(s)
#convertir lista en set
converison = set([1,1,1,1,1,2,2,2,2,3,3,3])
print(converison)

#tuplas
# Tuplas son secuencias inmutables
# se definen las tuplas con ()

t = (1,2,3)
print(t[0])
# Tuplas concatenacion
tt = ("set", 1, True)
print(tt)
print(t+tt)

#boolean
True
False
0
1

print(2<1)