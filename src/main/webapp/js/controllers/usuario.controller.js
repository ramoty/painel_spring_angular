angular.module('App.Usuarios', [])
.controller('UsuarioController', function($scope, $http){
    
    $scope.usuarios = [];
    
    $scope.salvar = function(){
        $http.post('/api/usuarios/', $scope.usuario)
        .then(function sucesso(response){
            window.alert("Usuário cadastrado com sucesso");
            $scope.usuario = {};
        }, function falha(response){
            window.alert("Falha ao cadastrar usuário");
            console.log("Erro ao cadastrar usuários :" + response.data);
        })
    }
    
    $scope.editar = function(index){
        $scope.usuario = $scope.usuarios[index];
    }
    
    $scope.remover = function(index){
        if(window.confirm("Tem certeze que quer remover este usuário?")){
            $http.delete('/api/usuarios/' + $scope.usuarios[index].id)
            .then(function sucesso(response){
                window.alert("Usuário removido com sucesso");
            }, function falha(response){
                window.alert("Falha ao remover usuário");
                console.log("Erro ao remover usuários :" + response.data);
            })
        }
    }
    
    $scope.cancelar = function(){
        $scope.usuario = {};
    }
    
    $scope.buscarTodos = function(){
        $http.get('/api/usuarios/')
        .then(function sucesso(response){
            $scope.usuarios = response.data;
        }, function falha(response){
            console.log("Erro ao buscar todos os usuários :" + response.data);
        });
    }
    
    $scope.buscarTodos();
    
});