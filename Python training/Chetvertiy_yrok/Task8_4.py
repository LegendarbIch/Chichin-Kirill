# -- coding: utf-8 --
# Задача 8

s = input("Строка: ")
s = s[s.find("h")+1 : s.rfind("h")]
print(s[::-1])
