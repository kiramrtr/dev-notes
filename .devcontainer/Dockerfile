FROM python:3.10

## PIP
RUN pip install --upgrade pip

## Install dependencies
COPY requirements.txt /tmp/requirements.txt
RUN pip install -r /tmp/requirements.txt
RUN rm /tmp/requirements.txt
RUN pip install sphinx-autobuild
