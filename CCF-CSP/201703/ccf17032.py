#!/usr/bin/python
# -*- coding: UTF-8 -*- 

#学生排队

n = int(input())

queue = []
for i in range(n):
    queue.append(i+1)
m = int(input())

for i in range(m):
    location = -1 
    p,q = input().split()
    p,q = int(p),int(q)
    for j in range(n):
        if queue[j] == p:
            location = j
            break
    if q>=0:  ##向后移
        for j in range(location,location+q):
            queue[j] = queue[j+1]
        queue[location+q] = p
    if q<0:  ##向前移
        for j in range(location,location+q,-1):
            queue[j] = queue[j-1]
        queue[location+q] = p
for i in range(n):
    print(str(queue[i])+' ',end='')
print()
'''
8
3
3 -2
8 -3
3 2
'''
