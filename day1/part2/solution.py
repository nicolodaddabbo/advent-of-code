literalNumbers = {
    'zero': 0,
    'one': 1,
    'two': 2,
    'three': 3,
    'four' : 4,
    'five' : 5,
    'six' : 6,
    'seven' : 7,
    'eight' : 8,
    'nine' : 9
}

def fuck_python(line):
    for key, value in literalNumbers.items():
        if key in line:
            return value
    return None

def find_number_in_line(line):
    buffer = ''
    for c in line:
        if fuck_python((buffer + c)[::-1]):
            return str(fuck_python((buffer + c)[::-1]))
        if fuck_python(buffer + c):
            return str(fuck_python(buffer + c))
        elif not c.isnumeric():
            buffer += c
        else:
            return c
        
def get_number(line):
    x, y = 0, 0
    x = find_number_in_line(line)
    y = find_number_in_line(line[::-1])
    print(x, y)
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