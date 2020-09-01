#!/usr/bin/python
# -*- coding: UTF-8 -*- 

y = int(input())

d = int(input())
p = [31,28,31,30,31,30,31,31,30,31,30,31]
r = [31,29,31,30,31,30,31,31,30,31,30,31]
flag = 0
if y%4 == 0:
    if y%100 == 0:
        if y%400 == 0:
            flag = 1
        else:
            flag = 0
    else:
        flag = 1
e = 0
m = 0
total = 0
if flag == 0:#平年
    for i in range(12):
        e += p[i]
        if e >= d:
            m = i
            break
    for i in range(m):
        total += p[i]
        
else:#闰年
    for i in range(12):
        e += p[i]
        if e >= d:
            m = i
            break
    for i in range(m):
        total += r[i]
print(m+1)
print(d-total)

'''
2015
80

2000
40
'''
