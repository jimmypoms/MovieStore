function validate()
{
	if(validateUsername()==false)
		return false;
	if(validatePassword()==false)
		return false;
	return true;
}


function validateUsername()
{
	var x=document.forms["userLoginForm"]["username"].value;
	if (x==null || x=="")
	{
		alert("User name must be filled out");
		return false;
	}
}

function validatePassword()
{
	var x=document.forms["userLoginForm"]["password"].value;
	if (x==null || x=="" || x.length<8)
	{
		alert("Password must be filled out and long at least 8 characters");
		return false;
	}
}