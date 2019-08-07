const { exec } = require('child_process');
const sensor = require('ds18b20-raspi');

function getData()
{
	const temp = sensor.readSimpleC(2);
	exec('date',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
	console.log('Temperature: '+temp+' degC');
//	console.log('\n');
}
console.log('Getting information ...');
setInterval(getData,500);
