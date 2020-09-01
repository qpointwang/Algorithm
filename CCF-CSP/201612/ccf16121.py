#!/usr/bin/python
# -*- coding: UTF-8 -*- 

# 中间数

n = int(input())

A = list(map(int,input().split()))

A.sort()


flag = 0
for i in range(n):
    b = 0
    s = 0
    for j in range(n):
        if A[j] < A[i]:
            s += 1
        elif A[j] > A[i]:
            b += 1
    if b == s:
        print(A[i])
        flag = 1
        break

if flag == 0:
    print(-1)
'''
6
2 6 5 6 3 5
'''
        
        
