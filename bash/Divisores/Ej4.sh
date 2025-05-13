#!/bin/bash
echo "Numeros con 3 divisores entre el 100 y el 200"
for ((numero=100;numero<=200;numero++)); do
divisores=0
for ((divisor=2;divisor<=$numero;divisor++)); do
resto=$(($numero%$divisor))
if [ $resto -eq 0 ]; then
divisores=$(($divisores+1))
fi
done
if [ $divisores -eq 2 ]; then
echo $numero
fi
done