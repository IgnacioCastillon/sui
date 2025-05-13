#!/bin/bash
echo "Numeros pares menores a 20"
contador=19
while [ $contador -ne 0 ]; do
pares=$(($contador%2))
if [ $pares -eq 0 ]; then
echo $contador
fi
contador=$(($contador-1))
done