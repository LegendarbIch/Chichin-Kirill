# -- coding: utf-8 --
# Задача 6


s = input("Строка: ")
if s.count("f") >= 2:
    s = s.replace("f", " ", 1)
    print(s.find("f"))
elif s.count("f") == 1:
    print(-1)
else:
    print(-2)
