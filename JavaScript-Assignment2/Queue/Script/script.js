function Node(value){
	this.value=value;
	this.next=null;
}
function Queue(){
	this.head=null;
	this.length=0;
	this.enqueue=function(value){
		value=value.replace(/\s/g, '');
		value=value.trim();
		var node=new Node(value);
		if(value!=""){
			var presentNode=this.head;
			if(!presentNode){
				this.head=node;
				this.length++;
			}else{
				while(presentNode.next){
					presentNode=presentNode.next;
				}
				presentNode.next=node;
				this.length++;
			}
		}
		return this.head;
	}

	this.dequeue=function(){
		if(this.head){
			this.head=this.head.next;
		}
		return this.head;
	}

	this.printQueue=function(){
		document.getElementById("print").innerHTML="";
		if(!this.head){
			document.getElementById("print").innerHTML="Queue is empty.";
		}else{
			var currentNode=this.head;
			while(currentNode!=null){
				document.getElementById("print").innerHTML+=currentNode.value+"<div></div>";
				currentNode=currentNode.next;
			}
		}
	}
}
var list=new Queue();
function enqueue(){
	list.head=list.enqueue(document.getElementById("addValue").value);
	document.getElementById("addValue").value="";
	list.printQueue();
}
function dequeue(){
	list.head=list.dequeue();
	list.printQueue();
}
