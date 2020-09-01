#!/usr/bin/python
# -*- coding: UTF-8 -*- 

import random

r,y,g = input().split()
r,y,g = int(r),int(y),int(g)

n = int(input())

total = 0

for i in range(n):
    k,t = input().split()
    k,t = int(k),int(t)
    if k == 0:  #当k = 0时，经过一段路，直接加t
        total += t
    elif k == 1:  #红灯，需要等待t秒,下一阶段是绿灯，不需要等待了
        total += t
    elif k == 2:  #黄灯，需要等到t秒，并且等待红灯时间
        total = total + t + r
    elif k == 3:  #绿灯，不需要等待，直接通行
        total = total
print(total)
        
        
