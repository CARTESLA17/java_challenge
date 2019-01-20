//se genera el modulo de la vista index.html
var app = angular.module('titularesCuentasCorrientes', ["ngResource"]);

//se asiga el controlador a la vista.
app.controller('ControladorTitularesCuentasCorrientes', [ '$scope', '$http','$window',
                                     
	function($scope, $http, $window) {	
	
		$scope.personaFisica = true;
		$scope.personaJuridica = true;
		$scope.esconder = true;
		
		$scope.activarElementosDeLaVista=function() {
			if( $scope.tipoPersona!=null && $scope.tipoPersona.id==1 ){
				$scope.personaFisica = false;
				$scope.personaJuridica = true;
			}else if ($scope.tipoPersona!=null && $scope.tipoPersona.id==2){
				$scope.personaFisica = true;
				$scope.personaJuridica = false;
			}else {
				$scope.personaFisica = true;
				$scope.personaJuridica = true;
			}
		}

		$scope.obtenerTiposDePersona=function() {
			$http.get('tipoDePersona/obtenerTiposDePersona').success(function(data) {
				$scope.tipoPersonas=data;				
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});
		}
		
		$scope.crearTitular = function() {
			if( $scope.tipoPersona!=null && $scope.tipoPersona.id==1 ){				
				$http({
					method : 'POST',
					url : 'titular/almacenarTitular',
					data: JSON.stringify( {							
							tipoPersona: $scope.tipoPersona.id,
							nombre: $scope.nombre,
							apellido: $scope.apellido,
							dni: $scope.DNI,
							razonSocial: "",
							year: "",
							cuit: $scope.CUIT
					})
				}).success(function(data) {				
					if(data==="true"){
						$scope.limpiarDatos();
						alert("Titular almacenado con exito!");
					}else{
						alert("ERROR AL GUARDAR TITULAR");
					}							
				}).error(function(data) {
					$scope.msgBusUP = 'ERROR';
				});
			}else if ($scope.tipoPersona!=null && $scope.tipoPersona.id==2){
				$http({
					method : 'POST',
					url : 'titular/almacenarTitular',
					data: JSON.stringify( {							
							tipoPersona: $scope.tipoPersona.id,
							nombre: "",
							apellido: "",
							dni: "",
							razonSocial: $scope.razonSocial,
							year: $scope.year,	
							cuit: $scope.CUIT
					})
				}).success(function(data) {	
					if(data==="true"){
						$scope.limpiarDatos();
						alert("Titular almacenado con exito!");
					}else{
						alert("ERROR AL GUARDAR TITULAR");
					}										
				}).error(function(data) {
					$scope.msgBusUP = 'ERROR';
				});
			}	
		}
		
		$scope.limpiarDatos = function() {
				$scope.nombre = "";
				$scope.apellido = "";
				$scope.DNI = "";
				$scope.razonSocial = "";
				$scope.year = "";
				$scope.CUIT = "";
				$scope.esconder = true;
				$scope.titular="";
		}
		
		$scope.actualizarTitular = function() {
			$http({
				method : 'POST',
				url : 'titular/actualizarTitular',
				data: JSON.stringify( {
					id:$scope.titular.id,
					tipoPersona: $scope.tipoPersona.id,
					nombre: $scope.nombre,
					apellido: $scope.apellido,
					dni: $scope.DNI,
					razonSocial: $scope.razonSocial,
					year: $scope.year,
					cuit: $scope.CUIT,
					version: $scope.titular.version
				})		    
			}).success(function(data) {				
				if(data==="true"){
					$scope.limpiarDatos();
					alert("Titular actualizado con exito!");
				}else{
					alert("ERROR AL Actualizar TITULAR");
				}						
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});
		}
		
		$scope.eliminarTitular = function() {
			$http({
				method : 'POST',
				url : 'titular/eliminarTitularPorId',
				data: JSON.stringify( {
					id: $scope.titular.id				
				})		    
			}).success(function(data) {				
				if(data==="true"){
					$scope.limpiarDatos();
					alert("Titular eliminado con exito!");
				}else{
					alert("ERROR AL ELIMINAR TITULAR");
				}						
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});
		}		
		
		$scope.listarTitulares = function() {
			 $window.location.href = 'http://localhost:8080/api/listaDeTitulares.html';
		}
		
		$scope.obtenerTitularPorCuit = function() {
			$http({
				method : 'POST',
				url : 'titular/obtenerTitularPorCuit',
				data: JSON.stringify( {							
						cuit: $scope.buscarCUIT					
				})
			}).success(function(data) {
				if(data!=null){
					$scope.titular=data;
					var tipoPersona = new Object();
					if(data.tipoPersona===1){
						tipoPersona.id=1;
						tipoPersona.descripcion="Fisica";
					}else if(data.tipoPersona===2){
						tipoPersona.id=2;
						tipoPersona.descripcion="Juridica";
					}
					$scope.tipoPersona=tipoPersona;
					$scope.nombre=data.nombre;
					$scope.apellido=data.apellido;
					$scope.DNI=data.dni;
					$scope.razonSocial = data.razonSocial;
					$scope.year = data.year;
					$scope.CUIT = data.cuit;
					$scope.activarElementosDeLaVista();
					$scope.esconder = false;
				}else{
					alert("El titular requerido no se encuentra en el sistema!");
				}
			}).error(function(data) {
				alert("El titular requerido no se encuentra en el sistema!");
			});
		}
	
} ]);

