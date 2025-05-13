#!/bin/bash
echo "Elige un numero:"
read numero
contador=1
while [ $contador -lt 11 ]; do
echo $(($numero+$contador))
contador=$(($contador+1))
done