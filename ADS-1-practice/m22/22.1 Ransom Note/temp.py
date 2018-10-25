mag = "give me one grand today night"
mag = mag.split(" ")
ransom = "give one grand today"
ransom = ransom.split(" ")
counter = 0
for i in ransom:
	if i in mag:
		temp = mag.index(i)
		del mag[temp]
		counter = counter + 1
if counter == len(ransom):
	print("Yes")
else:
	print("No")