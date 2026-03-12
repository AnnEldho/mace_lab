#!/bin/bash
echo "Enter a number: "
read num
if [ $((num%2)) -eq 0 ]
then
echo "$num is an even"
else 
echo "$num is an odd"
fi


