#!/bin/bash
contador=0
for ((numero=2;numero<100;numero++)); do
if [ $contador -lt 10 ]; then
contador2=0
for ((divisor=2;divisor<=$numero;divisor++)); do
resto=$(($numero%$divisor))
if [ $resto -eq 0 ]; then
contador2=$(($contador2+1))
fi
done
if [ $contador2 -eq 1 ]; then
contador=$(($contador+1))
echo $numero
fi
fi
done