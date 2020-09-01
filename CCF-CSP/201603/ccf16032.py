#!/usr/bin/python
# -*- coding: UTF-8 -*- 

#折点计数

def printh(s):
    for i in range(len(s)):
        for j in range(len(s[0])):
            print(str(s[i][j])+' ',end='')
        print()
def check(s):
    for i in range(4):
        for j in range(4):
            if s[i][j]==2:
                return 1
    return 0

n = 15
m = 10
mm = []
im = []
for i in range(n):
    mm.append(list(map(int,input().split())))
for i in range(4):
    im.append(list(map(int,input().split())))
p = int(input())

#构造四列对比矩阵，在原位置基础上，上面加3行0，下面加3行1  ！！！！注意，下面三行一定要为1，代表已经是满的了，如果为0，则默认为空，还可以继续填充
#亲测下面三行全为0时，成绩为90，全为1时，成绩为100
pro = []
pro.append([0,0,0,0])
pro.append([0,0,0,0])
pro.append([0,0,0,0])
for i in range(n):
    temp = []
    for j in range(p-1,p+3):
        temp.append(mm[i][j])
    pro.append(temp)
pro.append([1,1,1,1])
pro.append([1,1,1,1])
pro.append([1,1,1,1])

result = []
last = 18
for i in range(4):
    result.append([0,0,0,0])

for k in range(18):
    for i in range(k,k+4):
        #print(k,i-k,i)
        result[i-k][0] = im[i-k][0] + pro[i][0]
        result[i-k][1] = im[i-k][1] + pro[i][1]
        result[i-k][2] = im[i-k][2] + pro[i][2]
        result[i-k][3] = im[i-k][3] + pro[i][3]
    if check(result) == 1:
        last = k
        break
jj = last-4

for i in range(jj,jj+4):
    if i > 14:
        break
    for j in range(p-1,p+3):
        #print(mm[i][j],im[i-last+4][-p+1+j],i-last+4,-p+1+j)
        mm[i][j] = im[i-jj][-p+1+j] + mm[i][j]

printh(mm)


'''
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 2
0 0 1 0 0 0 0 0 0 3
0 0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 0 5
0 0 0 0 0 0 0 0 0 6
0 0 0 0 0 0 0 0 0 7
0 0 0 0 0 0 0 0 0 8
0 0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 0 10
0 0 0 0 0 0 0 0 0 11
0 0 0 0 0 0 0 0 0 12
0 0 0 0 0 0 0 1 0 13
0 0 0 0 0 0 1 0 0 14
0 0 1 0 0 0 1 0 0 15
1 1 1 0 0 0 1 1 1 16
0 0 0 0 1 0 0 0 0 17




0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 1 0 0 0
1 1 0 0 0 0 1 1 1 1
0 0 0 0 0 0 0 0 0 0
0 0 0 1
0 1 1 1
0 0 0 0
0 0 0 0
1

0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 1 0 0 0
1 1 0 0 0 0 1 1 1 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0
0 0 1 0
0 0 1 0
0 0 1 1
1
'''
