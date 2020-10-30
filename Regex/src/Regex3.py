import re

regex = r"[уеёыаоэяию]"

test1 = "Классное слово - обороноспособность, которое должно идти после слов: трава и молоко."
test2 = "Корова дала молоко"
test3 = "Папа отправился в огород"
test4 = "Слово комод и слово потоп"
test5 = "Перед домом стоит компот"


def checkWord(s):
    matches = re.findall(regex, s, re.MULTILINE)
    result = True
    if len(matches) != 0:
        for i in range(len(matches)):
            if matches[i] != matches[0]:
                result = False;
    else:
        result = False;
    return result;


def sort(string_list):
    return sorted(string_list, key=len)

def findWord(test_str):
    symb = [" -", " –", ",", ".", ":", "!", "?"];
    for i in symb:
        test_str = test_str.replace(i, "")
    p = re.split(r'\s+', test_str)  
    buf = []
    for i in p:
        if checkWord(i):
            buf.append(i)
    print(*sort(buf), sep='\n')


findWord(test1)
print()
findWord(test2)
print()
findWord(test3)
print()
findWord(test4)
print()
findWord(test5)
