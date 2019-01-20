## Notas para probar la solucion al ejercicio 1:
   
   - Se debe contar con acceso a interner para que el front pueda encontrar las librerias de angular.js para que pueda funcionar bien.
   - Las urls del front end de las funcionalidades del ejercicio 1 son:
   
		http://localhost:8080/api/crudTitulares.html
		
		http://localhost:8080/api/listaDeTitulares.html
   

## Probando controllers del ejercicio 2:

	#### Almacenar cuenta:
	moneda PESOS = 1
	moneda DOLARES = 2
	moneda EUROS = 3 
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"moneda\": 1,\"saldo\": 44.446,\"titular\": 4}" http://localhost:8080/api/cuenta/almacenarCuenta
	
	#### Obteniendo todas las cuentas:
	
	curl -X GET "http://localhost:8080/api/cuenta/obtenerTodasLasCuentas"
	
	#### Almacenanando movimientos:
	tipoMovimiento DEBITO = 1
	tipoMovimiento CREDITO = 2
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe credito\", \"importe\":2.3333, \"cuenta\": 1, \"tipoMovimiento\":2}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe credito\", \"importe\":32.5, \"cuenta\": 2, \"tipoMovimiento\":2}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe credito\", \"importe\":44.446, \"cuenta\": 3, \"tipoMovimiento\":2}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito uno\", \"importe\":12.33, \"cuenta\": 1, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito uno\", \"importe\":377.5, \"cuenta\": 2, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito uno\", \"importe\":244.45, \"cuenta\": 3, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito dos\", \"importe\":1001, \"cuenta\": 1, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito dos\", \"importe\":301, \"cuenta\": 2, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito dos\", \"importe\":151, \"cuenta\": 3, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito tres\", \"importe\":1000, \"cuenta\": 1, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito tres\", \"importe\":300, \"cuenta\": 2, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"descripcion\": \"importe debito tres\", \"importe\":150, \"cuenta\": 3, \"tipoMovimiento\":1}" http://localhost:8080/api/movimiento/almacenarMovimiento
	
	#### Obtener movimientos por cuenta:
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"cuenta\": 1}" http://localhost:8080/api/movimiento/obtenerMovimientosPorCuenta
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"cuenta\": 2}" http://localhost:8080/api/movimiento/obtenerMovimientosPorCuenta
	
	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"cuenta\": 3}" http://localhost:8080/api/movimiento/obtenerMovimientosPorCuenta
	
	#### Eliminando cuenta por id:
	NOTA: Esta sentencia se deden de ejecutar de ultimo, ya que si se elimina la cuenta dos, fallarian algunas sentencias de arriba.

	curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"id\": 2}" http://localhost:8080/api/cuenta/eliminarCuentaPorId
	
	
	
	
	
	
