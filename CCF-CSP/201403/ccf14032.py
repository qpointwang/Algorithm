#!/usr/bin/python
# -*- coding: UTF-8 -*- 

N,M = input().split()
N,M = int(N),int(M)

d = {}
order = {}
for i in range(N):
    d[i+1] = list(map(int,input().split()))
    order[i+1] = i
for i in range(M):
    flag = 0
    x,y = input().split()
    x,y = int(x),int(y)
    o= sorted(order.items(), key=lambda d:d[1], reverse = True)
    for j in range(len(o)):
        if d[o[j][0]][0] <= x and d[o[j][0]][2] >= x and d[o[j][0]][1] <= y and d[o[j][0]][3] >= y:
            flag = 1
            cur = order[o[j][0]]
            print(o[j][0])
            
            for k in order:
                if order[k] > cur:
                    order[k] -= 1
            order[o[j][0]] = N-1
            break
    if flag == 0:
        print("IGNORED")
