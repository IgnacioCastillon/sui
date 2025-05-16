#!/bin/bash
echo "Escribe una vocal"
read vocal
while [ $vocal != "a" ] && [ $vocal != "e" ] && [ $vocal != "i" ] && [ $vocal != "o" ] && [ $vocal != "u" ]; do
echo "Debes introducir una vocal"
read vocal
done
intentos=0
rand=$(($RANDOM% (150-50)+50))
echo $rand
solucionado=0
while [ $solucionado -lt 1 ]; do
intentos=$(($intentos+1))
echo "Intenta adivinar el numero aleatorio entre el 50 y el 150"
read numero
while [ $numero -lt 50 ] || [ $numero -gt 150 ]; do
echo "El numero debe estar entre el 50 y el 150 incluidos"
read numero
done
if [ $numero -eq $rand ]; then
echo "Lo has acertado en $intentos intentos"
solucionado=1
break
elif [ $numero -lt $rand ]; then
echo "El numero elegido es menor al buscado"
diferencia=$(($rand-$numero))
elif [ $numero -gt $rand ]; then
echo "El numero elegido es mayor al buscado"
diferencia=$(($numero-$rand))
fi
echo $diferencia
if [ $diferencia -gt 50 ]; then
echo "Estas muy lejos"
elif [ $diferencia -gt 24 ] && [ $diferencia -lt 51 ]; then
echo "Estas lejos"
elif [ $diferencia -gt 9 ] && [ $diferencia -lt 25 ]; then
echo "Estas cerca"
elif [ $diferencia -lt 10 ]; then
echo "Estas muy cerca"
fi
done