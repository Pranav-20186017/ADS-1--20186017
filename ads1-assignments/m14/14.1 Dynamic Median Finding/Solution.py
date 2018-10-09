n = int(input())
ar = []
for i in range(n):
	ar.append(int(input()))
	ar.sort()
	l = len(ar) - 1
	if(int(l % 2) != 0):
		t = (l - 1) // 2
		med = (ar[t] + ar[t + 1]) / 2
		print(med)
	else:
		med = ar[(l + 1) // 2]
		print(float(med))
