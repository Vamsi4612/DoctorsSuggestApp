package com.lattice.entities;

public enum SymptomsAllowed {
				
	ARTHRITIS("Arthritis","Orthopedic"),
	BACKPAIN("Backpain","Orthopedic"),
	TISSUE_INJURIES("Tissue injuries","Orthopedic"),                     
	DYSMENORRHEA("Dysmenorrhea","Gynecology"),						
	SKIN_INFECTION("Skin infection","Dermatology"),
	SKIN_BURN("skin burn","Dermatology"),					       
	EAR_PAIN("Ear pain","ENT");                         
	
	public final String displayName;
	public final String speciality;

	SymptomsAllowed(String displayName,String speciality) {
        this.displayName = displayName;
        this.speciality = speciality;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public String getSpeciality() {
    	return speciality;
    }
    
    public static String[] allowed(){
    	String[] arr = {"Arthritis","Backpain","Tissue injuries","Dysmenorrhea","Skin infection","skin burn","Ear pain"};
    	return arr;
    }
	
	
}
