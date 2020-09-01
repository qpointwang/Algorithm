#!/usr/bin/python
# -*- coding: UTF-8 -*- 

import random

def trafficLight(r,y,g,k,t,total):
    #k等于0时表示通关一段路，没有红绿灯，这里不考虑

    #k等于1时，初始时刻为红灯，经过total后变为什么灯，还需要等多少秒
    if k == 1:
        if t > total%(r+y+g): #没有变灯，还是红灯，需要等待t-total%(r+y+g)
            return 1,t-total%(r+y+g)
        elif t <= total%(r+y+g) and (total%(r+y+g)-t) < g:#变为绿灯，不需等待
            return 3,g-(total%(r+y+g)-t)
        elif (total%(r+y+g)-t) >= g and (total%(r+y+g)-t) < (g+y):#变为黄灯
            return 2,(g+y)-(total%(r+y+g)-t)
        elif (total%(r+y+g)-t) >= (g+y) and (total%(r+y+g)-t) < (g+y+r):#变为红灯
            return 1,(g+y+r)-(total%(r+y+g)-t)
    #k等于2时，初始时刻为黄灯，顺序依次为黄、红、绿
    if k == 2:
        if t > total%(r+y+g):#没有变灯，还是黄灯
            return 2,t-total%(r+y+g)
        elif t <= total%(r+y+g) and (total%(r+y+g)-t) < r:#变为红灯，需要等待r - (total%(r+y+g)-t)
            return 1,r - (total%(r+y+g)-t)
        elif (total%(r+y+g)-t) >= r and (total%(r+y+g)-t) < (g+r):#变为绿灯，不需等待
            return 3,(g+r)-(total%(r+y+g)-t)
        elif (total%(r+y+g)-t) > (g+r) and (total%(r+y+g)-t) < (g+r+y):#变为黄灯
            return 2,(g+r+y)-(total%(r+y+g)-t)
    #k等于3时，初始时刻为绿灯，顺序依次为绿、黄、红
    if k == 3:
        if t > total%(r+y+g):#没有变灯，还是绿灯，不需要等待
            return 3,t - total%(r+y+g)
        elif t <= total%(r+y+g) and (total%(r+y+g)-t) < y:#变为黄
            return 2,y - (total%(r+y+g)-t)
        elif (total%(r+y+g)-t) >= y and (total%(r+y+g)-t) < (y+r):#变为红
            return 1,(y+r) - (total%(r+y+g)-t)
        elif (total%(r+y+g)-t) >= (y+r) and (total%(r+y+g)-t) < (y+r+g):#变为绿
            return 3,(y+r+g) - (total%(r+y+g)-t)
    if k == 0:
        return 0,t
'''
print(trafficLight(30,3,30,1,5,5))
print(trafficLight(30,3,30,1,5,6))
print(trafficLight(30,3,30,1,5,35))
print(trafficLight(30,3,30,1,5,36))
print(trafficLight(30,3,30,1,5,38))
print(trafficLight(30,3,30,1,5,43))
print(trafficLight(30,3,30,1,5,63))
print('-------')
print(trafficLight(30,3,30,2,2,1))
print(trafficLight(30,3,30,2,2,2))
print(trafficLight(30,3,30,2,2,30))
print(trafficLight(30,3,30,2,2,32))
print(trafficLight(30,3,30,2,2,38))
print(trafficLight(30,3,30,2,2,43))
print(trafficLight(30,3,30,2,2,63))
print('-------')
print(trafficLight(30,3,30,3,2,1))
print(trafficLight(30,3,30,3,2,2))
print(trafficLight(30,3,30,3,2,5))
print(trafficLight(30,3,30,3,2,32))
print(trafficLight(30,3,30,3,2,38))
print(trafficLight(30,3,30,3,2,43))
print(trafficLight(30,3,30,3,2,63))
'''
r,y,g = input().split()
r,y,g = int(r),int(y),int(g)

n = int(input())

total = 0

for i in range(n):
    k,t = input().split()
    k,t = int(k),int(t)
    k,t = trafficLight(r,y,g,k,t,total)
    if k == 0:  #当k = 0时，经过一段路，直接加t
        total += t
    elif k == 1:  #红灯，需要等待t秒,下一阶段是绿灯，不需要等待了
        total += t
    elif k == 2:  #黄灯，需要等到t秒，并且等待红灯时间
        total = total + t + r
    elif k == 3:  #绿灯，不需要等待，直接通行
        total = total
print(total)


