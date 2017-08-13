			window.onload = function(){
				document.getElementById("contactForm").reset();
				document.getElementById("city").selectedIndex=0;
				var retrievedObject = localStorage.getItem('contactFormDetails');
				console.log('retrievedObject: ' + JSON.parse(retrievedObject));
				var retrieveData = JSON.parse(retrievedObject);
				document.getElementById("name").value=retrieveData.name;
				document.getElementById("email").value=retrieveData.email;
				document.getElementById("city").value=retrieveData.city;
				document.getElementById("phone").value=retrieveData.contact;
				document.getElementById("organization").value=retrieveData.organization;
				document.getElementById("message").value=retrieveData.message;
			}
			var emailError=true;
			var nameError=true;
			var contactError=true;
			var organizationError=true;
			var cityError=true;
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
				if(nameError && emailError && organizationError && contactError && cityError){
					var name1=document.forms["contactForm"]["name"].value;
					var email1=document.forms["contactForm"]["email"].value;
					var city1=document.forms["contactForm"]["city"].value;
					var contact1=document.forms["contactForm"]["phone"].value;
					var organization1=document.forms["contactForm"]["organization"].value;
					var message1=document.forms["contactForm"]["message"].value;
					var contactFormDetails = { 'name':name1,'email':email1,'city':city1,'contact':contact1,'organization':organization1,'message':message1};
					// Put the object into storage
					localStorage.setItem('contactFormDetails', JSON.stringify(contactFormDetails));
					// Retrieve the object from storage		
					document.getElementById("contactForm").submit();
				}
				return flag;
			}
			function clearlocalStorage(){
				localStorage.clear();
				document.getElementById("name").value="";
				document.getElementById("email").value="";
				document.getElementById("city").value="0";
				document.getElementById("phone").value="";
				document.getElementById("organization").value="";
				document.getElementById("message").value="";
			}
			function validateName(){
				var name=document.forms["contactForm"]["name"].value;
				var namePattern=/^[A-Za-z]+$/;
				if(name.length<1){
					document.getElementById('name').style.borderColor="red";
					nameError=false;
					return false;
				}else if(!namePattern.test(name)){
					document.getElementById('name').style.borderColor="red";
					nameError=false;
					return false;
				}else if(name.length>20){
					document.getElementById('name').style.borderColor="red";
					nameError=false;
					return false;
				}else{
					document.getElementById('name').style.borderColor="teal";
					nameError=true;
					return true;
				}
			}
			function validateEmail(){
				var email=document.forms["contactForm"]["email"].value;
				var emailPattern=/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
				if(email.length<1){
					document.getElementById('email').style.borderColor="red";
					emailError=false;
					return false;
				}else if(!emailPattern.test(email)){
					document.getElementById('email').style.borderColor="red";
					emailError=false;
					return false;
				}else{
					document.getElementById('email').style.borderColor="teal";
					emailError=true;
					return true;
				}
			}
			function validateSelect(){
				var city=document.forms["contactForm"]["city"].value;
				if (city==0) {
					document.getElementById('city').style.borderColor="red";
					cityError=false;
				}else{
					document.getElementById("city").style.borderColor="teal";
					cityError=true;
				}
			}
			function validateOrganization(){
				var organization=document.forms["contactForm"]["organization"].value;
				var organizationPattern=/^[a-zA-z]+$/;
				if(organization.length<1){
					document.getElementById('organization').style.borderColor="red";
					organizationError=false;
					return false;
				}else if(!organizationPattern.test(organization)){
					document.getElementById('organization').style.borderColor="red";
					organizationError=false;
					return false;
				}else{
					document.getElementById('organization').style.borderColor="teal";
					organizationError=true;
					return true;
				}
			}
			function validateContact(){
				var contact=document.forms["contactForm"]["phone"].value;
				var contactPattern=/^[0-9]{6,12}$/;
				if(contact.length<1){
					document.getElementById('phone').style.borderColor="red";
					contactError=false;
					return false;
				}else if(!contactPattern.test(contact)){
					document.getElementById('phone').style.borderColor="red";
					contactError=false;
					return false;
				}else{
					document.getElementById('phone').style.borderColor="teal";
					contactError=true;
					return true;
				}
			}
			function validateMessage(){
				var message=document.forms["contactForm"]["message"].value;
				if (message.length>250) {
					document.getElementById('message').style.borderColor="red";
					return false;
				}else{
					document.getElementById('message').style.borderColor="teal";
					return true;
				}
			}