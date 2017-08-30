'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
        ['$rootScope', '$state', '$stateParams', '$cookies',
            function ($rootScope, $state, $stateParams, $cookies) {
                function message(to, toP, from, fromP) {
                    return from.name + angular.toJson(fromP) + " -> " + to.name + angular.toJson(toP);
                }

                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;

                //添加路由拦截
                $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
                    // 如果是登陆
                    if (toState.name == 'access.signin') return;

                    // 如果用户不存在
                    var user = $cookies.getObject('user');
                    if (!user) {

                        // // 取消默认跳转行为
                        // event.preventDefault();

                        // 跳转到登录界面
                        $state.go("access.signup");
                    }
                    else if (!localStorage.getItem('hasRouter')) {

                        // 跳转到登录界面
                        $state.go("app.dashboard-v1", {from: fromState.name, w: 'notLogin', user: user});
                    }
                });
                $rootScope.$on("$stateChangeSuccess", function (evt, to, toP, from, fromP) {
                    console.log("Success: " + message(to, toP, from, fromP));
                });
                $rootScope.$on("$stateChangeError", function (evt, to, toP, from, fromP, err) {
                    console.log("Error:   " + message(to, toP, from, fromP), err);
                });
            }
        ]
    )
    .config(
        ['$stateProvider', '$urlRouterProvider', 'JQ_CONFIG', 'MODULE_CONFIG',
            function ($stateProvider, $urlRouterProvider, JQ_CONFIG, MODULE_CONFIG) {

                var hasRouter = true;
                $urlRouterProvider
                    .otherwise(function ($injector, $location) {
                        $location.path('/access/signin');
                        hasRouter = false;
                    });
                localStorage.setItem('hasRouter', hasRouter);

                $stateProvider
                    .state('lockme', {
                        url: '/lockme',
                        templateUrl: 'tpl/access/lockme.html'
                    })
                    .state('access', {
                        url: '/access',
                        template: '<div ui-view class="fade-in-right-big smooth"></div>'
                    })
                    .state('access.signin', {
                        url: '/signin',
                        templateUrl: 'tpl/access/signin.html',
                        resolve: load(['js/controllers/signin.js'])
                    })
                    .state('access.signup', {
                        url: '/signup',
                        templateUrl: 'tpl/access/signup.html',
                        resolve: load(['js/controllers/signup.js'])
                    })
                    .state('access.forgotpwd', {
                        url: '/forgotpwd',
                        templateUrl: 'tpl/access/forgotpwd.html'
                    })
                    .state('access.404', {
                        url: '/404',
                        templateUrl: 'tpl/access/404.html'
                    });

                function load(srcs, callback) {
                    return {
                        deps: ['$ocLazyLoad', '$q',
                            function ($ocLazyLoad, $q) {
                                var deferred = $q.defer();
                                var promise = false;
                                srcs = angular.isArray(srcs) ? srcs : srcs.split(/\s+/);
                                if (!promise) {
                                    promise = deferred.promise;
                                }
                                angular.forEach(srcs, function (src) {
                                    promise = promise.then(function () {
                                        if (JQ_CONFIG[src]) {
                                            return $ocLazyLoad.load(JQ_CONFIG[src]);
                                        }
                                        angular.forEach(MODULE_CONFIG, function (module) {
                                            if (module.name == src) {
                                                name = module.name;
                                            } else {
                                                name = src;
                                            }
                                        });
                                        return $ocLazyLoad.load(name);
                                    });
                                });
                                deferred.resolve();
                                return callback ? promise.then(function () {
                                    return callback();
                                }) : promise;
                            }]
                    }
                }


            }
        ]
    );
