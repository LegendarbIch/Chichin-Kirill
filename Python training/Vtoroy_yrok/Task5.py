# -- coding: utf-8 --

#Задача 5
a = int(input("Первое число:"))
b = int(input("Второе число:"))
c = int(input("Третье число:"))
def naimenshee(a , b , c):
	return(min(a,b,c))
print("Наименьшим числом является:", naimenshee(a,b,c))

print("\n")