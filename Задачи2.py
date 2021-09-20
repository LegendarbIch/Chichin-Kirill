# -- coding: utf-8 --

#Задача 1
a = int(input("Введите первое число:"))
b = int(input("Введите второе число:"))
c = int(input("Введите третье число:"))
print(a + b + c)

#Задача 2
a = int(input("Введите первый катет:"))
b = int(input("Введите второй катет:"))
print("Площадь треугольника =", (a*b)//2)

#Задача 3
n = int(input("Кол-во минут:"))
chasi = n//60
ost_min = n%60
if chasi + (ost_min//100) > 23.59:
	while chasi + (ost_min//100) > 23.59:
		chasi = chasi - 24
print("Часов:", chasi, "Минут:", ost_min)

#Задача 4
a = int(input("Расстояния между рядами с дырочками"))
b = int(input("Расстояние между дырочками в ряду"))
l = int(input("Длинна оставшегося шнурка"))
N = int(input("Кол-во дырочек в ряду"))
def shnurok(a , b , l, N):
	return (b*(N-1)) + a*N + l
print("Длинна всего шнурка должна быть равна:", shnurok(a, b, l, N))

#Задача 5
a = int(input("Первое число:"))
b = int(input("Второе число:"))
c = int(input("Третье число:"))
def naimenshee(a , b , c):
	return(min(a,b,c))
print("Наименьшим числом является:", naimenshee(a,b,c))