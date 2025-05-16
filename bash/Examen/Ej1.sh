#!/bin/bash

areaTotal=-1
while [ $areaTotal -lt 0 ]; do
echo "Base del rectangulo:"
read baseRec
echo "Altura del rectangulo:"
read alturaRec
areaRectangulo=$(($baseRec*$alturaRec))
echo "Lado pentagono:"
read ladoPent
echo "Apotema pentagono:"
read apotemaPent
areaPentagono=$((($ladoPent*5*$apotemaPent)/2))
rand=$(($RANDOM% (3)+0))
if [ $rand -eq 0 ]; then
echo "La figura de la derecha es un cuadrado. Cuanto mide el lado:"
figura="cuadrado"
read lado
areaFigAl=$(($lado*$lado))
elif [ $rand -eq 1 ]; then
echo "La figura de la derecha es un triangulo rectangulo."
figura="triangulo rectangulo"
echo "Dime la base"
read base
echo "Dime la altura"
read altura
areaFigAl=$((($base*$altura)/2))
elif [ $rand -eq 2 ]; then
echo "La figura de la derecha es un circulo."
figura="circulo"
echo "Dime el radio"
read radio
areaFigAl=$(($radio*$radio*3))
fi
areaTotal=$(($areaRectangulo-($areaPentagono+$areaFigAl)))
echo "El area del pentagono es de $areaPentagono"
echo "El area del $figura es de $areaFigAl"
echo "El area total es de $areaTotal"
if [ $areaTotal -lt 0 ]; then
echo "El area total no puede ser negativa"
fi
done