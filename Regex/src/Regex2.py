import re

f = open('Hamlet.txt', 'r');

text = "";

for line in f:
    if line != "":
        text = text + line;

p = re.split(r'(?<=[.!?…])', text)
res = open('hamlet/regex.txt', 'w');

for i in p:
    if re.findall(r'!', i) and re.findall(r',', i):
        res.write(i + "\n");

# Checking 
        
chars = list(text);
i = len(chars) - 1;
begin = False;
sen = "";
senlist = [];
index = 0;

while i != -1:
    if begin:
        if chars[i] == '.' or chars[i] == '!' or chars[i] == '?':
            begin = False;
            if sen.find(",") != -1:
                senlist.append(sen[::-1]);
            sen = "";
        else:
            sen = sen + chars[i]
    if chars[i] == '!' and not begin:
        begin = True;
        sen = sen + chars[i]
    i = i - 1;

i = len(senlist) - 1
res = open('hamlet/check.txt', 'w');

while i != -1:
    res.write(senlist[i] + "\n");
    i = i - 1;
