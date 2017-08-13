var w;
function timeElapsed(){
    var second=0;
    var minute=0;
    var current = new Date();
    setTimeout("timeElapsed()", 31000);
    document.getElementById('current').innerHTML = current;
    document.getElementById("elapsed").innerHTML = "";
}
function startWorker() {
    timeElapsed();
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("Script/backside_worker.js");
        }
        w.onmessage = function(event) {
            document.getElementById("elapsed").innerHTML = event.data;
        };
    } else {
        document.getElementById("elapsed").innerHTML = "Sorry, your browser does not support Web Workers...";
    }
}
