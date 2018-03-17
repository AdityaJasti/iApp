app.service("ScoreBoardService", function($http, $q) {
	return ({
		getTeams : getTeams,
		startGame : startGame,
		scoreLiveUpdate : scoreLiveUpdate
	});
	
	// error handling function
	function handleError(response) {
		if (!angular.isObject(response.data) || !response.data.message) {
			return ($q.reject("An unknown error occurred."));
		}
		//return ($q.reject(response.data.message));
		return (response.data);
	}
	//success handling function
	function handleSuccess(response) {
		return (response.data);
	}
	
	//Load Technologies Match filters and teams data
	function getTeams(matchID){
		var request = $http({
			method : "get",
			url : "Match/TeamsData",
			async: true,
            cache: false,
			params: {
				matchID: matchID
			}
		});
		return (request.then(handleSuccess, handleError));
	}
	
	//Start the match - get the No of sets and each set points
	function startGame(matchID,tossWinningTeam,TossWinningOption){
		var request = $http({
			method : "get",
			url : "Match/StartGame",
			async: true,
            cache: false,
			params: {
				matchID: matchID,
				tossWinningTeam : tossWinningTeam,
				TossWinningOption : TossWinningOption
			}
		});
		return (request.then(handleSuccess, handleError));
	}
	
	//Live Score Update function
	function scoreLiveUpdate(liveScoreUpdate){
		var request = $http({
			method : "post",
			url : "Match/LiveUpdate",
			async: true,
            cache: false,
            data : JSON.stringify(liveScoreUpdate)
		});
		return (request.then(handleSuccess, handleError));
	}
	
	
	
	
});