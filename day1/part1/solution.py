def getNumber(line):
    x, y = 0, 0
    for c in line:
        if c.isnumeric():
            x = c
            break
    line = line[::-1]
    for c in line:
        if c.isnumeric():
            y = c
            break
    return int(x + y)

def main():
    f = open('input.txt', 'r')
    result = 0
    for line in f:
        n = getNumber(line)
        result += n
    print(result)
    f.close()
    
if __name__ == '__main__':
    main()
