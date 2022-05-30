# -- coding: utf-8 --
# Задача 3

s = input("Строка: ")
s1 = s[:len(s)-len(s)//2]
s2 = s[len(s)-len(s)//2:]
s1,s2 = s2,s1
new_s = s1+s2
print(new_s)
