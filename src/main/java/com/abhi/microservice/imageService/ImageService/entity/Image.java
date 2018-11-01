package com.abhi.microservice.imageService.ImageService.entity;

public class Image {

	private int imageNo;
	private String imageName;
	private String imageLocation;
	
	public Image(int imageNo, String imageName, String imageLocation) {
		super();
		this.imageNo = imageNo;
		this.imageName = imageName;
		this.imageLocation = imageLocation;
	}
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
}
