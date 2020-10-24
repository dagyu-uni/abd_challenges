import json
from random import randint
import sys

try:
  MAX_LISTENED_TIMES = int(sys.argv[1])
  NUM_TRACKS = int(sys.argv[2])
  NUM_ROWS = int(sys.argv[3])
except IndexError:
  print("Usage:\n\tpython {} <MAX_LISTENED_TIMES> <NUM_TRACKS> <NUM_ROWS>".format(__file__))
  sys.exit()


data = [
  {"userId":i, **{"track{}".format(e):randint(0,MAX_LISTENED_TIMES) for e in range(0,NUM_TRACKS)}}
  for i in range(0,NUM_ROWS)
]

with open("generated.json", "w") as outputfile:
  json.dump(data, outputfile)