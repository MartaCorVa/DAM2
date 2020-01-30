# errores y excepciones
# try
# catch
# finally

try:
    f = open("ejemplo.txt", 'r')
    f.write("Esto es una prueba de escritura")
except IOError:
    print "Error: no se puede abrir el fichero o escribir"
else:
    print "todo correcto"
print "ya hemos escrito en el fichero?"