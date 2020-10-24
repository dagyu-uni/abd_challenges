# Challenge 003, Lesson 23/10/2020
This challege was done by:
* Gaetano D'Agostino
* Tommaso Amadori
* Piero Pastore
## Challenge
**SINGLE CHALLENGE**

Given a dataset which
1. The average number of replays user by user (i.e., how many times
in average each user listen songs)
e.g., [User001:12.3, User002:4.2, ...]
1. The Histogram of point (1)

**GROUP CHALLENGE**

Group builds a script endo to end: from data generation to data visualization (matplotlib or any kind of library)

## Solution
You can find the solution on file [solution.ipynb](solution.ipynb).
### Original Dataset
Given a dataset of `n` rows and `m` tracks this is an example of the dataset:
```
[
  {"userId":0, "track0": 10, ..., "track[m-1]": 12},
  ...,
  {"userId":[n-1], "track0": 2, ..., "track[m-1]": 4}
]
```
where:
* `userId` is the unique id of an user
* `track[i]` is the number of the times that the user listens the track `i`-esima. (Just for completeness of notation when `i=0` then `track[i]=track0`)

### 1) from a rows to list of tuples with userId, cntTrack
In the first map we convert each rows obtaining this configuration:
```
[
  [(0,10), ..., (0,12)],
  ...,
  [(n-1,2), ..., (n-1,4)]
]
```
where in the tuple the first element is the userId and the second element is how many times the user listened the correspondant track for that column

### 2) flat list
We convert the list of list in a list with one level of nesting
```
[
  (0,10),
  ...,
  (0,12),
  ...,
  (n-1,2),
  ...,
  (n-1,4)
]
```
### 3) aggregation
We aggregate the data by userId and for each user we create a tuple where the first value is the sum of tracks listenign and the second value is the count of tracks:
```
{
  0: (SUM, COUNT),
  ...,
  n-1: (SUM, COUNT)
}
```

### 4) calculate avg
Finally we can calculate easily the average executing the function that for each user apply `SUM/COUNT`.

## How to run the example
### Without Docker
First of all you have to generate the dataset:
```
python3 generate_dataset.py <max_listened_times> <num_tracks> <num_rows>
```
where:
* `max_listened_times` this is the maximum of the range within is generated the number that indicates how many times an user listened a track
* `num_tracks` is the number of tracks generated per-user
* `num_rows` is the number of rows of the whole dataset

After that you can open the file `solution.ipynb` with `jupyter`.
### With Docker
```
docker build -t 003 .
docker run -p 8888:8888 003
```

Open a browser with the link prompted, obviously that one with host `127.0.0.1`.

As you can see in the `Dockerfile` the parameters showed above has this default values:
```
ARG num_tracks=100
ARG num_rows=100000
ARG max_listened_times=100
```
but you can customize them editing the `build` command:
```
docker build -t 003 --build-arg num_rows=10 --build-arg max_listened=10 --build-arg num_tracks=10 .
```
