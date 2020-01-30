class Biblioteca():

    publicaciones = []

    # Inicializacion
    def __init__(self, capacidad):
        self.capacidad = capacidad

    # Conocer la capacidad de la biblioteca
    def get_capacidad(self):
        return self.capacidad

    # Conocer el numero de publicaciones
    def nro_publicaciones(self):
        return len(self.publicaciones)

    # Introducir una publicacion
    def introducir_publicacion(self, publicacion):
        self.publicaciones.append(publicacion)

    # Buscar una publicacion por referencia
    def buscar_publicacion(self, referencia):
        for publi in self.publicaciones:
            if referencia == publi:
                return publi

    # Mostrar una publicacion por referencia
    def buscar_publicacion(self, referencia):
        for publi in self.publicaciones:
            if referencia == publi:
                print publi

    # Visualizar el contenido de la biblioteca
    def visualizar(self):
        for publi in self.publicaciones:
                print publi