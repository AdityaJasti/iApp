//admin home controller
app.controller('ScoreBoardController', ['$rootScope', '$location', '$scope','$http','$sessionStorage','$window','ScoreBoardService',function($rootScope,$location,$scope,$http,$sessionStorage,$window,ScoreBoardService){

	//console.log("In ScoreBoardController");
	
	$scope.setWonByTeam = "";
	$scope.gameWonByTeam = "";
	
	
	$scope.numOfSetsWonByAlpha = 0;
	$scope.numOfSetsWonByEcho = 0;
	
	$scope.flagForSet = false;
	
	//Start
	$scope.setTopScore = 15;
	
	//END
	
	$scope.onPageLoadScoreBoard = function(){
		
		$(document).ready(function() {
			$("#scoreInputWell").hide();
			$("#setScoreDisplay").hide();
			$("#matchScoreReport").hide();
			
		});
		
		$scope.matchInfo = $sessionStorage.matchInfoData;
		
		//console.log("ONLOAD ScoreBoardController --- "+JSON.stringify($scope.matchInfo));
	}
	
	$scope.selectMatchFilter = function(){
		console.log($scope.selectedMatch);
		
		ScoreBoardService.getTeams($scope.selectedMatch).then(function(matchScheduleData){
			
			$scope.teamsDropDown = matchScheduleData.teams;
			$scope.tossCallOptions = matchScheduleData.tossCallOptions;
			
			//console.log(JSON.stringify(matchScheduleData));
			
		});
		
	}
	
	$scope.startGame = function(){
		
		//console.log($scope.selectedMatch+""+$scope.selectTossWinningTeam+""+$scope.selectTossWinningOption);
		
		ScoreBoardService.startGame($scope.selectedMatch,$scope.selectTossWinningTeam,$scope.selectTossWinningOption).then(function(matchDataFetched){
			console.log(JSON.stringify(matchDataFetched));
			
			$scope.teamsListForScoreInputAlpha = matchDataFetched.teamName[0];
			
			$scope.teamsListForScoreInputEcho = matchDataFetched.teamName[1];
			
			
			
			$scope.initialScoreForAlpha = matchDataFetched.initialScore;
			$scope.initialScoreForEcho =  matchDataFetched.initialScore;
			// set number
			$scope.setNumber = matchDataFetched.setNo;
			
			$scope.gameForSetsAndPointsMp = matchDataFetched.gameForSetsAndPoints;
			
			
			$scope.numOfSetsLength = Object.keys($scope.gameForSetsAndPointsMp).length;
			console.log($scope.numOfSetsLength+"map size");
			/*$scope.flagForSet = true;
			$scope.calculateSetNumber();*/
			
			
		});
		
		
		$("#scoreInputWell").show();
		$("#setScoreDisplay").show();
		/*$("#matchScoreReport").show();*/

		
		
		
	}
	
	//Alpha Fields Incre & Decre
	 $scope.alphaIncrement=function()
     	{
		 $scope.initialScoreForAlpha+=1;
		 $scope.calculateSetCompletionScore();

     	}
     $scope.alphaDecrement=function()
     	{
    	 $scope.initialScoreForAlpha-=1;

     	}
     
   //Echo Fields Incre & Decre
	 $scope.echoIncrement=function()
     	{
		 $scope.initialScoreForEcho+=1;
		 $scope.calculateSetCompletionScore();

     	}
     $scope.echoDecrement=function()
     	{
    	 $scope.initialScoreForEcho-=1;

     	}
     
     
     
     $scope.calculateSetNumber = function(){
    	 if ($scope.flagForSet) {
			   	for (var setNo in $scope.gameForSetsAndPointsMp) {
				    console.log('Key is: ' + setNo + '. Value is: ' + $scope.gameForSetsAndPointsMp[setNo]);
				    $scope.setNumber = setNo;
				    $scope.forScore = $scope.gameForSetsAndPointsMp[setNo];
			   	} 
		} else{
			
		}
    	 
    	 
     }
     
     
     $scope.calculateSetCompletionScore = function(){
    	 
    	 $scope.updateLiveData();
    	 
    	 
    	 if($scope.initialScoreForAlpha >= ($scope.setTopScore-2) && $scope.initialScoreForEcho >=($scope.setTopScore-2)){
    		 if(($scope.initialScoreForAlpha - $scope.initialScoreForEcho)== 2){
    			 $scope.setWonByTeam = $scope.teamsListForScoreInputAlpha;
    			 $scope.numOfSetsWonByAlpha++;
    			 
    			 $("#endSet").prop('disabled', false);
    		 }else if(($scope.initialScoreForEcho - $scope.initialScoreForAlpha)== 2){
    			 $scope.setWonByTeam = $scope.teamsListForScoreInputEcho;
    			 $scope.numOfSetsWonByEcho++;
    			 
    			 $("#endSet").prop('disabled', false);
    		 }else if(($scope.initialScoreForAlpha - $scope.initialScoreForEcho)== 1){
    			 console.log("Game point is for "+($scope.initialScoreForAlpha + 1));
    		 }else if(($scope.initialScoreForEcho - $scope.initialScoreForAlpha)== 1){
    			 console.log("Game point is for "+($scope.initialScoreForEcho + 1));
    		 }else if($scope.initialScoreForAlpha == $scope.initialScoreForEcho ){
	    		 console.log("Game point is for "+($scope.initialScoreForEcho + 2));
	    	 }
    	 }else{
    		 if($scope.initialScoreForAlpha == $scope.setTopScore){
    			 $scope.setWonByTeam = $scope.teamsListForScoreInputAlpha;
    			 $scope.numOfSetsWonByAlpha++;
    			
    			 $("#endSet").prop('disabled', false);
    		 }else if($scope.initialScoreForEcho == $scope.setTopScore){
    			 $scope.setWonByTeam = $scope.teamsListForScoreInputEcho;
    			 $scope.numOfSetsWonByEcho++;
    			
    			 $("#endSet").prop('disabled', false);
    		 }
    	 }
    	
    	
    	 
     }
     
     
     //End Set
     $scope.endSet = function(){
    	 $("#endSet").prop('disabled', true);
    	 console.log("Team "+$scope.teamsListForScoreInputAlpha+" scored "+$scope.initialScoreForAlpha);
    	 console.log("Team "+$scope.teamsListForScoreInputEcho+" scored "+$scope.initialScoreForEcho);
    	 console.log("Sets won by A"+$scope.numOfSetsWonByAlpha +" Sets won by B "+$scope.numOfSetsWonByEcho);
    	 
    	
		
		
		if(($scope.numOfSetsWonByAlpha) >($scope.numOfSetsLength/2) && ($scope.numOfSetsWonByAlpha+$scope.numOfSetsWonByEcho) <= $scope.numOfSetsLength){
   		 	console.log("Winning Team - > "+$scope.teamsListForScoreInputAlpha);
   		 	$scope.gameWonByTeam = $scope.teamsListForScoreInputAlpha;
   		 	$("#endSet").prop('disabled', true);
   		 	$("#endGame").prop('disabled', false);
	   	 }else if(($scope.numOfSetsWonByEcho) >($scope.numOfSetsLength/2) && ($scope.numOfSetsWonByAlpha+$scope.numOfSetsWonByEcho) <= $scope.numOfSetsLength){
	   		console.log("Winning Team - > "+$scope.teamsListForScoreInputAlpha);
   		 	$scope.gameWonByTeam = $scope.teamsListForScoreInputEcho;
	   		$("#endSet").prop('disabled', true);
	   		$("#endGame").prop('disabled', false);
	   	 }else{
	   		console.log("Sets are yet to be played");
	   		$scope.setNumber ++;
	   		$scope.initialScoreForAlpha = 0;
			$scope.initialScoreForEcho =  0;
	   	 }
    	 
     }
     
     $scope.updateLiveData = function(){
    	 //Write code to send live score on change / to back end java controller
    	 
    	 var liveScoreUpdate = {"setNumber": $scope.setNumber, "teamAlpha":$scope.teamsListForScoreInputAlpha, "teamEcho":$scope.teamsListForScoreInputEcho,
    			 "teamAlphaScore":$scope.initialScoreForAlpha, "teamEchoScore": $scope.initialScoreForEcho,
    			 "teamAlphaTimeOuts" : 0,"teamEchoTimeOuts":0,
    	 			"matchWonBy" : $scope.gameWonByTeam, "setsWonByAlpha":$scope.numOfSetsWonByAlpha, "setsWonByEcho":$scope.numOfSetsWonByEcho};
    	 console.log(JSON.stringify(liveScoreUpdate));
    	 
    	 
    	 
    	 ScoreBoardService.scoreLiveUpdate(liveScoreUpdate).then(function(liveUpdateResponse){
 			
 			console.log(JSON.stringify(liveUpdateResponse));
 			
 		});
    	 
    	 
     }
     
     //Calculate Game completion
     $scope.gameComplete =function(){
    	$scope.updateLiveData();
    	console.log("-----------END----------------");
     }
     
     
	
	
}]);