FROM python:3.8
RUN pip install --upgrade pip

ARG num_tracks=100
ARG num_rows=100000
ARG max_listened_times=100

WORKDIR /app

COPY *.ipynb .
COPY *.txt .
COPY *.py .

RUN pip install -r requirements.txt
RUN python generate_dataset.py $max_listened_times $num_tracks $num_rows
RUN rm *.py
RUN rm *.txt

RUN pip install jupyter

EXPOSE 8888
CMD jupyter notebook --port=8888 --ip=0.0.0.0 --no-browser --allow-root

