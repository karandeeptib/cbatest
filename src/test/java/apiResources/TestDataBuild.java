package apiResources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPetPojo;
import pojo.PetCategoryPojo;
import pojo.PetTagsPojo;
import pojo.UpdateAddPetPojo;
import pojo.UpdatePetCategoryPojo;
import pojo.UpdatePetTagsPojo;

public class TestDataBuild {

	public AddPetPojo addNewPetPayload(String petId, String name, String status, String photoURL, String tagId, String tagName, String categoryId, String categoryName) {
		AddPetPojo addPetPojo=new AddPetPojo();
		addPetPojo.setId(Integer.parseInt(petId));
		addPetPojo.setName(name);
		addPetPojo.setStatus(status);
		
		List<String> listPhotoURL=new ArrayList<String>();
		listPhotoURL.add(photoURL);
		addPetPojo.setPhotoUrls(listPhotoURL);
		
		PetTagsPojo tagsPojo=new PetTagsPojo();
		tagsPojo.setId(Integer.parseInt(tagId));
		tagsPojo.setName(tagName);
		List<PetTagsPojo> tagsList=new ArrayList<PetTagsPojo>();
		tagsList.add(tagsPojo);
		addPetPojo.setTags(tagsList);
		
		PetCategoryPojo categoryPojo=new PetCategoryPojo();
		categoryPojo.setId(Integer.parseInt(categoryId));
		categoryPojo.setName(categoryName);
		addPetPojo.setCategory(categoryPojo);
		
		return addPetPojo;
	}
	
	public UpdateAddPetPojo updatePetPayload(String petId, String name, String status, String photoURL, String tagId, String tagName, String categoryId, String categoryName) {
		UpdateAddPetPojo updateAddPetPojo=new UpdateAddPetPojo();
		updateAddPetPojo.setId(Integer.parseInt(petId));
		updateAddPetPojo.setName(name);
		updateAddPetPojo.setStatus(status);
		
		List<String> listPhotoURL=new ArrayList<String>();
		listPhotoURL.add(photoURL);
		updateAddPetPojo.setPhotoUrls(listPhotoURL);
		
		UpdatePetTagsPojo updatePetTagsPojo=new UpdatePetTagsPojo();
		updatePetTagsPojo.setId(Integer.parseInt(tagId));
		updatePetTagsPojo.setName(tagName);
		List<UpdatePetTagsPojo> tagsList=new ArrayList<UpdatePetTagsPojo>();
		tagsList.add(updatePetTagsPojo);
		updateAddPetPojo.setTags(tagsList);
		
		UpdatePetCategoryPojo updateCategoryPojo =new UpdatePetCategoryPojo();
		updateCategoryPojo.setId(Integer.parseInt(categoryId));
		updateCategoryPojo.setName(categoryName);
		updateAddPetPojo.setCategory(updateCategoryPojo);
		
		return updateAddPetPojo;
	}
}
