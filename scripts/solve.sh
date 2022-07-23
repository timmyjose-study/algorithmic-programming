#!/usr/local/bin/bash

file="$1"
filename="${file%.*}"
extension="${file##*.}"

input_file=${filename,,_}; input_file=${filename//_}; input_file=${input_file}.in
input_file=${input_file:-/dev/stdin}

if [[ ! -f ${input_file} ]]
then
  input_file=/dev/stdin
fi

case "${extension}" in
  java)
    javac -Xlint "${file}"
    java -cp . "${filename}" < ${input_file}
    rm "${filename}".class
    ;;

  c)
    gcc -Wall -std=c17 -O2 -o "${filename}" "${file}"
    ./"${filename}" < ${input_file}
    rm "${filename}"
    ;;

  cpp)
    g++ -Wall -std=c++2a -O2 -o "${filename}" "${file}"
    ./"${filename}" < ${input_file}
    rm "${filename}"
    ;;

  py)
    python3 "${file}" < ${input_file}
    ;;

  *)
    echo "Got some other file"
    ;;
esac