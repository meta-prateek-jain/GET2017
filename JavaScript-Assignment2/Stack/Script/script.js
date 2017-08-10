function Node(value){
	this.value=value;
	this.next=null;
}
function Stack(){
	this.head=null;
	this.length=0;
	this.pushToStack=function(value){
		value=value.replace(/\s/g, '');
		value=value.trim();
		var node=new Node(value);
		if(value!=""){
			if(!this.head){
				this.head=node;
				this.length++;
			}else{
				node.next=this.head
				this.head=node;
				this.length++;
			}
		}
		return this.head;
	}

	this.popFromStack=function(){
		if(this.head){
			this.head=this.head.next;
		}
		return this.head;
	}

	this.printStack=function(){
		document.getElementById("print").innerHTML="";
		if(!this.head){
			document.getElementById("print").innerHTML="Stack is empty.";
		}else{
			var currentNode=this.head;
			while(currentNode!=null){
				document.getElementById("print").innerHTML+=currentNode.value+"<div></div>";
				currentNode=currentNode.next;
			}
		}
	}
}
var list=new Stack();
function push(){
	list.head=list.pushToStack(document.getElementById("addValue").value);
	document.getElementById("addValue").value="";
	list.printStack();
}
function pop(){
	list.head=list.popFromStack();
	list.printStack();
}