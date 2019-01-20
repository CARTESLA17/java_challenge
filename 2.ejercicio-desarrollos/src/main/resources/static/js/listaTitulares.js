//se genera el modulo de la vista index.html
var app = angular.module('listaTitulares', ["ngResource"]);

//se asiga el controlador a la vista.
app.controller('ControladorListaTitulares', [ '$scope', '$http', '$window',
                                     
	function($scope, $http, $window) {	

		$scope.obtenerTodosLosTitulares = function() {
			$http.get('titular/obtenerTodosLosTitulares').success(function(data) {
				$scope.listaTitulares=data;				
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});
		}		
		
		$scope.irACRUDDeTitualres = function() {
			 $window.location.href = 'http://localhost:8080/api/crudTitulares.html';
		}
	
} ]);

