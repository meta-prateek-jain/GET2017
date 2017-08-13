var finalString;
function input(){
	var string=document.getElementById("inputString").value;
	document.getElementById("print").innerHTML="Input String: "+string;
	string=string.trim();
	if(string==""){
		document.getElementById("print").innerHTML="Please Enter the String";
	}else{
		var length=string.length;
		var loop=1;
		var temp;
		while(loop<length){
			if(string.charAt(loop)==string.charAt(loop-1)){
				temp=2;
				var count=loop+1;
				while((string.charAt(count)==string.charAt(count-1))&&count<length){
					temp++;
					count++;
				}
				var stringToRemove=string.substring(loop-1, temp+loop-1)
				string=string.replace(stringToRemove,"");
				loop=1;
				length-=temp;
			}else{
				loop++;
			}
		}
	}
	finalString=string;
	document.getElementById("inputString").value="";
	print();
}

function print(){
	var loop;
	document.getElementById("printString").innerHTML="Resultant String: ";
	if(finalString==""){
		document.getElementById("printString").innerHTML+="Empty";
	}else{
		for(loop=0; loop<finalString.length; loop++){
		document.getElementById("printString").innerHTML+=finalString.charAt(loop);
		}
	}
}