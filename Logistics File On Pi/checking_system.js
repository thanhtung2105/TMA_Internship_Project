const si = require('systeminformation');
 
si.cpu()
    .then(data => {
        console.log('CPU Information:');
        console.log('- manufucturer: ' + data.manufacturer);
        console.log('- brand: ' + data.brand);
        console.log('- speed: ' + data.speed);
        console.log('- cores: ' + data.cores);
        console.log('- physical cores: ' + data.physicalCores);
        console.log('...');
    })
    .catch(error => console.error(error));
