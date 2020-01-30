class Libro():
    
    def __init__(self,titulo,autor,paginas):
        self.titulo = titulo
        self.autor = autor
        self.paginas = paginas
        self.cocacola = 1

    def __str__(self):
        return self.titulo + " " + self.autor + " " + str(self.paginas)

    def __len__(self):
        return self.paginas

l = Libro("Python","Belen",200)

print l.cocacola

print len(l)

listas = [1,2,3]
print listas