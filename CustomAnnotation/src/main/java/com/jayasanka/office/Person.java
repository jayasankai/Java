package com.jayasanka.office;

import com.jayasanka.custom.annotation.Init;
import com.jayasanka.custom.annotation.JsonElement;
import com.jayasanka.custom.annotation.JsonSerializable;

@JsonSerializable
public class Person {
	
	@JsonElement
	private String firstName;
	
	@JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() 
          + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() 
          + this.lastName.substring(1);
    }

}
