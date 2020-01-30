# AMBITO #
# Python sigue la regla LEGB:
# L - LOCAL
# E - ENCLOSING FUNCTION LOCALS
# G - GLOBAL
# B - BUILT-IN

# x = 25
# def prueba():
#     x = 50
#     return x
#
# print prueba()

# nombre = "Esto es una variable global"
#
# def saludo():
#     nombre = "Belen"
#
#     def hola():
#         print("hola " + nombre)
#
#     hola()
#
# saludo()
# print nombre

x = 50
def prueba():
    global x
    x = 1000
    return x

print x
print prueba()
print x


