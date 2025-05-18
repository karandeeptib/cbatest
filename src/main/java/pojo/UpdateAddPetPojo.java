package pojo;

import java.util.List;

public class UpdateAddPetPojo {

	private static int id;
	private UpdatePetCategoryPojo category;
	private static String name;
	private static List<String> photoUrls;
	private static List<UpdatePetTagsPojo> tags;
	private static String status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UpdatePetCategoryPojo getCategory() {
		return category;
	}
	public void setCategory(UpdatePetCategoryPojo updateCategoryPojo) {
		this.category = updateCategoryPojo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<UpdatePetTagsPojo> getTags() {
		return tags;
	}
	public void setTags(List<UpdatePetTagsPojo> tagsList) {
		this.tags = tagsList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
