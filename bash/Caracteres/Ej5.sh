#!/bin/bash
echo "Introduce una ip"
read ip
caracteres=${#ip}
contador=0
for((i=0;i<$caracteres;i++)); do
caracter=${ip:$i:1}
if [ $caracter = "." ]; then
contador=$(($contador+1))
fi
done
if [ $contador -eq 3 ]; then
echo "La ip esta bien formada"
else
echo "La ip no esta bien formada"
fi