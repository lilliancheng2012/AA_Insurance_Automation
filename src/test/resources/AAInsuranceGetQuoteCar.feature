# Feature/AA Insurance: Get a Quote for Car demo
Feature: AA Insurance: Get a Quote for Car 

Background: 
	Given I go to AA Insurance website 
	And I want to by car insurance 
	
	
Scenario: Buy car insurance for my Nissan MARCH 2010
		1.Comprehensive policy product
		2.Private use purpose
		3.Not an AA member
		4.Nissan march - 2010

	Given I choose type of car insurance cover is "Comprehensive" 
	And I want the Policy start date is today 
	And I am not an AA insurance member 
	
	Given My car Year Of Manufacture is "2010" 
	And The car Make is "NISSAN" 
	And The car module is "MARCH" 
	
	Given I don't cover Accessories and modifications 
	And I don't buy car on finance 
	And I use my car as "Private" 
	
	Given My personal details as below: 
		|suburb                          |street                                      |datebirth | sex  |
		|MOUNT WELLINGTON, 1060, AUCKLAND|242 Penrose Road MT Wellington, Auckland1060|18-10-1989|Female|
		
	When I get my quote from the website 
	Then The premium fee should be "$741.66" per annual 
	
	
Scenario: Buy car insurance for my Nissan MARCH 2014 
		1.Third Party policy product
		2.Business use purpose
		3.Not an AA member
		4.NISSAN ALTIMA - 2014

	Given I choose type of car insurance cover is "Third Party" 
	And I want the Policy start date is today 
	And I am not an AA insurance member 
	
	Given My car Year Of Manufacture is "2014" 
	And The car Make is "NISSAN" 
	And The car module is "ALTIMA" 
	
	Given I don't cover Accessories and modifications 
	And I don't buy car on finance 
	And I use my car as "Business" 
	
	Given My personal details as below: 
		|suburb                          |street                                      |datebirth |sex |
		|MOUNT WELLINGTON, 1060, AUCKLAND|242 Penrose Road MT Wellington, Auckland1060|18-10-1989|Male|
		
	When I get my quote from the website 
	Then The premium fee should be "$322.79" per annual
	
	
Scenario: Buy car insurance for my Bluebird 2010 
		1.Third Party policy product
		2.Business use purpose
		3.Not an AA member
		4.Nissan Bluebird - 2010

	Given I choose type of car insurance cover is "Third Party" 
	And I want the Policy start date is today 
	And I am not an AA insurance member 
	
	Given My car Year Of Manufacture is "2010" 
	And The car Make is "NISSAN" 
	And The car module is "BLUEBIRD SYLPHY" 
	
	Given I don't cover Accessories and modifications
	And I don't buy car on finance
	And I use my car as "Business"
	
	Given My personal details as below:
	|suburb                          |street                                      |datebirth | sex  |
	|MOUNT WELLINGTON, 1060, AUCKLAND|242 Penrose Road MT Wellington, Auckland1060|18-10-1989|Female|
	
	When I get my quote from the website 
	Then The premium fee should be "$384.41" per annual