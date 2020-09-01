#!/usr/bin/python
# -*- coding: UTF-8 -*- 

n = int(input())

m = list(map(int,input().split()))

#n = 5
#m = [1,2,1,1,3]

d = {}
r = []
for i in range(n):
    if m[i] in d.keys():
        d[m[i]] += 1
    else:
        d[m[i]] = 1
    print(str(d[m[i]])+" ",end='')
    r.append(d[m[i]])
#print(r)
