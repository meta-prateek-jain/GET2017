function goTo(){
					document.getElementById("home").href="webpage.html";
					document.getElementById("contact").href="contact.html";
			}
			function validateForm(){
				var flag=true;
				if(!validateName()){
					flag=false;
				}
				if(!validateMessage()){
					flag=false;	
				}
				if(!validateContact()){
					flag=false;
				}
				if(!validateEmail()){
					flag=false;
				}
				if(!validateOrganization()){
					flag=false;
				}
				if(!validateSelect()){
					flag=false;
				}
				return flag;
			}
			function validateName(){
				var name=document.forms["contactForm"]["name"].value;
				var namePattern=/^[A-Za-z]+$/;
				if(name.length<1){
					document.getElementById("errorName").innerHTML="Enter the name.";
					document.getElementById('name').style.borderColor="red";
					document.getElementById("errorName").style.display="block";
					document.getElementById("errorName").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorName").style.padding="0px 0% 0px 209px";
					document.getElementById("errorName").style.width="100%";
					document.getElementById("errorName").style.color="red";
					return false;
				}else if(!namePattern.test(name)){
					document.getElementById("errorName").innerHTML="Enter only characters";
					document.getElementById("errorName").style.display="block";
					document.getElementById('name').style.borderColor="red";
					document.getElementById("errorName").style.color="red";
					document.getElementById("errorName").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorName").style.padding="0px 0% 0px 209px";
					document.getElementById("errorName").style.width="100%";
					return false;
				}else if(name.length>20){
					document.getElementById("errorName").innerHTML="The length should be less than 20.";
					document.getElementById('name').style.borderColor="red";
					document.getElementById("errorName").style.display="block";
					document.getElementById("errorName").style.color="red";
					document.getElementById("errorName").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorName").style.padding="0px 0% 0px 209px";
					document.getElementById("errorName").style.width="100%";
					return false;
				}else{
					document.getElementById("errorName").innerHTML="";
					document.getElementById('name').style.borderColor="teal";
					document.getElementById("errorName").style.display="none";
					return true;
				}
			}
			function validateEmail(){
				var email=document.forms["contactForm"]["email"].value;
				var emailPattern=/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
				if(email.length<1){
					document.getElementById("errorEmail").innerHTML="Enter the email.";
					document.getElementById('email').style.borderColor="red";
					document.getElementById("errorEmail").style.display="block";
					document.getElementById("errorEmail").style.color="red";
					document.getElementById("errorEmail").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorEmail").style.padding="0px 0% 0px 209px";
					document.getElementById("errorEmail").style.width="100%";
					return false;
				}else if(!emailPattern.test(email)){
					document.getElementById("errorEmail").innerHTML="Enter Valid email";
					document.getElementById("errorEmail").style.display="block";
					document.getElementById('email').style.borderColor="red";
					document.getElementById("errorEmail").style.color="red";
					document.getElementById("errorEmail").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorEmail").style.padding="0px 0% 0px 209px";
					document.getElementById("errorEmail").style.width="100%";
					return false;
				}else{
					document.getElementById("errorEmail").innerHTML="";
					document.getElementById('email').style.borderColor="teal";
					document.getElementById("errorEmail").style.display="none";
					return true;
				}
			}
			function validateSelect(){
				var city=document.forms["contactForm"]["city"].value;
				console.log(city);
				if (city==0) {
					document.getElementById("selectedCity").value="Select a City.";
					document.getElementById('city').style.borderColor="red";
					document.getElementById("selectedCity").style.position="relative";
					document.getElementById("selectedCity").style.visibility="visible";
					document.getElementById("selectedCity").style.color="red";
				}else{
					document.getElementById("selectedCity").value="City selected : "+city+".";
					document.getElementById("selectedCity").style.visibility="visible";
					document.getElementById("selectedCity").style.position="relative";
					document.getElementById("selectedCity").style.width="100%";
					document.getElementById("city").style.borderColor="grey";
				}
			}
			function validateOrganization(){
				var organization=document.forms["contactForm"]["organization"].value;
				var organizationPattern=/^[a-zA-z]+$/;
				if(organization.length<1){
					document.getElementById("errorOrganization").innerHTML="Enter the Organization name.";
					document.getElementById('organization').style.borderColor="red";
					document.getElementById("errorOrganization").style.color="red";
					document.getElementById("errorOrganization").style.display="block";
					document.getElementById("errorOrganization").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorOrganization").style.padding="0px 0% 0px 209px";
					document.getElementById("errorOrganization").style.width="100%";
					return false;
				}else if(!organizationPattern.test(organization)){
					document.getElementById("errorOrganization").innerHTML="Enter only characters";
					document.getElementById("errorOrganization").style.display="block";
					document.getElementById('organization').style.borderColor="red";
					document.getElementById("errorOrganization").style.color="red";
					document.getElementById("errorOrganization").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorOrganization").style.padding="0px 0% 0px 209px";
					document.getElementById("errorOrganization").style.width="100%";
					return false;
				}else{
					document.getElementById("errorOrganization").innerHTML="";
					document.getElementById('organization').style.borderColor="teal";
					document.getElementById("errorOrganization").style.display="none";
					return true;
				}
			}
			function validateContact(){
				var contact=document.forms["contactForm"]["phone"].value;
				var contactPattern=/^[0-9]{6,12}$/;
				if(contact.length<1){
					document.getElementById("errorContact").innerHTML="Enter the Number.";
					document.getElementById('phone').style.borderColor="red";
					document.getElementById("errorContact").style.color="red";
					document.getElementById("errorContact").style.display="block";
					document.getElementById("errorContact").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorContact").style.padding="0px 0% 0px 209px";
					document.getElementById("errorContact").style.width="100%";
					return false;
				}else if(!contactPattern.test(contact)){
					document.getElementById("errorContact").innerHTML="Enter valid contact number";
					document.getElementById("errorContact").style.display="block";
					document.getElementById('phone').style.borderColor="red";
					document.getElementById("errorContact").style.color="red";
					document.getElementById("errorContact").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorContact").style.padding="0px 0% 0px 209px";
					document.getElementById("errorContact").style.width="100%";
					return false;
				}else{
					document.getElementById("errorContact").innerHTML="";
					document.getElementById('phone').style.borderColor="teal";
					document.getElementById("errorContact").style.display="none";
					return true;
				}
			}
			function validateMessage(){
				var message=document.forms["contactForm"]["message"].value;
				if (message.length>250) {
					document.getElementById("errorMessage").innerHTML="The message length should be less than 250.";
					document.getElementById('message').style.borderColor="red";
					document.getElementById("errorMessage").style.display="block";
					document.getElementById("errorMessage").style.color="red";
					document.getElementById("errorMessage").style.margin="-20px 0px 2px 5px";
					document.getElementById("errorMessage").style.padding="0px 0% 0px 209px";
					document.getElementById("errorMessage").style.width="100%";
					return false;
				}else{
					document.getElementById("errorMessage").innerHTML="";
					document.getElementById('message').style.borderColor="teal";
					document.getElementById("errorContact").style.display="none";
					return true;
				}
			}