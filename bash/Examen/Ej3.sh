#!/bin/bash
for ((i=1;i<=50;i++)); do
touch $i".txt"
done
echo "Deseas almacenar los datos en Raid 0 o en Raid 1"
read raid
echo "Elige el numero de discos"
read discos
contador=1
contador2=1
contador3=0
if [ $raid -eq 1 ]; then
for ((i=1;i<=$discos;i++)); do
mkdir $i
for ((j=1;j<=50;j++)); do
cp ./$j".txt" ./$i
done
done
for ((j=1;j<=50;j++)); do
rm $j".txt"
done
elif [ $raid -eq 0 ]; then
for ((i=1;i<=$discos;i++)); do
mkdir $i
done
contador=1
archivos=50
while [ $archivos -gt 0 ]; do
for ((i=1;i<=$discos;i++)); do
if [ $contador -lt 51 ]; then
mv $contador".txt" ./$i
diferencia=$discos
contador=$(($contador+1))
archivos=$(($archivos-1))
fi
done
done
fi