def func():
    print "func() en primero.py"
    print "top level primero.py"

    if __name__ == "__main__":
        print "el fichero primero.py se esta ejecutando directamente"
    else:
        print "el fichero primero.py se ha importado"

func()