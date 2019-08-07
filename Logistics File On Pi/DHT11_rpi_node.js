const { exec } = require('child_process');
var rpiDhtSensor = require('rpi-dht-sensor');
var dht = new rpiDhtSensor.DHT11(2);
function read() {
	exec('date',(err,out)=>{if(err){console.error(err)}else{console.log(out)}});
	var readout=dht.read();
	console.log('Temperature: ' + readout.temperature.toFixed(2) + ' C, ' + 'humitidy: ' + readout.humidity.toFixed(2) + '%');
	console.log('at date/time: ');
//	setTimeout(read, 1000);
}
console.log('Getting information ...');
setInterval(read, 1000);
//read();
