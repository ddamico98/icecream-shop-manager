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
    public void sconto_10pc_senza_sconto_50pc(){
        //in questo caso viene effettuato uno sconto del 10% facendo scendere il prezzo sotto i 50 €
        //e non viene preso il secondo sconto del 50 % sul prezzo più basso
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Tommaso",LocalDate.of(1999, 5, 3));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",10));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",10));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",10));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",10));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",6));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",5));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)), 48.5 ,0.0001);
        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
    @Test
    public void sconto_10pc_e_sconto_superati_5_gelati(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1998, 7, 28));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)), 49.5 ,0.0001);
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
    
    @Test
    public void commissione_sotto_10(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1998, 7, 28));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Pistacchio",2));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",1));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",1));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)), 7.5 ,0.0001);
        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
    
    @Test
    public void scontoMinorenni(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(2004, 5, 4));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",5));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",6));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        try {
            //sconto minorenni accettato
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26,24)), 0.00 ,0.0001);
            //sconto minorenni rifiutato
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26,25)), 48.5 ,0.0001);

        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
    @Test
    public void max_numero_sconto_minorenni(){
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        List<User> utenti = new ArrayList<User>();
        for(int i = 0; i<13;i++) {
            utenti.add(new User(i,"Giovanni",LocalDate.of(2004, 10, 5)));
        }
        utenti.add(new User(13,"Giovanni",LocalDate.of(1998, 7, 28)));


        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",5));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",6));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",10));
        try {
            //sconto minorenni accettato
            assertEquals(bill.getOrderPrice(ord,utenti.get(0),LocalTime.of(18,26,24)), 0.00 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(13),LocalTime.of(18,26,24)), 48.5 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(13),LocalTime.of(16,26,24)), 48.5 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(13),LocalTime.of(20,26,24)), 48.5 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(0),LocalTime.of(17,26,24)), 48.5 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(0),LocalTime.of(21,26,24)), 48.5 ,0.0001);
            for(int i =0; i<10;i++) {
                if(i==0) {
                    assertEquals(bill.getOrderPrice(ord,utenti.get(i),LocalTime.of(18,26,22)), 48.5 ,0.0001);
                }else {
                    assertEquals(bill.getOrderPrice(ord,utenti.get(i),LocalTime.of(18,26,22)), 0.00 ,0.0001);
                }
            }

            assertEquals(bill.getOrderPrice(ord,utenti.get(10),LocalTime.of(18,26,25)), 48.5 ,0.0001);
            assertEquals(bill.getOrderPrice(ord,utenti.get(11),LocalTime.of(18,26,29)), 48.5 ,0.0001);
            // Sono stati superati i minorenni con sconto
            assertEquals(bill.getOrderPrice(ord,utenti.get(12),LocalTime.of(18,26,22)), 48.5 ,0.0001);


        }
        catch(RestaurantBillException e){
            fail();
        }
    }
    
	
}
