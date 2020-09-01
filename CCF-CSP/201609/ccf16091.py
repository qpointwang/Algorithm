#!/usr/bin/python
# -*- coding: UTF-8 -*- 

# 最大波动
n = int(input())

m = list(map(int,input().split()))

MAX = 0
for i in range(1,n):
    if abs(m[i]-m[i-1]) > MAX:
        MAX = abs(m[i]-m[i-1])
print(MAX)


'''
8
8 8 8 0 12 12 8 0

6
2 5 5 7 3 5
'''
