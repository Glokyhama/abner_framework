'use strict';

// signup controller
app.controller('SignupFormController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.signup = function () {
        $scope.authError = null;
        $http({
            method: 'post',
            url: 'api/signup',
            data: {name: $scope.user.name, email: $scope.user.email, password: $scope.user.password},
        }).success(function (req) {
            $scope.authError = '注册成功';
            console.log(req);
        })
    };
}])
;