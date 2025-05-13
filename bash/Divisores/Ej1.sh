#!/bin/bash
echo "Elige un numero"
read numero
contador=0
for ((i=1;i<10;i++)); do
resto=$(($numero%$i))
if [ $resto -eq 0 ]; then
contador=$(($contador+1))
fi
done
echo "El numero $numero tiene $contador divisores"