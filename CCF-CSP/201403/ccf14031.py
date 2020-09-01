#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

mydict = {}

b = list(map(int,input().split()))

for i in range(n):
    if b[i] < 0:
        if -b[i] in mydict.keys():
            mydict[-b[i]] += 1
        else:
            mydict[-b[i]] = 1
    if b[i] > 0:
        if b[i] in mydict.keys():
            mydict[b[i]] += 1
        else:
            mydict[b[i]] = 1
total = 0
for key in mydict:
    if mydict[key] == 2:
        total += 1
print(total)
