class Publicacion():

    # Constructor
    def __init__(self, referencia, titulo):
        self.referencia = referencia
        self.titulo = titulo

    # Setters
    def set_referencia(self, referencia):
        self.referencia = referencia

    def set_titulo(self, titulo):
        self.titulo = titulo

    # Getters
    def get_referencia(self):
        return self.referencia

    def get_titulo(self):
        return self.titulo

    # Visualizar los datos
    def visualizar(self):
        return "Referencia: " + self.referencia + "Titulo: " + self.titulo

    def __str__(self):
        return "Referencia: " + self.referencia

    # Equals
    def __eq__(self, other):
        print "Publicacion __eq__ %r == %r ?" % (self, other)
        return self.value == other