#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n,m = input().split()
n,m = int(n),int(m)

o = []  #原始矩阵
p = []  #转置矩阵
for i in range(m):
    t = []
    p.append(t)
for i in range(n):
    t = list(map(int, input().split()))
    o.append(t)
    for j in range(m):
        p[j].append(t[j])

space = []

for i in range(n):
    t=[]
    t.append([i,0,o[i][0]])
    total = 1
    first = o[i][0]
    for j in range(1,m):
        if first == o[i][j]:
            total += 1
            t.append([i,j,o[i][j]])
        else:
            first = o[i][j]
            total = 1
            t = []
            t.append([i,j,o[i][j]])
        if total >= 3:
            #print(i,j,total)
            space.append(t)

for i in range(m):
    t=[]
    t.append([0,i,p[i][0]])
    total = 1
    first = p[i][0]
    for j in range(1,n):
        if first == p[i][j]:
            total += 1
            t.append([j,i,p[i][j]])
        else:
            first = p[i][j]
            total = 1
            t = []
            t.append([j,i,p[i][j]])
        if total >= 3:
            #print(j,i,total)
            space.append(t)

for i in range(len(space)):
    #print(space[i])
    for j in range(len(space[i])):
        o[space[i][j][0]][space[i][j][1]]=0

for i in range(n):
    for j in range(m):
        print(str(o[i][j])+' ',end='')
    print()
'''
4 5
2 2 3 1 2
3 4 5 1 4
2 3 2 1 3
2 2 2 4 4

4 5
2 2 3 1 2
3 1 1 1 1
2 3 2 1 3
2 2 3 3 3

4 8
2 2 3 1 2 2 2 3
3 4 5 1 4 3 4 5
2 3 2 1 3 2 3 2
2 2 2 2 4 2 2 2
'''
