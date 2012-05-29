package com.dynamicListView;

public class GtuMcaBean
{
    String gtumcaFirstName,gtumcaLastName,gtumcaBirthdate;  
    GtuMcaBean(String gtumcaFirstName,String gtumcaLastName,String gtumcaBirthdate)
    {
        this.gtumcaFirstName = gtumcaFirstName;
        this.gtumcaLastName = gtumcaLastName;
        this.gtumcaBirthdate = gtumcaBirthdate;
    }
	public String getGtumcaFirstName() {
		return gtumcaFirstName;
	}
	public void setGtumcaFirstName(String gtumcaFirstName) {
		this.gtumcaFirstName = gtumcaFirstName;
	}
	public String getGtumcaLastName() {
		return gtumcaLastName;
	}
	public void setGtumcaLastName(String gtumcaLastName) {
		this.gtumcaLastName = gtumcaLastName;
	}
	public String getGtumcaBirthdate() {
		return gtumcaBirthdate;
	}
	public void setGtumcaBirthdate(String gtumcaBirthdate) {
		this.gtumcaBirthdate = gtumcaBirthdate;
	}
    
    
}