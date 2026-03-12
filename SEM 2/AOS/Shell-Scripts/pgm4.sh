#!/bin/bash
echo "Enter two number"
read a b
if [ $a -gt $b ]
then 
echo "$a is greater"
else
echo "$b is greater"
fi
