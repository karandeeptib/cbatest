package pojo;

import java.util.List;

public class AddPetPojo {

	private static int id;
	private PetCategoryPojo category;
	private static String name;
	private static List<String> photoUrls;
	private static List<PetTagsPojo> tags;
	private static String status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategoryPojo getCategory() {
		return category;
	}
	public void setCategory(PetCategoryPojo category) {
		this.category = category;
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
	public List<PetTagsPojo> getTags() {
		return tags;
	}
	public void setTags(List<PetTagsPojo> tagsList) {
		this.tags = tagsList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
