// [Damiano] [D'Amico] [1201216]

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
    private List<User> free_ords = new ArrayList<User>();

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime time) throws RestaurantBillException {

        double price = 0;
        int n_gelati = 0;
        double tot_bud_gel = 0;
        double min_price_gelati = 0;
        boolean first = false;

        if (itemsOrdered.size() > 30) {
            throw new RestaurantBillException();
        }
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getType() == itemType.Gelati || itemsOrdered.get(i).getType() == itemType.Budini) {
                tot_bud_gel += itemsOrdered.get(i).getPrice();
            }
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
            tot_bud_gel -= (min_price_gelati / 2);
        }

        if (tot_bud_gel > 50) {
            price -= price * 0.1;
        }

        if (price < 10) {
            price += 0.5;
        }

        Period under = Period.between(user.getDate(), LocalDate.now());
        if (under.getYears() < 18 && time.isAfter(LocalTime.of(18, 0, 0)) && time.isBefore(LocalTime.of(19, 0, 0))
                && free_ords.size() < 10) {
            boolean check = false;
            int rand = 0;
            for (int i = 0; i < free_ords.size(); i++) {
                if (free_ords.get(i).getId() == user.getId()) {
                    check = true;
                }

            }
            rand = time.getSecond();
            if (rand % 2 == 0 && !check) {
                price = 0;
                free_ords.add(user);
            }
        }

        return price;
    }

}