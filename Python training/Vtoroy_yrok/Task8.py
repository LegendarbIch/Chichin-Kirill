# -- coding: utf-8 --

#Задача 8
one = int(input("Первое число: "))
two = int(input("Второе число: "))
three = int(input("Третье число: "))
if (one == two == three):
    print("3") 
elif one == two or two == three or one == three:
    print("2")
else:
    print("0")

print("\n")