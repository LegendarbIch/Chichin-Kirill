# -- coding: utf-8 --
# Задача 7

s = input("Строка: ")
s = s[:s.find("h")] + s[s.rfind("h")+1:]
print(s)
