package it.unipd.tos.business;

import java.util.ArrayList;

import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;
import java.lang.Math;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.itemType;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImpl implements TakeAwayBill {

    
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime time) throws RestaurantBillException {

        double price = 0;
        int n_gelati = 0;
        double min_price_gelati = 0;
        boolean first = false;
        
       
        for (int i = 0; i < itemsOrdered.size(); i++) {
            
            if (itemsOrdered.get(i).getType() == itemType.Gelati) {
                n_gelati++;
                if (!first) {
                    min_price_gelati = itemsOrdered.get(i).getPrice();
                    first = true;
                } else if (min_price_gelati > itemsOrdered.get(i).getPrice()) {
                    min_price_gelati = itemsOrdered.get(i).getPrice();
                }
                    
            }
            
            price += itemsOrdered.get(i).getPrice();
        }
        
        if (n_gelati > 5) {
            price -= (min_price_gelati / 2);
        }
        
        return price;
    }

}