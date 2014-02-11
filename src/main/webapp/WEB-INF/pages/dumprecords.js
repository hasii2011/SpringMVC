/**
 * 
 */
var myApp = angular.module('myApp', ["xeditable"]);

myApp.controller('DumpRecords', function($scope, $http) {

        $http.get('./runsummary/getAll').
        success(function(data) {
            $scope.runsummaries = data;
        }).
        error(function(data, status, headers, config) {
            window.alert(status);
        });

        $scope.checkName = function(data, id) {
            if (id === 2 && data !== 'awesome') {
              return "Username 2 should be `awesome`";
            }
          };
          
          $scope.checkCalories = function(data, id) {

              if ( isEmpty(data) ) {
                return "Can't be empty";
              }
            };
          $scope.checkSteps = function(data, id) {

              if ( isEmpty(data) ) {
                return "Can't be empty";
              }
            };
            $scope.saveRow = function (data,id) {

              //$scope.user not updated yet
                angular.extend(data, {id: id});
                //window.alert("Going to save: " + data.id + " " + data.calories);
                var runsummaries = $scope.runsummaries;
                for (var x = 0; x < runsummaries.length; x++) {

                    var rs = runsummaries[x];
                    if ( rs.id === data.id) {

                        rs.workoutName        = data.name;
                        rs.calories           = data.calories;
                        rs.workoutTime        = data.workoutTime;
                        rs.stepCounts.walkEnd = data.steps;
                        $http.post('./runsummary/updateSummary', rs).
                        error(function(data, status, headers, config) {
                            window.alert(status);
                        });
                    }
                }

            };
});

function isEmpty(value){
    return (typeof value === "undefined" || value === null);
}
//function DumpRecords($scope, $http) {
//
//    $http.get('./sportsdata/getAll').
//        success(function(data) {
//            $scope.sportsdata = data;
//        }).
//        error(function(data, status, headers, config) {
//            window.alert(status);
//        });
//}
