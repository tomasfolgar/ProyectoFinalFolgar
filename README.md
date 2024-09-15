# ProyectoFinalFolgar
Con este programa/aplicación es posible almacenar los datos de clientes, ventas y productos en una base de datos.
Utilizando Postman podemos agregar datos y buscarlos por su id, además de modificar y eliminar cualquier dato ingresado previamente.

	 	 
		Clientes 
Agregar clientes

Método: POST
URL: /clientes/agregar
Acción: Agrega a la lista un cliente nuevo
datos a ingresar: nombre, apellido, dni.

Buscar clientes

Método: GET
URL: /clientes/buscar/{id}
Acción: Muestra los detalles de un cliente por su ID.

Eliminar clientes

Método: DELETE
URL: /clientes/eliminar/{id}
Acción: Elimina el cliente.

Modificar clientes

Método: PUT
URL: /clientes/modificar/{id}
Acción: Modifica los datos de un cliente.
datos a ingresar: nombre, apellido, dni.


	 	
		Productos 
Agregar productos

Método: POST
URL: /productos/agregar
Acción: Agrega a la lista un producto nuevo.
datos a ingresar: nombre_producto, precio, stock.

Buscar productos

Método: GET
URL: /productos/buscar/{id}
Acción: Muestra los detalles de un producto por su ID.

Eliminar productos

Método: DELETE
URL: /productos/eliminar/{id}
Acción: Elimina el producto.

Modificar un producto

Método: PUT
URL: /productos/modificar/{id}
Acción: Modifica los datos de un producto.
datos a ingresar: nombre_producto, precio, stock.


	 
		Ventas
Agregar ventas

Método: POST
URL: /ventas/agregar
Acción: Agrega a la lista una nueva venta.
datos a ingresar: id_cliente, monto, fecha (ejemplo: "2024-09-14").

Buscar ventas

Método: GET
URL: /ventas/buscar/{id}
Acción: Muestra los detalles de una venta por su ID.

Eliminar ventas

Método: DELETE
URL: /ventas/eliminar/{id}
Acción: Elimina la venta.

Modificar una venta

Método: PUT
URL: /ventas/modificar/{id}
Acción: Modifica los datos de una venta.
datos a ingresar: id_cliente, monto, fecha (ejemplo: "2024-09-14").
