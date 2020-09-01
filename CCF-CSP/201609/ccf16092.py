#!/usr/bin/python
# -*- coding: UTF-8 -*- 


# 火车购票
n = int(input())

P = list(map(int,input().split()))

y = 20
x = 5

location = []
for i in range(y):
    location.append([0,0,0,0,0])

for i in range(n):
    result = []
    flag = 0
    num = 0
    for j in range(y):
        if sum(location[j]) + P[i] <= x:  #第i个指令可以放在第j排
            for k in range(x):
                if location[j][k] == 0:  #第j排第k个座位为空
                    location[j][k] = 1
                    num += 1
                    result.append(j*5+k+1)
                if num == P[i]:
                    flag = 1
                    break
            if flag == 1:
                break

    if flag == 0:  #循环完一次20排座位后仍然没有分配，那就从小到大分配
        for j in range(y):
            for k in range(x):
                if location[j][k] == 0:
                    location[j][k] = 1
                    num += 1
                    result.append(j*5+k+1)
                if num == P[i]:
                    flag = 1
                    break
            if flag == 1:
                break
    for j in range(len(result)):
        print(str(result[j])+' ',end='')
    print()
'''
4
2 5 4 2

11 
2 5 4 4 4 1 4 4 2 4 1
'''
