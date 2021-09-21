function myFunction() {
	var age = document.getElementById('age').value;
	if(isNaN(age) || age >18 || age < 110) {
		alert("Age must be a number between 1 - 110");
		return false;
	}
}