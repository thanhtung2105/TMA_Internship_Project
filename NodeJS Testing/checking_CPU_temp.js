const { exec } = require('child_process');

function getData()
{
	exec('date',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
//	exec('vcgencmd measure_temp',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
	console.log('');
}

console.log('Getting data from CPU ...');
setInterval(getData,1000);
