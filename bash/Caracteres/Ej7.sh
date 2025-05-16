#!/bin/bash
echo "Introduce un numero binario:"
read binario
caracteres=${#binario}
valor=1
error=0
suma=0
for((i=0;i<$caracteres;i++)); do
caracter=${binario:$i:1}
if [ $caracter -gt 1 ] || [ $caracter -lt 0 ]; then
error=1
fi
done
if [ $error -eq 1 ]; then
echo "Esto no es un numero binario"
else
if [ $caracteres -gt 3 ]; then
for((j=$caracteres;j>0;j--)); do
salta=$(($j-1))
caracter2=${binario:$salta:1}
echo "$caracter2,$caracteres"
if [ $caracter2 -eq 0 ]; then
valor=$(($valor*2))
elif [ $caracter2 -eq 1 ]; then
suma=$(($suma+($valor)))
valor=$(($valor*2))
fi
done

echo "$binario en decimal es $suma"
else 
echo "Esto no es un numero binario"
fi
fi