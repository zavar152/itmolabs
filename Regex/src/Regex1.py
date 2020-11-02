import re

regex = r"\b(\w+)\s+\1\b"

test_str = ["Довольно распространённая ошибка ошибка – это повтор слова. Вот в предыдущем\n"
    "предложении такая допущена. Необходимо исправить каждый такой повтор.", "Довольно распространённая ошибка – это повтор слова. Вот в предыдущем\n"
    "предыдущем предложении такая допущена. Необходимо исправить каждый такой повтор.", "Довольно распространённая ошибка – это лишний повтор повтор слова слова. Смешно, не правда ли?",
    "Довольно распространённая ошибка – это лишний повтор слова. Смешно, не правда ли? Не нужно портить хор хоровод", "Довольно распространённая ошибка ошибка – это лишний повтор повтор слова\n"
    "слова. Смешно, не не правда ли? Не нужно портить хор хоровод"]

for i in range(5):
    matches = re.finditer(regex, test_str[i], re.MULTILINE)
    for matchNum, match in enumerate(matches, start=1):
            if match.group().find('\n') != -1:
                test_str[i] = test_str[i].replace(match.group(1), '', 1)
            else:
                test_str[i] = test_str[i].replace(match.group(), match.group(1))
            
    print(test_str[i])
    print('\n')