package register;

import java.util.*;
import java.beans.*;

public class FormBean
{
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password1;
	private String password2;
	private String[] hobbies;
	private Hashtable errors;

	public FormBean()
	{
		firstName = "";
		lastName = "";
		email = "";
		userName = "";
		password1 = "";
		password2 = "";
		hobbies = new String[] { "1" };
		errors = new Hashtable();
	}

	public boolean validate()
	{
		boolean allOk = true;

		if (firstName.equals(""))
		{
			errors.put("firstName","Enter the first name");
			firstName  ="";
			allOk = false;
		}

		if (lastName.equals(""))
		{
			errors.put("lastName","Enter the last name");
			lastName = "";
			allOk = false;
		}

		if (email.equals("") || (email.indexOf('@') == -1))
		{
			errors.put("email","Enter a valid email address");
			email = "";
			allOk = false;
		}

		if (userName.equals(""))
		{
			errors.put("userName","Enter a username");
			userName = "";
			allOk = false;
		}

		if (password1.equals("") || password2.equals("") )
		{
			errors.put("password1","Enter a valid password");
			password1 = "";
			errors.put("password2","Confirm the password");
			password2 = "";
			allOk = false;
		}

		if (!password1.equals("") && (password2.equals("") || !password1.equals(password2)))
		{
			errors.put("password2","Confirm the password");
			password2 = "";
			allOk = false;
		}
		return allOk;
	}

	public String getErrorMsg(String s) 
	{
		String errorMsg = (String)errors.get(s.trim());
		return (errorMsg == null) ? "":errorMsg;
	}
	public void setErrors(String key, String msg)
	{
		errors.put(key,msg);
	}

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String fname)
	{
		firstName = fname;
	}

	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lname)
	{
		lastName = lname;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String eml)
	{
		email = eml;
	}

	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String u)
	{
		userName = u;
	}

	public String getPassword1()
	{
		return password1;
	}
	public void  setPassword1(String p1)
	{
		password1 = p1;
	}

	public String getPassword2()
	{
		return password2;
	}
	public void  setPassword2(String p2) 
	{
		password2 = p2;
	}

	public String[] getHobbies()
	{
		return hobbies;
	}
	public void setHobbies(String[] hobby)
	{
		hobbies = hobby;
	}

	public String isCbSelected(String s)
	{
		boolean found = false;
		if (!hobbies[0].equals("1"))
		{
			for (int i = 0; i < hobbies.length; i++)
			{
				if (hobbies[i].equals(s))
				{
					found = true;  
					break;
				}
			}
			if (found) 
				return "checked";
		}
		return "";
	}
}