/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;
import java.util.ArrayList;

public class DrivableTrader<T> extends  Trader<T>{


    public DrivableTrader(List<T> inventory, List<T> wishlist, int money) {
        super(money);
        for (T i: inventory){
            this.addToInventory(i);
        }
        for (T i: wishlist){
            this.addToWishlist(i);
        }

    }

    public DrivableTrader(int money){
        super(money);
    }

    @Override
    public void addToInventory(T item){
        if (item instanceof  Drivable){
            super.addToInventory(item);
        }
    }

    @Override
    public void addToWishlist(T item){
        if (item instanceof  Drivable){
            super.addToWishlist(item);
        }
    }

    public int getSellingPrice(T item){
        if (item instanceof Tradable){
            return super.getSellingPrice(item) + ((Drivable) item).getMaxSpeed();
        }
        return super.getSellingPrice(item);
    }


}
