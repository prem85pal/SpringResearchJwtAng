var photosGallery = angular.module('photosGallery', ['ui.router']);

photosGallery.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'partials/home.html'
        })
        .state('photos', {
            url: '/photos',
            templateUrl: 'partials/photos.html'
        })
        .state('about', {
            url: '/about',
            templateUrl: 'partials/about.html'
        })
        .state('login', {
            url: '/login',
            templateUrl: 'partials/login.html'
        });

    $httpProvider.interceptors.push(['$q', '$location', '$localStorage', function ($q, $location, $localStorage) {
        return {
            'request': function (config) {
                config.headers = config.headers || {};
                if ($localStorage.token) {
                    config.headers.Authorization = 'Bearer ' + $localStorage.token;
                }
                return config;
            },
            'responseError': function (response) {
                if (response.status === 401 || response.status === 403) {
                    $location.path('/login');
                }
                return $q.reject(response);
            }
        };
    }]);
});

