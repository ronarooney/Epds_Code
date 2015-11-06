package com.example.epds_new;

import java.util.ArrayList;

public class Models {
	 private String title, thumbnailUrl,DIstrict_Number,address,landline,fax,mobile,email;
	   
	    private String district;

	   
	    public Models() {
	    }
	    public Models(String name,String thumbnailUrl,String district)
	    {
	    	this.title=name;
	    	this.thumbnailUrl=thumbnailUrl;
	    	this.district=district;
	    	
	    	
	    }
	    public String getTitle()
	    {
	    	return title;
	    }
	    public void setTitle(String name)
	    {
	    	this.title= name;
	    }
	   
	    public String getDistrict()
	    {
	    	return this.district=district;
	    }
	    public void setDistrict(String district)
	    {
	    	this.district=district;
	    }
	    public String getNumber()
	    {
	    	return DIstrict_Number;
	    }
	    public void setNumber(String number)
	    {
	    	this.DIstrict_Number= number;
	    }
	    public String getAddress()
	    {
	    	return address;
	    }
	    public void setAddress(String address)
	    {
	    	this.address= address;
	    }
	    public String getMobile()
	    {
	    	return mobile;
	    }
	    public void setMobile(String mobile)
	    {
	    	this.mobile= mobile;
	    }
	    public String getFax()
	    {
	    	return fax;
	    }
	    public void setFax(String fax)
	    {
	    	this.fax= fax;
	    }
	    public String getEmail()
	    {
	    	return email;
	    }
	    public void setEmail(String email)
	    {
	    	this.email= email;
	    }
	    public String getLandline()
	    {
	    	return landline;
	    }
	    public void setLandline(String landline)
	    {
	    	this.landline=landline;
	    }
	    
	    
}
