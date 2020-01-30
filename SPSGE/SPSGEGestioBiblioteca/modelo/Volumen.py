from modelo.Obra import Obra


class Volumen(Obra):

    # Constructor
    def __init__(self, nro):
        Obra.__init__(self)
        self.nro = nro

    # Setters
    def set_nro(self, nro):
        self.nro = nro

    # Getters
    def get_nro(self):
        return self.nro

    # Visualizar los datos
    def visualizar(self):
        return "Nro: " + self.nro