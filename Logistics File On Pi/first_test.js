var temp;
var datetime;

function outputTemp()
{
	temp=35;
	console.log('Temperature: ',temp);
}

function dateTime()
{
	datetime='23:41:21 Aug 1st 2019';
	console.log(datetime);
}

setInterval(outputTemp,3000);
setInterval(dateTime,3000);

