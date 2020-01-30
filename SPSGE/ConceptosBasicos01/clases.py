# CLASES #
# Por convencion las clases se nombran con la primera
# letra en mayuscula
# Los metodos se nombran todos en minusculas

# class Perro():
#     especie = "canis"
#     # constructor
#     def __init__(self,raza,nombre):
#         self.raza = raza
#         self.nombre = nombre
#
# x = Perro("Labrador","Perro")
# print x.raza
# print x.nombre

class Circulo():

    pi = 3.1416

    def __init__(self,radio=1):
        self.radio = radio

    def area(self):
        return self.radio *  self.radio * Circulo.pi

    def set_radio(self,radio):
        self.radio = radio


c = Circulo()
print(c.radio)
print c.area()
c.radio = 100
print c.radio
print c.area()
c.set_radio(20)
print c.radio