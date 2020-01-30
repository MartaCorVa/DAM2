from primero import *

print "top level segundo.py"
func()

if __name__ == "__main__":
    print "el fichero segundo.py se esta ejecutando directamente"
else:
    print "el fichero segundo.py ha sido importado"