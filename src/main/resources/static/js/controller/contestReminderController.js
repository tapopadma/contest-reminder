angular.module('contestReminderApp', []);
angular.module('contestReminderApp').controller('contestReminderController',
		($http, $scope) => {
		$scope.CLIENT_ID = "a9608cd52c8ffd08c2fea303e13090c0";
		$scope.CLIENT_SECRET = "95e9e52745e0f73a2b6f7e3187208c78";
		$scope.REDIRECT_URI = "http://localhost:8080";
		$scope.AUTH_SERVER_URL = "https://api.codechef.com/oauth/authorize";
		$scope.init = () => {
			$http(
			{
				method: 'GET',
				url: '/contest/getAll?authorizationCode='+$scope.getURLparam('code')
			}		
			).then((response)=>{
				if(response.status == 200){
					let message = response.data.status;
					if(message == 'OK')
						$scope.contestList = response.data.result.data.content.contestList;
					else{
						let auth_url = $scope.AUTH_SERVER_URL;
						auth_url += '?response_type=code';
						auth_url +=  '&client_id=' + $scope.CLIENT_ID;
						auth_url +=  '&state=xyz';
						auth_url +=  '&redirect_uri=' + $scope.REDIRECT_URI;
						location.href = auth_url;
					}
				}
			});
		};
		$scope.getURLparam = (name) => {
		   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
			  return decodeURIComponent(name[1]);
		   return '';
		};
});