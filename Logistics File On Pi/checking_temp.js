const { exec } = require('child_process');
function getData()
{
	exec('date',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
	exec('sudo python Seeed_AMG8833.py',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
	console.log('\n');
}
console.log('Getting information ...');
setInterval(getData,3000);
