const sensor = require('ds18b20-raspi');
 
const tempC2 = sensor.readSimpleC(2);
console.log('Temperature: ' + tempC2 + ' degC');
