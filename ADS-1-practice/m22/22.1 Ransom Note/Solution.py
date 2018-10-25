LENGTH = input().split(" ")
LENGTH = list(map(int, length))
MAGLENGTH = length[0]
NOTELENGTH = length[1]
MAG = input().split(" ")
RANSOM = input().split(" ")
COUNTER = 0
for i in RANSOM:
    if i in MAG:
        temp = MAG.index(i)
        del MAG[temp]
        COUNTER = COUNTER + 1
if COUNTER == NOTELENGTH:
    print("Yes")
else:
    print("No")
