//Load packages for charts
google.charts.load('current', {	packages : [ 'corechart', 'line', 'gauge' ]});
google.charts.setOnLoadCallback(capacityFiles);
google.charts.setOnLoadCallback(capacityMountPoints);
google.charts.setOnLoadCallback(serverGauge);
google.charts.setOnLoadCallback(systemGraph);

/**
 * Chart for capacity files
 */

var tableSpaceGraph = new Array();
function capacityFiles() {
	// Define the chart to be drawn.
	console.log("Table Space Graph Data" + tableSpaceGraph);
	var capacityFilesdata = new google.visualization.arrayToDataTable(
			tableSpaceGraph, false);
	var capacityFilesOptions = {
		isStacked : 'percent',
		colors : [ '#ff0000', '#009900' ],

		hAxis : {
			textPosition : 'none'
		},
		vAxis : {
			gridlineColor : 'none',
		}

	};

	// Instantiate and draw the chart.
	var capacityFilesChart = new google.visualization.ColumnChart(document
			.getElementById('capacity_files_chart'));
	capacityFilesChart.draw(capacityFilesdata, capacityFilesOptions);
}
/**
 * End
 */

/**
 * Chart for capacity files
 */

var mountPointsGrph = new Array();
function capacityMountPoints() {
	// Define the chart to be drawn.
	console.log("Mount Point Graph Data" + tableSpaceGraph);
	var capacityMPdata = new google.visualization.arrayToDataTable(
			mountPointsGrph, false);
	var capacityMPOptions = {
		isStacked : 'percent',
		colors : [ '#ff0000', '#009900' ],

		hAxis : {
			textPosition : 'none'
		},
		vAxis : {
			gridlineColor : 'none',
		}

	};

	// Instantiate and draw the chart.
	var capacityMPChart = new google.visualization.ColumnChart(document
			.getElementById('mount_points_chart'));
	capacityMPChart.draw(capacityMPdata, capacityMPOptions);
}
/**
 * End
 */

/**
 * Server Gauge
 */

var serverMem;
var serverCPU;
function serverGauge() {
	
	

	var dataServerCPU = google.visualization.arrayToDataTable([[ 'Label', 'Value' ],[ 'Memory', 0 ], [ 'CPU', 0 ]]);

	var optionsServerCPU = {
			width : 600,
			height : 200,
			redFrom : 90,
			redTo : 100,
			yellowFrom : 75,
			yellowTo : 90,
			greenFrom : 0,
			greenTo :89,
			minorTicks : 10
		};
	
	var chartServer = new google.visualization.Gauge(document.getElementById('serverGauge'));
	
	dataServerCPU.setValue(0, 1, serverMem);
	dataServerCPU.setValue(1, 1, serverCPU);
	
	//chartServer.clearChart();
	
	chartServer.draw(dataServerCPU, optionsServerCPU);
	
}

/**
 * Database Gauge
 */
var databaseMem;
var databaseCPU;
function databaseGauge(){


	var databaseGauge = google.visualization.arrayToDataTable([[ 'Label', 'Value' ],[ 'Memory', 0 ], [ 'CPU', 0 ]]);

	var optionsDatabase = {
		width : 600,
		height : 200,
		redFrom : 90,
		redTo : 100,
		yellowFrom : 75,
		yellowTo : 90,
		greenFrom : 0,
		greenTo :89,
		minorTicks : 10
	};

	var chartDatabase = new google.visualization.Gauge(document.getElementById('databaseGauge'));
	
	databaseGauge.setValue(0, 1, databaseMem);
	databaseGauge.setValue(1, 1, databaseCPU);

	chartDatabase.draw(databaseGauge, optionsDatabase);

	/*setInterval(function() {
		databaseGauge.setValue(0, 1, 40 + Math.round(60 * Math.random()));
		chartDatabase.draw(databaseGauge, optionsDatabase);
	}, 13000);
	setInterval(function() {
		databaseGauge.setValue(1, 1, 40 + Math.round(60 * Math.random()));
		chartDatabase.draw(databaseGauge, optionsDatabase);
	}, 5000);*/
	
}

/**
 * System graph
 */
var systemParamGrph = new Array();
function systemGraph(){
	var data = new google.visualization.DataTable();
    data.addColumn('date', 'X');
    data.addColumn('number', 'CPU');
    data.addColumn('number', 'Memory');

    /*data.addRows([
      [new Date(2017,07,01,0,30), 0, 0],    [new Date(2017,07,02,1,0), 10, 97.76],
      [new Date(2017,07,03,3,30), 23, 15],  [new Date(2017,07,04,4,45), 17, 9],
      [new Date(2017,07,05,5,20), 18, 10],  [new Date(2017,07,06,6,0), 9, 5],
      [new Date(2017,07,07,7,45), 11, 3],   [new Date(2017,07,08,7,50), 27, 19],
      [new Date(2017,07,09,8,10), 33, 25],  [new Date(2017,07,10,8,54), 40, 32],  [new Date(2017,07,11,9,12), 32, 24], 
      [new Date(2017,07,12,10,0), 35, 27]
    ]);*/
    data.addRows(systemParamGrph);
    var options = {
      hAxis: {
        title: 'Time'
      },
      vAxis: {
        title: 'Usage'
      },
      colors: ['#a52714', '#097138'],
      'width':600,
      'height':350
    };

    var chart = new google.visualization.LineChart(document.getElementById('databaseGauge'));
    chart.draw(data, options);
}
