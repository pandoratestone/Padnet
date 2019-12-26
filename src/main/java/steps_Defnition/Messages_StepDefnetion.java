package steps_Defnition;

import io.cucumber.java.en.*;


public class Messages_StepDefnetion {
	
	
	
	
	@Given("^$")
	public void givv(){
		System.out.println("----------------");
	}
	@When("^Send message$")
	public void sentMessage(){
		System.out.println("*************");
	}
	
	@Then("^Recive message$") 
	public void receivmessage(){
	   
	 System.out.println("RECCCCCCCCCCCCCC");  
	}

}
