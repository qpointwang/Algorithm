#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n,m = list(map(int,input().split()))

h = []

for i in range(m):
    b = []
    h.append(b)

for i in range(n):
    v = list(map(int,input().split()))
    for j in range(m):
        h[j].append(v[m-j-1])
        
for i in range(m):
    for j in range(n):
        print(str(h[i][j])+" ",end='')
    print()
