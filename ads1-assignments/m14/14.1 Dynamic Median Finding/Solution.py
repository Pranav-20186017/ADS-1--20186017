def main():
	n = int(input())
	a = []
	for i in range(n):
		val = int(input())
		a.append(val)
		a.sort()
		l = len(a)
		if l % 2 != 0:
			index = ((l+1) // 2) -1
			value = float(round(a[index],1))
			print(value)
		if l % 2 == 0:
			i1 = ((l+1) // 2) - 1
			i2 = ((l+2) // 2) - 1
			med = (a[i1] + a[i2]) / 2
			print(float(round(med, 1))
main()