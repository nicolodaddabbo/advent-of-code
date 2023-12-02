def find_number_in_line(line):
    for c in line:
        if c.isnumeric():
            return c
        
def get_number(line):
    x, y = 0, 0
    x = find_number_in_line(line)
    line = line[::-1]
    y = find_number_in_line(line)
    return int(x + y)

def main():
    f = open('input.txt', 'r')
    result = 0
    for line in f:
        n = get_number(line)
        result += n
    print(result)
    f.close()
    
if __name__ == '__main__':
    main()
