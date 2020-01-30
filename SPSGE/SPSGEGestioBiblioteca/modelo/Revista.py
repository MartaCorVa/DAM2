from modelo.Publicacion import Publicacion


class Revista(Publicacion):

    # Constructor
    def __init__(self, anyo, nro):
        Publicacion.__init__(self)
        self.anyo = anyo
        self.nro = nro

    # Setters
    def set_anyo(self, anyo):
        self.anyo = anyo

    def set_nro(self, nro):
        self.nro = nro

    # Getters
    def get_anyo(self):
        return self.anyo

    def get_nro(self):
        return self.nro

    # Visualizar los datos
    def visualizar(self):
        return "Anyo: " + self.anyo + "Nro: " + self.nro