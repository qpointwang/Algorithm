#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

d = list(map(int,input().split()))

d.sort()
total = 0
for i in range(1,n):
    if d[i]-d[i-1] == 1:
        total += 1
print(total)
    
