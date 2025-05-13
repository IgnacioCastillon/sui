#!/bin/bash
echo "Elige el numero de divisores que debe tener el numero"
read divisores
contador=0
for ((numero=1;numero<=100;numero++)); do
divisorescont=0
if [ $contador -lt 1 ]; then
for ((divisor=1;divisor<=$numero;divisor++)); do
resto=$(($numero%$divisor))
if [ $resto -eq 0 ]; then
divisorescont=$(($divisorescont+1))
fi
done
if [ $divisorescont -eq $divisores ]; then
contador=$(($contador+1))
echo "El primer numero con $divisores divisores es $numero"
fi
fi
done