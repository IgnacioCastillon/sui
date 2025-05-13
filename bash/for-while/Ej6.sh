#!/bin/bash
echo "Elige un numero"
read numero
for ((i=1;i<numero;i++)); do
resto=$(($i%3))
if [ $resto -eq 0 ]; then
echo $i
fi
done