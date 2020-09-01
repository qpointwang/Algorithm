#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

m= []

for i in range(n):
    t = list(map(int,input().split()))
    m.append(t)

r = []
for i in range(2,2*n+1):
    if i%2 == 0: #从左下到右上
        for j in range(1,i):
            if i-j<=n and j<=n:
                #print(i-j,j)
                r.append(m[i-j-1][j-1])
    else: #从右上到左下
        for j in range(1,i):
            if i-j<=n and j<=n:
                #print(j,i-j)
                r.append(m[j-1][i-j-1])
    
for i in range(len(r)):
    print(str(r[i])+" ",end='')
