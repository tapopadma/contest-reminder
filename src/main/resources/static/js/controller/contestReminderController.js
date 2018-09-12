angular.module('contestReminderApp', []);
angular.module('contestReminderApp').controller('contestReminderController',
		($http, $scope) => {
		$scope.CLIENT_ID = "a9608cd52c8ffd08c2fea303e13090c0";
		$scope.CLIENT_SECRET = "95e9e52745e0f73a2b6f7e3187208c78";
		$scope.REDIRECT_URI = "http://localhost:8080";
		$scope.AUTH_SERVER_URL = "https://api.codechef.com/oauth/authorize";
		$scope.AUTH_TOKEN_URL = "https://api.codechef.com/oauth/token";
		$scope.TRY_USING_REFRESH_TOKEN = false;
		$scope.offset = 0;
		$scope.limit = 10;
		$scope.onPrevClick = () => {
			let newOffset = $scope.offset - $scope.limit;
			if(newOffset >= 0){
				$scope.offset = newOffset;
				$scope.loadAllContests(
						window.localStorage.getItem('ACCESS_TOKEN'));
			}
		};
		$scope.onNextClick = () => {
			let newOffset = $scope.offset + $scope.limit;
			$scope.offset = newOffset;
			$scope.loadAllContests(
					window.localStorage.getItem('ACCESS_TOKEN'));
		};
		$scope.init = () => {
			let code = $scope.getURLparam('code');
			if(code.length === 0){
			    if(!window.localStorage.hasOwnProperty('AUTHORIZATION_CODE')){
			    	$scope.redirectToAuthorizationPage();
			    }
			    else{
			    	$scope.loadAllContests(
			    			window.localStorage.getItem('ACCESS_TOKEN'));
			    }
			}
			else{
				window.localStorage.setItem('AUTHORIZATION_CODE', code);
				$scope.redirectToMainPage(code);
			}
		};
		$scope.loadAllContests = (access_token) => {
			$http(
			{
				method: 'GET',
				url: '/contest/getAll?accessToken='
					+access_token+'&offset='+$scope.offset+'&limit='+$scope.limit
			}		
			).then((response)=>{
				let message = response.data.status;
				if(message == 'OK'){
					$scope.contestList = 
						response.data.result.data.content.contestList;
				}
			}, (error)=>{
				$scope.getUpdatedAccessToken();
			});
		};
		$scope.getUpdatedAccessToken = () => {
			let refreshToken = window.localStorage.getItem('REFRESH_TOKEN');
			$http({
				url : $scope.AUTH_TOKEN_URL,
				method : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					'grant_type' : 'refresh_token',
					'refresh_token' : refreshToken,
					'client_id' : $scope.CLIENT_ID,
					'client_secret' : $scope.CLIENT_SECRET
				}
			}).then((response) => {
					window.localStorage.setItem('ACCESS_TOKEN', 
							response.data.result.data.access_token);
					window.localStorage.setItem('REFRESH_TOKEN', 
							response.data.result.data.refresh_token);
					$scope.loadAllContests(response.data.result.data.access_token);
			}, (error) => {
					window.localStorage.removeItem('ACCESS_TOKEN');
					window.localStorage.removeItem('REFRESH_TOKEN');
					$scope.redirectToAuthorizationPage();
			});
		};
		$scope.redirectToMainPage = (authorizationCode) => {
			$http({
				url : $scope.AUTH_TOKEN_URL,
				method : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					'grant_type' : 'authorization_code',
					'code' : authorizationCode,
					'client_id' : $scope.CLIENT_ID,
					'client_secret' : $scope.CLIENT_SECRET,
					'redirect_uri' : $scope.REDIRECT_URI
				}
			}).then((response) => {
				window.localStorage.setItem('ACCESS_TOKEN', 
						response.data.result.data.access_token);
				window.localStorage.setItem('REFRESH_TOKEN', 
						response.data.result.data.refresh_token);
				window.location.href = "http://localhost:8080";
			},(error) => {
				$scope.redirectToAuthorizationPage();
			});
		};
		$scope.redirectToAuthorizationPage = () => {
			let auth_url = $scope.AUTH_SERVER_URL;
			auth_url += '?response_type=code';
			auth_url +=  '&client_id=' + $scope.CLIENT_ID;
			auth_url +=  '&state=xyz';
			auth_url +=  '&redirect_uri=' + $scope.REDIRECT_URI;
			location.href = auth_url;
		};
		$scope.getURLparam = (name) => {
		   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
			  return decodeURIComponent(name[1]);
		   return '';
		};
});