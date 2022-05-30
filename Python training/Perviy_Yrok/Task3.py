# -- coding: utf-8 --

#Задача 3

age = int(input("Введите ваш возраст: "))
name = input("Ваше имя: ")

if age>0 and age<75 and name != "Иван":
    if age>=16:
        print("Поздравляем, вы поступили в ВГУИТ")
    elif age<16:
        print("Сначала нужно окончить школу")
        print("Осталось учиться лет: ", (16 - age))