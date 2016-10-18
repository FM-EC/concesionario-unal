## Interoperabilidad
Rama para interoperar con creditos y mayoristas

## AutUNAL
Caso de Estudio: Los concesionarios automovilísticos realizan compras de automóviles a los mayoristas y posteriormente venden estos en sus establecimientos. Las ventas las pueden hacer directamente a los clientes o por intervención de una empresa de créditos quien le vende a los clientes. Es fundamental para este tipo de empresas tener registro de sus automóviles en existencias así como de las ventas realizadas.

## Tener en cuenta
1. el archivo concesionario.sql es el script de la base de datos
2. el archivo dummies.sql es un script para poblar la base de datos con datos dummies
3. Cambiar los datos para acceder a la base de datos (usuario, contraseña..) en glasfish-resourses.xml
4. si hay algún cambio en la base de datos, esta se debe borrar primero (DROP DATABASE `concesionario`;) luego se copia el nuevo script concesionario.sql, se ejecuta, y finalmente se copia el script dummies.sql y se ejecuta para poblar de nuevo la base de datos. luego en la capa dataAcces se debe volver a crear las clases (para esto se da click derecho create Entity clases from database y se agregan todas las entidades de nuevo).

## Contribuidores
* Monica Pineda
* Álvaro Rodriguez
* Carlos Gomez
* Fabián Monsalve
