package com.example.epds_new;

public class InspectorModels {
	 private String title, thumbnailUrl,DIstrict_Number,Block_Name,inspector,landline,address,office,mobile;

	 public InspectorModels() {
	    }
	 public InspectorModels(String name,String thumbnailUrl,String district)
	    {
	    	this.title=name;
	    	this.thumbnailUrl=thumbnailUrl;
	 
	    	
	    	
	    }
	 public String getTitle()
	    {
	    	return title;
	    }
	    public void setTitle(String name)
	    {
	    	this.title= name;
	    }
	   
public String getNumber()
{
	return DIstrict_Number;
}
public void setNumber(String DIstrict_number)
{
	this.DIstrict_Number=DIstrict_number;
}
public String getInspector()
{
	return inspector;
}
public void setInspector(String inspector)
{
	this.inspector=inspector;
}
public String getAddress()
{
	return address;
}
public void setAddress(String address)
{
	this.address=address;
}
public String getOffice()
{
	return office;
}
public void setOffice(String office)
{
	this.office=office;
}
public String getMobile()
{
	return mobile;
}
public void setMobile(String mobile)
{
	this.mobile=mobile;
}
	    
}
