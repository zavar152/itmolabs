#!/usr/bin/python3
import yaml
import sys
import json
import time
start_time = time.time()
OUT = open('libs/data_file.json', 'w')
IN = open("libs/output.yaml", 'r')

JSON = yaml.load(IN, Loader=yaml.FullLoader)
IN.close()
json.dump(JSON, OUT)
OUT.close()
print("--- %s seconds ---" % (time.time() - start_time))
