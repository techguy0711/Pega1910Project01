////Form input validation
//const form = document.querySelector('form')
// form.addEventListener('Submit', evt => {
//     console.log("Event fired!");
//   var fname = document.forms["form"]["Employee first name"].value;
//   if (fname == "") {
//     alert("Name must be filled out");
//     return false;
//   }
// })
// 
// function load(){
//	var xhr = XMLHttpRequest(); //create
//	xhr.onreadystatechange=function(){ //define
//		console.log("in load()");
//	}
//	//POST calls the dopost in servlet
//	xhr.open("POST","http://localhost:9090/Project001/LoginServlet");
//	var payload = jbuild(); 
//	xhr.send(payload);  
//}
// 
// // will grab what is in form and turn into JSON 
// 
// 
// function fbuild(){
//		var obj ={};
//		var elements=document.getElementsById("ff").elements;
//		for(var i = 0; i < elements.length-1; i++){
//			var item = elements.item(i);
//			obj[item.name]=item.value;
//			console.log(obj);
//		}
//		var json = JSON.stringify(obj);


//		console.log(json);
//		return json;
//}
// 
// window.onload=function(){
//	document.getElementById("submitid").addEventListener("click",load,false);
//}
// 
// 
// 

 function load(){
	var xhr = XMLHttpRequest(); //create
	xhr.onreadystatechange=function(){ //define
		console.log("in load()");
	}
	//POST calls the dopost in servlet
	xhr.open("POST","http://localhost:9090/Project001/LoginServlet");
	var payload = jbuild(); 
	xhr.send(payload);  
}
 
 // will grab what is in form and turn into JSON 
 
 
 function fbuild(){
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
 
 
// function load(){
//		var xhr = XMLHttpRequest(); //create
//		xhr.onreadystatechange=function(){ //define
//			console.log("in load()");
//		}
//		//POST calls the dopost in servlet
//		xhr.open("POST","http://localhost:9090/Project001/FormServlet");
//		var payload = formbuild(); 
//		xhr.send(payload);  
//	}
 
function postForm(){
var xhr=new XMLHttpRequest();
xhr.onreadystatechange=function (){
   if(xhr.readyState==4 && xhr.status==200){
       console.log(xhr.responseText);
   }
}
xhr.open("POST","http://localhost:9090/Project001/form",true);
var payload=jsonBuilder();
xhr.send(payload);
}
 
 function formbuild(){
		var obj ={};
		var elements=document.getElementsById("ff").elements;
		for(var i = 0; i < elements.length-1; i++){
			var item = elements.item(i);
			obj[item.name]=item.value;
			console.log(obj);
		}
		var jsonn = JSON.stringify(obj);


		console.log(jsonn);
		return jsonn;
}
 
 

//function loadForm(form){
//    document.getElementById("employee_first").innerHTML= form.employee_first;
//    document.getElementById("employee_last").innerHTML= form.employee_last;
//    document.getElementById("submit_date").innerHTML=form.submit_date;
//    document.getElementById("start_date").innerHTML=form.start_date;
//    document.getElementById("submit_time").innerHTML=form.submit_time;
//    document.getElementById("city").innerHTML=form.city;
//    document.getElementById("state").innerHTML=form.state;
//    document.getElementById("zip").innerHTML=form.zip;
//    document.getElementById("description").innerHTML=form.description;
//    document.getElementById("class_cost").innerHTML=form.class_cost;
//    document.getElementById("reimbursement_amount").innerHTML=form.reimbursement_amount;
//    document.getElementById("passing_grade").innerHTML=form.passing_grade;
//    document.getElementById("event_type").innerHTML=form.event_type;
//    document.getElementById("work_related_justification").innerHTML=form.work_related_justification;
//    document.getElementById("work_time_missed").innerHTML=form.work_time_missed;
//    document.getElementById("requested_information").innerHTML=form.requested_information;
//    document.getElementById("optional_info").innerHTML=form.optional_info;
//}
//
//function postForm(){
//    var xhr=new XMLHttpRequest();
//    xhr.onreadystatechange=function (){
//        if(xhr.readyState==4 && xhr.status==200){
//            console.log(xhr.responseText);
//        }
//    }
//    xhr.open("POST","http://localhost:9090/Project001/form",true);
//    var payload=jsonBuilder();
//    xhr.send(payload);
//}
//function jsonBuilder(){
//    var elements= document.getElementById("ff").elements;
//    var obj= {};
//    for( var i=0;i<elements.length-1;i++){
//        var item = elements.item(i);
//        obj[item.name]=item.value;
//        console.log(obj);
//    }
//    var json=JSON.stringify(obj);
//    console.log(json);
//    return json;
//}
window.onload= function(){
    document.getElementById("formsubmit").addEventListener("click",postForm,false);
}
