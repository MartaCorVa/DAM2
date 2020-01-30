# HERENCIA #
class Animal():
    def __init__(self):
        print "Animal Creado"

    def quiensoy(self):
        print "Soy un animal"

    def comer(self):
        print "Comiendo"

class Perro(Animal):
    def __init__(self):
        Animal.__init__(self)
        print "Perro creado"

    def ladrar(self):
        print "Guau Guau"

p = Perro()
p.comer()
p.quiensoy()

print (type(p).__base__)
p.ladrar()
