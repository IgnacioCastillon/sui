#!/bin/bash
echo "Introduce el rango menor"
read menor
echo "Introduce el rango mayor"
read mayor
for ((mayor;mayor>=menor;mayor--)); do
echo $mayor
done