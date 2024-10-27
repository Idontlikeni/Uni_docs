f = '0100 0111 1000 1110 1001 1100 0001 0110'.replace(' ', '')
dct = {}
for i in range(6):
    dct[i] = []

for i in range(len(f)):
    s = bin(i)[2:].rjust(5, "0")
    e = f[i]
    if e == '1':
        dct[s.count("1")].append(s);
    print(s)
print()