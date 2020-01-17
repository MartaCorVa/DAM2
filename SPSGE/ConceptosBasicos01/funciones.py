# funciones
def funcion1(param1='default'):
    print 'estamos dentro de la funcion1 {p}'.format(p = param1)

funcion1()

def funcion(param1):
    """
    Esto es la documentacion de la funcion
    :param param1:
    :return:
    """
    return 'estamos dentro de la funcion1'

print funcion('hello')
