var head;
var length;

function Node(value){
	this.value=value;
	this.next=null;
}
function SinglyLinkedList(){
	this.head=null;
	this.length=0;
	this.addValueToList=function(value){
		if(value){
			value=value.trim();
			var node=new Node(value);
			var presentNode=this.head;
			if(value!=""){
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
		}
			return this.head;
	}

	this.removeFromList=function(position){
		var presentNode=this.head;
		var loop=1;
		var pattern=/^[0-9]*$/;
		if(presentNode!=null && position){
			position=position.trim();
			if(position==""){
				document.getElementById("error").innerHTML="Please Enter the value";
			}
			else if(!pattern.test(position)){
				document.getElementById("error").innerHTML="Please Enter only integers greater then zero.";
			}
			else if(position>this.length){
				document.getElementById("error").innerHTML="Please enter the correct index value";
			}else{
				if(position==1){
					document.getElementById("error").innerHTML="Value at index "+position+" is removed";
					this.head=presentNode.next;
					this.length--;
				}else{
					while((loop+2)<position){
						presentNode=presentNode.next;
						loop++;			
					}
					document.getElementById("error").innerHTML="Value at index "+position+" is removed";
					var temp=presentNode.next;
					presentNode.next=temp.next;
					this.length--;
				}
			}
		}
		return this.head;
	}

	this.printList=function(){
		var presentNode=this.head;
		var loop=this.length;
		document.getElementById("print").innerHTML="";
		if(this.length==0){
			document.getElementById("print").innerHTML="Linked List is Empty.";
		}
		while(loop!=0){
			document.getElementById("print").innerHTML+=presentNode.value+" ";
			presentNode=presentNode.next;
			loop--;
		}
	}

	this.searchValuePosition=function(value){
		var presentNode=this.head;
		var position=1;
		if(presentNode!=null && value){
			value=value.trim();
			if(value==""){
				document.getElementById("error").innerHTML="Please Enter the value";
			}
			else if(presentNode.value==value){
				document.getElementById("error").innerHTML="The "+value+" is At "+position;
			}else{
				while(presentNode.value!=value){
					if(presentNode.next==null){
						position=0;
						break;
					}
					presentNode=presentNode.next;
					position++;
				}
				if(position==0){
					document.getElementById("error").innerHTML="The value is Not Found."
				}else{
					document.getElementById("error").innerHTML="The "+value+" is At "+position;
				}
			}
		}
	}
}

var LinkedList=new SinglyLinkedList();
function addValue(){
	document.getElementById("error").innerHTML="";
	LinkedList.head=LinkedList.addValueToList(document.getElementById("input").value);
	document.getElementById("input").value="";
	LinkedList.printList();
}
function removeValue(){
	LinkedList.head=LinkedList.removeFromList(document.getElementById("input").value);
	LinkedList.printList();
	document.getElementById("input").value="";
}
function searchValue(){
	LinkedList.searchValuePosition(document.getElementById("input").value);
	document.getElementById("input").value="";
	LinkedList.printList();
}