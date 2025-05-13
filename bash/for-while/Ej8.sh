#!/bin/bash
echo "Intenta adivinar el numero"
rand=$(($RANDOM% (99)+1))
echo $rand
for ((oportunidades=9;oportunidades>=0;oportunidades--)); do
read numero
if [ $numero -eq $rand ]; then
echo "Has acertado"
intentos=$((10-$oportunidades))
echo "Has necesitado $intentos intentos"
oportunidades=-2
else
echo "Has fallado"
echo "Intentos restantes: $oportunidades"
fi
done
if [ $oportunidades -eq -1 ]; then
echo "El numero secreto era el $rand"
fi