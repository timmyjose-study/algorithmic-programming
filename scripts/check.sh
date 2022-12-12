#!/usr/local/bin/bash

file="$1"
filename="${file%.*}"
extension="${file##*.}"

input_file=${filename,,_}; input_file=${filename//_}; input_file=${input_file}.in
input_file=${input_file:-/dev/stdin}
output_file=${filename,,_}; output_file=${filename//_}; output_file=${output_file}.out
check_file=${filename,,_}; check_file=${filename//_}; check_file=${check_file}.check

if [[ ! -f ${input_file} ]]
then
  input_file=/dev/stdin
fi

case "${extension}" in
  c)
    gcc -Wall -std=c17 -O2 -o "${filename}" "${file}"

    if [[ -f ${check_file} ]]
    then
      ./"${filename}" < ${input_file} > ${output_file}
      $(diff -i ${output_file} ${check_file})
      
      if [[ $? -ne 0 ]]
      then
        diff -y -b ${output_file} ${check_file}
      else
        echo "Passed"
      fi
      rm ${output_file}
    else
      ./"${filename}" < ${input_file}
    fi

    rm "${filename}"
    ;;

  cpp)
    g++ -Wall -std=c++2a -O2 -o "${filename}" "${file}"

    if [[ -f ${check_file} ]]
    then
      ./"${filename}" < ${input_file} > ${output_file}
      $(diff -i ${output_file} ${check_file})
      
      if [[ $? -ne 0 ]]
      then
        diff -y -b ${output_file} ${check_file}
      else
        echo "Passed"
      fi
      rm ${output_file}
    else
      ./"${filename}" < ${input_file}
    fi

    rm "${filename}"
    ;;

  java)
    javac -Xlint "${file}"

    if [[ -f ${check_file} ]]
    then
      java -cp . "${filename}" < ${input_file} > ${output_file}
      $(diff -i ${output_file} ${check_file})
      
      if [[ $? -ne 0 ]]
      then
        diff -y -b  ${output_file} ${check_file}
      else
        echo "Passed"
      fi

      rm ${output_file}
      rm ${filename}.class
    else
      java -cp . "${filename}" < ${input_file}
    fi
    rm -f *.class
    ;;

  py)
    if [[ -f ${check_file} ]]
    then
      python3 "${file}" < ${input_file} > ${output_file}
      $(diff -i ${output_file} ${check_file})
      
      if [[ $? -ne 0 ]]
      then
        diff -y -b  ${output_file} ${check_file}
      else
        echo "Passed"
      fi

      rm ${output_file}
    else
      python3 "${file}" < ${input_file}
    fi
    ;;

  rs)
    rustc -O "${file}"

    if [[ -f ${check_file} ]]
    then
      ./"${filename}" < ${input_file} > ${output_file}
      $(diff -i ${output_file} ${check_file})
      
      if [[ $? -ne 0 ]]
      then
        diff -y ${output_file} ${check_file}
      else
        echo "Passed"
      fi
      rm ${output_file}
    else
      ./"${filename}" < ${input_file}
    fi

    rm "${filename}"
    ;;

  *)
    echo "Got some other file"
    ;;
esac