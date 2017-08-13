function timedCount() {
	setInterval(function(){
	postMessage(new Date());
	},30000);
}
timedCount();