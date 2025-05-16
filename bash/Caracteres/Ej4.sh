#!/bin/bash
rand=$(($RANDOM% (26)+1))
contador=0
abc="abcdefghijklmnñopqrstuvwxyz"
ABC="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
letras=${#abc}
LETRAS=${#ABC}
letra=${abc:rand:1}
LETRA=${ABC:rand:1}
acertado=0
while [ $acertado -eq 0 ]; do
echo "Escribe una palabra con la letra $letra"
read palabra
letrasPalabra=${#palabra}
for((i=0;i<$letrasPalabra;i++)); do
letraPalabra=${palabra:$i:1}
if [ $letraPalabra = $letra ] || [ $letraPalabra = $LETRA ]; then
contador=1
fi
done
if [ $contador -eq 0 ]; then
echo "La palabra $palabra no contiene la letra $letra"
else
echo "La palabra $palabra si contiene la letra $letra"
acertado=1
fi
done