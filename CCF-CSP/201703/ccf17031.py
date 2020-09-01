#!/usr/bin/python
# -*- coding: UTF-8 -*- 

#折点计数

n,k = input().split()
n,k = int(n),int(k)
A = list(map(int,input().split()))

result = 0
num = 0
for i in range(n):
    if result == 0:
        #print(A[i])
        num += 1
    
    result += A[i]
    if result >= k:
        result = 0
print(num)


'''
8 9
2 6 5 6 3 5 1 1
'''
