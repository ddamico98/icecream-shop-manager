package it.unipd.tos.business;

import static org.junit.Assert.*;
import java.util.List;
import it.unipd.tos.business.TakeAwayBillImpl;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.*;

import org.junit.Test;

public class TakeAwayBillTest {

    @Test
    public void sconto_5() {
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1998, 7, 28));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Fragola",2));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Budini,"Caramello",2));
        ord.add(new MenuItem(itemType.Bevande,"Fanta",2));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)),20.0,0.0001);
        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
    @Test
    public void sconto_10pc_superati_50_euro(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1998, 7, 28));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Fragola",5));
        ord.add(new MenuItem(itemType.Budini,"Nocciola",10));
        ord.add(new MenuItem(itemType.Budini,"Pistacchio",30));
        ord.add(new MenuItem(itemType.Gelati,"Mandorla",15));
        ord.add(new MenuItem(itemType.Gelati,"caffè",10));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)), 63.0 ,0.0001);
        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
    @Test
    public void superati_30_articoli(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1998, 7, 28));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
       
        boolean check=false;
        try{
            bill.getOrderPrice(ord,u,LocalTime.of(18,23));
        }
        catch(RestaurantBillException e){
            check=true;
        }
        assertTrue(check);
    }
    
    
	
}
