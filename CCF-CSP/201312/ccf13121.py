#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

mydict = {}

b = list(map(int,input().split()))
b.sort()
a = list(set(b))
MAX = 0
m = 0
for i in range(len(a)):
    if b.count(a[i]) > MAX:
        MAX = b.count(a[i])
        m = a[i]
print(m)
