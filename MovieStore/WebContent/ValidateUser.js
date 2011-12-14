function validate()
{
	if(validateUsername()==false)
		return false;
	if(validatePassword()==false)
		return false;
	if(validateName()==false)
		return false;
	if(validateSurname()==false)
		return false;
	if(validateAge()==false)
		return false;
	return true;
}


function validateUsername()
{
	var x=document.forms["newUserForm"]["username"].value;
	if (x==null || x=="")
	{
		alert("User name must be filled out");
		return false;
	}
}

function validatePassword()
{
	var x=document.forms["newUserForm"]["password"].value;
	if (x==null || x=="" || x.length<8)
	{
		alert("Password must be filled out and long at least 8 characters");
		return false;
	}
}

function validateName()
{
	var x=document.forms["newUserForm"]["name"].value;
	if (x==null || x=="")
	{
		alert("Name must be filled out");
		return false;
	}
}

function validateSurname()
{
	var x=document.forms["newUserForm"]["surname"].value;
	if (x==null || x=="")
	{
		alert("Surname must be filled out");
		return false;
	}
}

function validateAge()
{
	var x=document.forms["newUserForm"]["age"].value;
	if (x==null || x=="")
	{
		alert("Age must be filled out");
		return false;
	}
	if(x<0 || x>150)
		{
			alert("Age must be between 0 and 150");
			return false;
		}
}