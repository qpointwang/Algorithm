#!/usr/bin/python
# -*- coding: UTF-8 -*- 

#折点计数

n = int(input())
l = list(map(int,input().split()))
total = 0

for i in range(1,n-1):
    #print(i, l[i-1], l[i], l[i+1])
    if l[i-1] > l[i] and l[i] < l[i+1]:
        #print('极小值')
        total += 1
    elif l[i-1] < l[i] and l[i] > l[i+1]:
        #print('极大值')
         total += 1
print(total)

'''
7
5 4 1 2 3 6 4
'''
