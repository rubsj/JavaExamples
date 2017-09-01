package com.ruby.designpattern.flyweight;

public class testLogicalCondition {
  public static void main(String[] args) {

		Boolean lineItem = null ;
	  String approve = "Approve" ;
	  String appr = "APPROVE";

		
	System.out.println(" status 1  :" + currentStatus(approve == "Approve" ,  appr == "APPROVE" , lineItem = false));
	System.out.println(" status 2 :" + currentStatus(approve == "Approve" ,  appr == "APPROVE" , lineItem = true));
	
	System.out.println(" status 3  :" + currentStatus(approve == "Deny" ,  appr == "APPROVE" , lineItem = false));
	System.out.println(" status 4  :" + currentStatus(approve == "Deny" ,  appr == "APPROVE" , lineItem = true));
	
	System.out.println(" status 5  :" + currentStatus(approve == "Approve" ,  appr == "Deny" , lineItem = false));
	System.out.println(" status 6  :" + currentStatus(approve == "Approve" ,  appr == "Deny" , lineItem = true));
	
	
 }
  
  private static boolean currentStatus(boolean approveStatus , boolean apprStatus , boolean lineItem ){
	  System.out.print("approveStatus :" + approveStatus + "  apprStatus : " + apprStatus + "  lineItem :" + lineItem);
	  return approveStatus || apprStatus && lineItem;
  }
}
