#!/usr/local/bin/bash

dirname="$1"

mkdir -p ${dirname} && cp $HOME/dev/competitive-programming/templates/leetcode/Main.java ${dirname}/Main.java && touch ${dirname}/Main.in
