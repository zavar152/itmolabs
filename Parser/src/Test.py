import yaml
import json
import time
start_time = time.time()
for q in range(10):
    OUT = open('libs/data_file.json', 'w')
    IN = open("libs/output.yaml", 'r')
    
    YAML = yaml.load(IN, Loader=yaml.FullLoader)
    IN.close()
    json.dump(YAML, OUT)
    OUT.close()
print("--- %s seconds ---" % (time.time() - start_time))
