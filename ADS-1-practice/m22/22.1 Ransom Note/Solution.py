"""
Author: Pranav Surampudi
Date: 25/10/2018
"""
LENGTH = input().split(" ")
LENGTH = list(map(int, LENGTH))
MAGL = LENGTH[0]
NOTE = LENGTH[1]
MAG = input().split(" ")
RANSOM = input().split(" ")
COUNTER = 0
for i in RANSOM:
    if i in MAG:
        temp = MAG.index(i)
        del MAG[temp]
        COUNTER = COUNTER + 1
if COUNTER == NOTE:
    print("Yes")
else:
    print("No")
