function  validate(frm){
	frm.vflag.value="yes";
	var name=frm.name.value;
	var age=frm.age.value;
	
	if(name==""){
		alert("Person name is mandatory");
		frm.name.focus();
		return false;
	}
	else if(age==""){
		alert("Person age is mandatory");
		frm.age.focus();
		return false;
	}	
	
	else if(isNaN(age))
	{
		alert("Person age must be numeric form");
		frm.name.focus();
		return false;
	}

	else if(age<=1 || age>=130 ){
		alert("Person age must be 1 through 130");
		frm.age.focus();
		//frm.age.value="";
		return false;
		}
	return true;
}
