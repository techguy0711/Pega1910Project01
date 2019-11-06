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
