#!/bin/bash
echo "Escribe una palabra:"
read palabra
letras=${#palabra}
contador=0
for((i=0;i<$letras;i++)); do
letra=${palabra:$i:1}
if [ $letra = "a" ]; then
contador=1
fi
done
if [ $contador = 1 ]; then
echo "La palabra $palabra si contiene la letra a"
else
echo "La palabra $palabra no contiene la letra a"
fi