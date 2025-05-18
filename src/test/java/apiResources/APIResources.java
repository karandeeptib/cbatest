package apiResources;

public enum APIResources {

	
	PetAPI("/v2/pet");
	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
}
