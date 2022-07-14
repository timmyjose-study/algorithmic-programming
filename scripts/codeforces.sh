#!/usr/local/bin/bash

dirname="$1"
mkdir -p ${dirname} && cp $HOME/dev/competitive-programming/templates/codeforces/main.cpp ${dirname}/main.cpp && touch ${dirname}/main.in