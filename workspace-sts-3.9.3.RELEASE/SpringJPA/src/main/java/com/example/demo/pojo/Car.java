package com.example.demo.pojo;

public class Car {
	private String pinpai;
	private String color;
	private String chepai;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPinpai() {
		return pinpai;
	}
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getChepai() {
		return chepai;
	}
	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	
	public Car(String pinpai, String color, String chepai, int price) {
		super();
		this.pinpai = pinpai;
		this.color = color;
		this.chepai = chepai;
		this.price = price;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
