f = '0100 0111 1000 1110 1001 1100 0001 0110'.replace(' ', '')
sdnf = ''
sknf = ''
for i in range(len(f)):
    s = bin(i)[2:].rjust(5, '0')
    if f[i] == '1':
        sknf += '-'
    else:
        for j in range(5):
            if s[j] == '0':
                sdnf = "\\" + "bar"
            else: sdnf += 'x_{' + str(j) + '}'
        sdnf += '+'
print(sdnf)