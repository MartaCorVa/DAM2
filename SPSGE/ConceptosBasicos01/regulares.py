# expresiones regulares
import re

# patron = ["term1","term2"]
# texto = "esto es un texto en el que aparece term1"
#
# for p in patron:
#     print "estoy buscando el patron: {}".format(p)
#     if re.search(p, texto):
#         print "encontrado"
#     else:
#         print "no encontrado"

# patron = "term1"
# texto = "term1"
#
# enc = re.search(patron,texto)
# print enc.start()


# patron = "term1"
# texto = "esto es un texto en el que aparece term1 y esto esta detras"
#
# enc = re.split()
# print enc

def multi_re_find(patrones, texto):
    for pat in patrones:
        print "estoy buscando el patron: {}".format(p)
        print re.findall(pat, texto)
        print

# frase = "sdsd.....sddddd.....ssss......dsdddssss......dsds........dssssss....sdddsddd"
# test_pat = ['sd*'] #una s seguida de 0 o mas d
# test_pat = ['sd+'] # una s seguida de 1 o mas d
# test_pat = ['sd?'] # o s o nada o s y una d
# test_pat = ['sd{3}'] # una s con tres d
# test_pat = ['sd{1,3}'] # de 1 a 3 d
# test_pat = ['s[sd]+'] # s o ss o ssd

frase = "esto es un string! pero contiene signos de puntacion. y un #hastag"
test_pat = ['[^!?.,#]+']
test_pat ['[a-z]+']
test_pat ['[A-Z]+']
test_pat = [r'\S+']
test_pat = [r'\w+']
test_pat = [r'\W+']
multi_re_find(test_pat, frase)
