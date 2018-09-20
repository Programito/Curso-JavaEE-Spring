package com.progra.practica1;

import java.util.ArrayList;
import java.util.Date;

import com.progra.practica1.entities.CorporateCustomer;
import com.progra.practica1.entities.Customer;
import com.progra.practica1.entities.Order;
import com.progra.practica1.entities.OrderLine;
import com.progra.practica1.entities.PersonalCustomer;
import com.progra.practica1.entities.Producto;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Customer> arrCustomer=new ArrayList<Customer>();
        ArrayList<Producto> arrProductos=new ArrayList<Producto>();
        
        // afegir un CustomerCorporate
        //  CorporateCustomer(Long idCustomer, String name, String deliveryAdress, String phone, String contact, char creditRating, int creditLimit) {
        CorporateCustomer corporateCustomer= new CorporateCustomer(123L,"Juan","Carrer Gaudi","931933212","contacto",'a',999);
        arrCustomer.add(corporateCustomer);
        System.out.println(arrCustomer.get(0).toString());
        
        // afegir un PersonalCustomer
        //PersonalCustomer(Long idCustomer, String name, String deliveryAdress, String phone,char creditRating, String creditCard
        PersonalCustomer personalCustomer= new PersonalCustomer(124L,"Pablo","Carrer Canigo","689132198",'a',"12312312312");
        arrCustomer.add(personalCustomer);
        System.out.println(arrCustomer.get(1).toString());
        
        // Long idProduct, String name, Float price, String remarks
        Producto product= new Producto(126L,"Televisor",250.3f,"A");
        System.out.println("Producto1: " + product.toString());
        Producto product2= new Producto(126L,"Frigorifico",250.3f,"A");
        System.out.println("Producto2: " + product.toString());
        
        OrderLine orderLine= new OrderLine(3L,product,2);
        System.out.println("OrderLine1: " + orderLine.toString());
        OrderLine orderLine2= new OrderLine(3L,product2,2);
        System.out.println("OrderLine2: " +  orderLine2.toString());
        
        
        
        //Long idOrder, Date dateReceived, boolean isPrepaid, String num, float price
        Date dateReceived= new Date();
        Order order= new Order(19L, dateReceived, false, "21312a",200f);
        
        order.dispatch(orderLine);
        
        System.out.println(order.toString());
        
        order.dispatch(orderLine2);
        
        System.out.println(order.toString());
        
        corporateCustomer.addOrder(order);
        
        System.out.println("CorpoarateCustomer amb 1 Order" + corporateCustomer.toString());
        
        Order order2= new Order(19L, dateReceived, false, "21312a",200f);
        
        order2.dispatch(orderLine);
        
        order2.dispatch(orderLine2);
        
        corporateCustomer.addOrder(order2);
        
        System.out.println("CorpoarateCustomer amb 2 Orders" + corporateCustomer.toString());
        
        
        
    }	
}
