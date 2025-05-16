#!/bin/bash
echo "Introduce una ip"
read ip
caracteres=${#ip}
parte1=${ip:0:3}
parte2=${ip:4:3}
parte3=${ip:8:3}
parte4=${ip:12:3}
contador=0
for((i=0;i<$caracteres;i++)); do
caracter=${ip:$i:1}
if [ $caracter = "." ]; then
contador=$(($contador+1))
fi
done
if [ $contador -eq 3 ]; then
if [ $parte1 -gt -1 ] && [ $parte1 -lt 256 ] && [ $parte2 -gt -1 ] && [ $parte2 -lt 256 ] && [ $parte3 -gt -1 ] && [ $parte3 -lt 256 ] && [ $parte4 -gt -1 ] && [ $parte4 -lt 256 ]; then
if [ $parte1 -gt 0 ] && [ $parte1 -lt 128 ]; then
echo "La ip $ip es de clase A"
elif [ $parte1 -gt 127 ] && [ $parte1 -lt 192 ]; then
echo "La ip $ip es de clase B"
elif [ $parte1 -gt 191 ] && [ $parte1 -lt 224 ]; then
echo "La ip $ip es de clase C"
elif [ $parte1 -gt 223 ] && [ $parte1 -lt 240 ]; then
echo "La ip $ip es de clase D"
elif [ $parte1 -gt 239 ] && [ $parte1 -lt 256 ]; then
echo "La ip $ip es de clase E"
fi
else
echo "La ip no esta bien formada"
fi
else
echo "La ip no esta bien formada"
fi
