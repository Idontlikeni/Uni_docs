f = "0100 0111 1000 1110 1001 1100 0001 0110".replace(" ", "")
print(len(f))
rows = ['00', '01', '11', '10']
cols = ['000', '001', '011', '010', '110', '111', '101', '100']
arr = [['0' for __ in range(len(cols))] for _ in range(4)]
for i in range(32):
    s = bin(i)[2:].rjust(5, "0")
    arr[rows.index(s[:2])][cols.index(s[2:])] = f[i]
for i in range(4):
    print("".join(arr[i]))