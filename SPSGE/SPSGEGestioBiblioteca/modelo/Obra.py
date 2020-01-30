from modelo.Publicacion import Publicacion


class Obra(Publicacion):

    # Constructor
    def __init__(self, autor, nre_pags):
        Publicacion.__init__(self)
        self.autor = autor
        self.nre_pags = nre_pags

    # Setters
    def set_autor(self, autor):
        self.autor = autor

    def set_nre_pags(self, nre_pags):
        self.nre_pags = nre_pags

    # Getters
    def get_autor(self):
        return self.autor

    def get_nre_pags(self):
        return self.nre_pags

    # Visualizar los datos
    def visualizar(self):
        return "Anyo: " + self.autor + "nre_pags: " + self.nre_pags