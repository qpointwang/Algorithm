#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

m = list(map(int,input().split()))

d = {}

for i in range(n):
    if m[i] in d.keys():
        d[m[i]] += 1
    else:
        d[m[i]] = 1

f= sorted(d.items(), key=lambda d:d[1], reverse = True)
c = f[0][1]
l = c
g = []
v = []
i = 0
c = f[0][1]
while (i != len(f)):
    if c == f[i][1]:
        g.append(f[i][0])
        v.append(f[i][1])
    else:
        c = f[i][1]
        
        g.sort()
        for j in range(len(g)):
            print(g[j],v[j])
        g = []
        v = []
        g.append(f[i][0])
        v.append(f[i][1])
    i = i+1
g.sort()
for j in range(len(g)):
    print(g[j],v[j])
'''
13
5 2 3 3 1 3 4 2 5 2 6 5 3

12
5 2 3 3 1 3 4 2 5 2 3 5
'''
