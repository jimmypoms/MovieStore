function validate()
{
	if(validateTitle()==false)
		return false;
	if(validateYear()==false)
		return false;
	return true;
}


function validateTitle()
{
	var x=document.forms["addMovieForm"]["title"].value;
	if (x==null || x=="")
	{
		alert("Title must be filled out");
		return false;
	}
}

function validateYear()
{
	var x=document.forms["addMovieForm"]["year"].value;
	if (x==null || x=="")
	{
		alert("Title must be filled out");
		return false;
	}
	var today = new Date(); 
	var yyyy = today.getFullYear();
	if(x<1895 || x>yyyy+10)
		{
			alert("Year must be between 1895 and"+eval(yyyy+10));
			return false;
		}
}