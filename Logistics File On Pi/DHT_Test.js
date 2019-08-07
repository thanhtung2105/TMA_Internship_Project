var sensor = require("node-dht-sensor").promises;

// You can use `initialize` and `setMaxTries` just like before
sensor.setMaxRetries(10);
sensor.initialize(22, 17);

// You can still use the synchronous version of `read`:
// var readout = sensor.readSync(22, 4);

sensor.read(22, 17).then(
  function(res) {
    console.log(
     'temp: ${res.temperature.toFixed(1)}°C, ' +
        'humidity: ${res.humidity.toFixed(1)}%'
    );
  },
  function(err) {
    console.error("Failed to read sensor data:", err);
  }
);
