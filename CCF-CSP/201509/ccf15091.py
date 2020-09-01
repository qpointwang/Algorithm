#!/usr/bin/python
# -*- coding: UTF-8 -*- 


n = int(input())

m = list(map(int,input().split()))

a = m[0]
num = 1
for i in range(1,n):
    if m[i] == a:
        continue
    a = m[i]
    num += 1
print(num)


'''
8
8 8 8 0 12 12 8 0
'''
