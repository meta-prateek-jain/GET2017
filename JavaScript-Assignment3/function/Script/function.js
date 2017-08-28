function sum(number1,number2){
	var result = function (number2){
    			return number1+number2;
    		};
    if(typeof number2 =='undefined'){
        return result;
    }else{
        return result(number2);
    }
}

function sumValue(){
	var input1=document.getElementById("input1").value.trim();
	var input2=document.getElementById("input2").value.trim();
	var input1 = input1.replace(/\s/g, '');
	var input2 = input2.replace(/\s/g, '');
	if(input1==""||input2==""){
		document.getElementById("print").innerHTML="Enter the values";	
	}else if(isNaN(Number(input1))||isNaN(Number(input2))){
		document.getElementById("print").innerHTML="Please enter only Integer Values";
	}else{
		document.getElementById("print").innerHTML="Result of sum("+input1+", "+input2+") is "+sum(Number(input1), Number(input2));
	}
	document.getElementById("input1").value="";
	document.getElementById("input2").value="";
}

function sumValue1(){
	var input1=document.getElementById("input1").value.trim();
	var input2=document.getElementById("input2").value.trim();
	var input1 = input1.replace(/\s/g, '');
	var input2 = input2.replace(/\s/g, '');
	if(input1==""||input2==""){
		document.getElementById("print").innerHTML="Enter the values";	
	}else if(isNaN(Number(input1))||isNaN(Number(input2))){
		document.getElementById("print").innerHTML="Please enter only Integer Values";
	}else{
		document.getElementById("print").innerHTML="Result of sum("+input1+")("+input2+") is "+sum(Number(input1))(Number(input2));
	}
	document.getElementById("input1").value="";
	document.getElementById("input2").value="";
}