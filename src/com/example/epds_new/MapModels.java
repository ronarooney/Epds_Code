package com.example.epds_new;

public class MapModels {
private String district,officeName,officeType,block,personName;
	 public MapModels() {
	    }
	 public MapModels(String district,String officeName,String officetype,String block,String personName)
	 {
		 this.district=district;
	 }
	 public String getDistrict()
	 {
		 return district;
	 }
	 public void setDistrict(String district)
	 {
		 this.district=district;
	 }
	 public String getOfficeName()
	 {
		 return officeName;
	 }
	 public void setOfficeName(String officeType)
	 {
		 this.officeName=officeName;
	 }
	 public String getOfficeType()
	 {
		 return officeType;
		 
	 }
	 public void setOfficeType(String officeType)
	 {
		 this.officeType=officeType;
		 
	 }
	 public String getBlock()
	 {
		return block; 
	 }
	 public void setBlock(String block)
	 {
		 this.block=block;
	 }
	 public String getPersonName()
	 {
		 return personName;
		
	 }
	 public void setPersonName(String personName)
	 {
		 this.personName=personName;
	 }
}
