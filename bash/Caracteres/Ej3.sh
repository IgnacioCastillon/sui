#!/bin/bash
echo "Introduce un numero binario"
read binario
numeros=${#binario}
contador=0
for((i=0;i<$numeros;i++)); do
numero=${binario:$i:1}
if [ $numero -eq 1 ] || [ $numero -eq 0 ]; then
contador=$(($contador+1))
fi
done
if [ $numeros -gt 3 ]; then
if [ $contador -eq $numeros ]; then
echo "Si es un numero binario"
else
echo "No es un numero binario"
fi
else
echo "No es un numero binario"
fi