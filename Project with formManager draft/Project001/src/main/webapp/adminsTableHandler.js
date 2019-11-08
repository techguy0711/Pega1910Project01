//This EventListener listens for the "Manage Forms" button and shows/hides the form view.
document.getElementById("formToggleButton").addEventListener("click", function(){
	  var doc = document.getElementById("TablecontentDivider");
	  if (doc.style.display === "none") {
		  doc.style.display = "block";
	  } else {
		  doc.style.display = "none";
	  }
  });
//This EventListener listens for the search button to be pressed
//and find matching content in form related to search field.
//Used to filter results by username for admins to manage submitted forms.
document.getElementById("SearchButton").addEventListener("click", function(){
	  var searhField = document.getElementById("SearchField");
	  //TODO
	});
//Log off user after 10 minutes of inactivity
var inactiveContainer = function () {
    var time;
    window.onload = resetTimer;
    document.onmousemove = resetTimer;
    document.onkeypress = resetTimer;

    function logout() {
        location.href = 'http://localhost:8080/Project001/home.html'
        alert("Your session has expired. Browser has been inactive for 10 minutes.")
    }

    function resetTimer() {
        clearTimeout(time);
        time = setTimeout(logout, 500000)
        // -> DEBUG time = setTimeout(logout, 1000)
        console.log("Timer Reset");
    }
};

window.onload = function() {
	inactiveContainer(); 
	console.log("Page Loaded");
	}
