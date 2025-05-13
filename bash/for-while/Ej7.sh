#!/bin/bash
echo "Introduce la letra a"
read a
while [ $a != "a" ]; do
echo "Debes introducir a"
read a
done
if [ $a = "a" ]; then
echo "Que maquina eres"
fi