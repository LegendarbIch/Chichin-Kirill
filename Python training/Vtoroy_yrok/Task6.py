# -- coding: utf-8 --

#Задача 6
str1 = int(input("Номер строки первой клетки (от 1 до 8):"))
stolbec1 = int(input("Номер столбца первой клетки (от 1 до 8):"))

str2 = int(input("Номер строки второй клетки (от 1 до 8):"))
stolbec2 = int(input("Номер столбца второй клетки (от 1 до 8):"))


if ((str1 and stolbec1) >= 1 and (str1 and stolbec1) <= 8) and ((str2 and stolbec2) >= 1 and (str2 and stolbec2) <= 8):
    if (str1 % 2 == 1 and stolbec1 % 2 == 1) or (str1 % 2 == 0 and stolbec1 % 2 == 0) :
        colour1 = str("Белый")
    else:
        colour1 = str("Черный")
    if (str2 % 2 == 1 and stolbec2 % 2 == 1) or (str2 % 2 == 0 and stolbec2 % 2 == 0):
        colour2 = str("Белый")
    else:
        colour2 = str("Черный")
else:
    print("Числа должно быть в отрезке [1 ; 8]")
print("Цвета совпадают? - ")
if colour1 == colour2:
    print("Да")
else:
    print("Нет")

print("\n")





