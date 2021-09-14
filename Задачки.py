# -- coding: utf-8 --

#Задача 1
print ("Курс Основы программирования начался")

#Задача 2
print( (16823*12302)%3092 )

#Задача 3
age = int(input("Введите ваш возраст: "))
name = input("Ваше имя: ")

if age>0 and age<75 and name != "Иван":
    if age>=16:
        print("Поздравляем, вы поступили в ВГУИТ")
    elif age<16:
        print("Сначала нужно окончить школу")
        print("Вам осталось учиться в школе столько лет, сколько классов в промежутке от вашего класса до одинадцатого))")

#Задача 4

seconds = int(input("Введите кол-во секунд "))
dni = seconds//(3600*24)
chasi = seconds//3600
min = seconds//60
print('Дней: ', dni) 
print('Часов: ', chasi)
print('Минут: ', min)
print('Секунд: ', seconds)

#Задача 5

n = int(input("Введите число n "))
print(n + n**2 + n**3 + n**4 + n**5)

#Задача 6

x = int(input("Введите икс "))
y = int(input("Введите игрик "))
x, y = y, x
print(x,y)

#Задача 7

number = int(input("Введите число "))
if number % 2 == 0:
    print("Число четное")
else:
    print("Число нечетное")