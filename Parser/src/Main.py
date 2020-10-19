import time


def spaces(c):
    out = "";
    for i in range(c):
        out = out + " ";
    return out;


def getArg(i):
    if i.split(": ")[1] != "\n":
        return quot(i.split(": ")[1].replace("\n", ""));
    else:
        return "null";


def quot(i):
    return "\"" + i.replace(":", "") + "\"";


def getTimeArg(i):
    return "\"" + i.split("\'")[1] + "\"";


def bracket(i, sp):
    return spaces(sp) + "{\n" + spaces(sp + 2) + i + "\n" + spaces(sp) + "}";


def getTypeName(i, c):
    return quot(i.split(":")[0][c:len(quot(i.split(":")[0]))].replace("- ", "")) + ":";


def getName(i, c):
    return quot(i.split(":")[0][c:len(quot(i.split(":")[0]))]) + ":";


start_time = time.time()
result = "";
j = 2;
linesAsArray = [];
f = open('sample.yaml', 'r');

for line in f:
    if line != "":
        linesAsArray.append(line)

result = "{\n";
result = result + spaces(2) + quot(linesAsArray[0]).replace("\n", "") + ": [";
lessons = getArg(linesAsArray[1]).replace("\"", "");
result = result + "\n" + spaces(4) + "{\n" + spaces(6) + getName(linesAsArray[1], 2) + " " + lessons + ",\n";

for i in range(int(lessons)):        
    result = result + spaces(6) + getName(linesAsArray[j], 2) + " [\n" + \
    bracket(getTypeName(linesAsArray[j + 1], 2) + " " + getArg(linesAsArray[j + 1]), 8) + ",\n" + \
    bracket(getTypeName(linesAsArray[j + 2], 2) + " " + getArg(linesAsArray[j + 2]), 8) + ",\n" + \
    bracket(getTypeName(linesAsArray[j + 3], 2) + " " + getArg(linesAsArray[j + 3]), 8) + ",\n" + \
    bracket(getTypeName(linesAsArray[j + 4], 2) + " " + getArg(linesAsArray[j + 4]), 8) + ",\n" + \
    bracket(getTypeName(linesAsArray[j + 5], 2) + " " + getArg(linesAsArray[j + 5]), 8) + ",\n" + \
    bracket(getTypeName(linesAsArray[j + 6], 2) + "\n" + \
            bracket(getName(linesAsArray[j + 7], 6) + " " + getTimeArg(linesAsArray[j + 7]) + "," + "\n" + \
                    spaces(12) + getName(linesAsArray[j + 8], 6) + " " + getTimeArg(linesAsArray[j + 8]), 10), 8) + ",\n" + \
                    bracket(getTypeName(linesAsArray[j + 9], 2) + " " + getArg(linesAsArray[j + 9]), 8) + "\n" + spaces(6);
    result = result + "],\n";
    j = j + 10;
result = result[0:len(result) - 2] + "\n";
result = result + spaces(4) + "}\n" + spaces(2) + "]\n" + "}";
res = open('sample.json', 'w');
res.write(result);
f.close()
print("--- %s seconds ---" % (time.time() - start_time))
