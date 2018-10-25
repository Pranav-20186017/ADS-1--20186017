length = input().split(" ")
length = list(map(int, length))
mag_length = length[0]
note_length = length[1]
mag = input().split(" ")
ransom = input().split(" ")
counter = 0
for i in ransom:
    if i in mag:
        temp = mag.index(i)
        del mag[temp]
        counter = counter + 1
if counter == note_length:
    print("Yes")
else:
    print("No")
