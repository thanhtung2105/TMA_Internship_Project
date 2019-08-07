var txt = require("fs");
var data = txt.readFileSync('test.txt');
//console.log(data.toString());

txt.readFile('test.txt', function (err, data) {
	if (err) return console.error(err);
	console.log(data.toString());
});

console.log("End of file");