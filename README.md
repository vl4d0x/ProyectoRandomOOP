#### Proyecto: Camiones Don Erik
Es una aplicación de consola para agregar, eliminar y modificar autobuses, y lo mismo con los pasajeros para cada autobús.

Todos los registros de pasajeros (y autobuses, creando una columna) se harán dentro del _Dynamic Array_ casero xd.

También existirá otro array de Autobuses (Object), con información acerca de los autobuses.
Entonces, la información será guardada en dos lugares:
1. Un arreglo de Autobuses.
2. Una matriz de pasajeros (y técnicamente número de autobús, con base al número de autobús, podremos acceder a los pasajeros).

Tiene que tener un menú:
##### 1. Registro de autobús
 - Hay que registrar nuevos autobuses en un _Dynamic Array_ y en el array de autobuses.
- Un id para cada bus.
- Sin precios de 0 o negativos.
- Cada vez que se agregue un bus se creará un renglón en la matriz de pasajeros (_Dynamic Array_), es decir, cada bus tiene una matriz de Pasajeros (Objects), y que encaje con el id del autobus.

Esta sería la forma de la matriz de pasajeros, con una matriz dinámica dependiendo de la cantidad de autobuses (Agregar columnas) y cantidad maxima de pasajeros en un autobus (Agregar renglones).
- Tendrá que solicitar los datos necesarios para agregar un autobus 
A excepción de numAutobus (id), este será asignado automáticamente.


##### 2. Modificaciones de Precios por autobus
- El menú pedirá el número de autobús y se podrá modificar el precio de este.
- No precios negativos o 0

##### 3. Consulta de autobuses
- Imprimir tabla con la  información del doc (Atributos de la clase autobus, del array de autobuses)

##### 4. Registro de venta de boleto
- Solicitar datos del Pasajero (Nombre y apellidos)

- Mostrar asientos disponibles, y una vez ingresado el asiento verificar que esté disponible.
- La asignación debe de llevar un número de boleto con el pasajero, el cuál está compuesto por:
	- Número de autobus + Número de asiento elegido.
- Se agrega el objeto pasajero en la matriz de pasajeros.

##### 5. Consulta por número de autobús
- Solicitar el numero de autobús y mostrar la información de cada uno de los pasajeros.
- Mostrar el total de venta


##### Dynamic Array
Haremos uso de dos principales arrays, uno para los autobuses, y una matriz para los pasajeros, donde cada columna equivale a cada autobus.
