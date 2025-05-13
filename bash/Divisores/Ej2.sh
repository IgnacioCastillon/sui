#!/bin/bash
echo "Elige un numero"
read numero
contador=0
for ((i=2;i<=$numero;i++)); do
resto=$(($numero%$i))
if [ $resto -eq 0 ]; then
contador=$(($contador+1))
fi
done
if [ $contador -eq 1 ]; then
echo "El numero $numero si es primo"
else
echo "El numero $numero no es primo"
fi