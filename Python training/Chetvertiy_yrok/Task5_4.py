# -- coding: utf-8 --
# Задача 5

s = input("Строка: ")
if s.count('f') == 1:
    print(s.find('f'))
elif s.count('f') >= 2:
    print(s.find('f'), " ", s.rfind('f'))


    