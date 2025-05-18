@regression
Feature: Pet Store Api regression 

@AddPet
Scenario Outline: Add a new pet 
	Given I have a add new pet payload with "<petId>" "<name>" "<status>" "<photoURL>" "<tagId>" "<tagName>" "<categoryId>" "<categoryName>" 
	When I send "POST" request to "PetAPI" 
	Then the Pet is added successfully with response status code 200 
	And the response should contain the "name" and "<name>" 
	
	Examples: 
		|petId|name|status|photoURL|tagId|tagName|categoryId|categoryName|
		|10010|Doggy1|Available|www.doggyphoto.com|1|tag1|10|Large|
		|10011|Doggy2|Available|www.doggyphoto.com|2|tag2|11|Small|
		|10012|Doggy3|Available|www.doggyphoto.com|3|tag3|12|Medium|
		
@GetPet		
Scenario Outline: Get pet by ID 
	Given a pet exists with ID "<petId>" 
	When I send "GET" request to "PetAPI" 
	Then fetch request is successful with response code 200
	
	Examples: 
		|petId|
		|10010|
		|10011|
		|10012|
	

@UpdatePet		
Scenario Outline: Update pet information 
	Given I have a update pet Payload with "<petId>" "<name>" "<status>" "<photoURL>" "<tagId>" "<tagName>" "<categoryId>" "<categoryName>" 
	When I send "PUT" request to "PetAPI" 
	Then the update should be successful with response code 200 
	Examples: 
		|petId|name|status|photoURL|tagId|tagName|categoryId|categoryName|
		|10010|Doggy10|Available|www.doggyphoto10.com|10|tag10|100|Large|
		|10011|Doggy11|Available|www.doggyphoto10.com|11|tag11|101|Large|
		|10012|Doggy12|Available|www.doggyphoto10.com|12|tag12|102|Small|
	

@updatePetImage		
Scenario Outline: Update pet information with Image 
	Given a pet exists with ID "<petId>" 
	When I send "POST" request to "PetAPI" with form information "<additionalMetaData>" "<image>" 
	Then the Image should be uploaded successful with response code 200 
	
	Examples: 
		|petId|additionalMetaData|image|
		|10010|test|test image.png|
		|10011|test|test image.png|
		|10012|test|test image.png|
		

@DeletePet		
Scenario Outline: Delete pet by ID 
	Given a pet exists with ID "<petId>" 
	When I send "DELETE" request to "PetAPI" 
	Then the pet should be deleted with response code 200 
	
	Examples: 
		|petId|
		|10010|
		|10011|
		|10012|