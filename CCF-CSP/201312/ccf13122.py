#!/usr/bin/python
# -*- coding: UTF-8 -*- 

#input = list(map(int,input().split('-')))
input = input()
input = input.split('-')

total = int(input[0])*1
total = int(input[1][0])*2 + int(input[1][1])*3 + int(input[1][2])*4 + total
total = int(input[2][0])*5 + int(input[2][1])*6 + int(input[2][2])*7 + int(input[2][3])*8 + int(input[2][4])*9 + total
result = total%11
if result == 10:
    result = 'X'
if str(result) == str(input[3]):
    print('Right')
else:
    print(input[0]+'-'+input[1]+'-'+input[2]+'-'+str(result))
