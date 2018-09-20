package com.progra.practica1.entities;

import java.util.ArrayList;
import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


public class Order {

	private Long idOrder;
	
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateReceived;

	private boolean isPrepaid;

	private String num;
	
	private float price;
	
	private ArrayList<OrderLine> arrOrderLine;
	
	
	
	
	public Order(Long idOrder, Date dateReceived, boolean isPrepaid, String num, float price) {
		this.idOrder = idOrder;
		this.dateReceived = dateReceived;
		this.isPrepaid = isPrepaid;
		this.num = num;
		this.price = price;
		arrOrderLine= new ArrayList<OrderLine>();
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public boolean isPrepaid() {
		return isPrepaid;
	}

	public void setPrepaid(boolean isPrepaid) {
		this.isPrepaid = isPrepaid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void dispatch(OrderLine orderLine) {
		arrOrderLine.add(orderLine);
	}
	
	public void close() {
		
	}

	@Override
	public String toString() {
		
		String arrOrderLineText= "";
		for(int i=0; i<arrOrderLine.size();i++) {
			arrOrderLineText +="\n{pos Order Line " + i + ": " + arrOrderLine.get(i).toString() + "}";
		}
		
		return "Order [idOrder=" + idOrder + ", dateReceived=" + dateReceived + ", isPrepaid=" + isPrepaid + ", num="
				+ num + ", price=" + price + ", arrOrderLine=" + arrOrderLineText + "]";
	}
	
	
}
