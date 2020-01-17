# Control de flujo
# operadores de comparacion
1<2 # menor
2>1 # mayor
1<=2 # menor o igual
2>=1 # mayor o igual

1==1 # true
1=='1' # false

1 == True # true
0 == False # false

'hola' != 'adios' #true

# operadores logicos
# AND
(1<2) and (3>4)

# OR
(1>2) or (3>4)

# operadores logicos multiples
((1<2) and (3>4)) or (3>4)

# if/else
if (1<2):
    print('dentro del primer if')
else:
    print('dentro del else')

if not(1 < 2):
   print('dentro del primer if')
else:
   print('dentro del else')

# if/elseif
if not(1 < 2):
   print('dentro del primer if')
elif (3==3):
   print('dentro del else')

# bucle for
secuencia = [1,2,3,4,5]

for i in secuencia:
    print(i)

print()

for i in range(1,6):
    print(i)

dicc = {'key1':1,'key2':2,'key3':3}
for i in dicc:
    print(i)

for i in dicc.values():
    print(i)

listatuplas = [(1,2),(3,4),(5,6)]
for i in listatuplas:
    print(i)

for t1,t2 in listatuplas:
    print(t1)
    print(t2)

for t1,t2 in listatuplas:
    print(t2)
    print(t1)

# bucles while
ii = 1

while (ii<5):
    print(ii)
    ii += 1

# for
x = [1,2,3,4]
resultado = []
for i in x:
    resultado.append(i+1)
print resultado

resultado = [i+1 for i in x] # mas rapido
print resultado