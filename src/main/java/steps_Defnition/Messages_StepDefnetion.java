package steps_Defnition;

import io.cucumber.java.en.*;


public class Messages_StepDefnetion {
	
	
	
	
	@Given("^Send messgae from userA$")
	public void givv(){
		System.out.println("----------------");
		System.out.println("*************");
	}
	@When("^Receiver will receive message$")
	public void sentMessage(){
		System.out.println("*************");
	}
	
	@Then("^Received message$") 
	public void receivmessage(){
	   
	 System.out.println("RECCCCCCCCCCCCCC");  
	}

}
