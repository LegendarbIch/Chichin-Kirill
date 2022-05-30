# -- coding: utf-8 --

#Задача 7
god = int(input("Введите год"))
print("Год високосный? - ")
if (god % 4 == 0 and god % 100 != 0) or god % 400 == 0:
    print("Да")
else:
    print("Нет")

print("\n")