#!/usr/local/bin/bash

dirname="$1"
if [[ -e ${dirname} ]]
then
  cp $HOME/dev/competitive-programming/templates/rust/main.rs ./main.rs && touch ./main.in
else
  mkdir -p ${dirname} && cp $HOME/dev/competitive-programming/templates/rust/main.rs ${dirname}/main.rs && touch ${dirname}/main.in
fi
