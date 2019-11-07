//Form input validation
const form = document.querySelector('form')
 form.addEventListener('Submit', evt => {
     console.log("Event fired!");
   var fname = document.forms["form"]["Employee first name"].value;
   if (fname == "") {
     alert("Name must be filled out");
     return false;
   }
 })
 
 function load(){
	var xhr = XMLHttpRequest(); //create
	xhr.onreadystatechange=function(){ //define
		console.log("in load()");
	}
	//POST calls the dopost in servlet
	xhr.open("POST","http://localhost:9090/Project01/LoginServlet");
	var payload = jbuild(); 
	xhr.send(payload);  
}
 
 // will grab what is in form and turn into JSON 
 function jbuild(){
	var obj ={};
	var elements=document.getElementsById("f").elements;
	for(var i = 0; i < elements.length-1; i++){
		var item = elements.item(i);
		obj[item.name]=item.value;
		console.log(obj);
	}
	var json = JSON.stringify(obj);
	console.log(json);
	return json;
}
 
 window.onload=function(){
	document.getElementById("submitid").addEventListener("click",load,false);
}
