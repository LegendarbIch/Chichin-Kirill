# -- coding: utf-8 --

#Задача 4

seconds = int(input("Введите кол-во секунд "))
dni = seconds//(3600*24)
chasi = seconds//3600
min = seconds//60
print('Дней: ', dni) 
print('Часов: ', chasi)
print('Минут: ', min)
print('Секунд: ', seconds)