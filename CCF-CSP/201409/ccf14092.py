#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

m = []

for i in range(101):
    t = []
    for j in range(101):
        t.append(0)
    m.append(t)

for i in range(n):
    d = list(map(int,input().split()))
    for j in range(d[0],d[2]):
        for k in range(d[1],d[3]):
            m[j][k]=1
total = 0
for i in range(101):
    total += sum(m[i])
print(total)
