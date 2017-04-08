package top.zz.util;

import java.io.Serializable;
import java.util.Locale;

public class Order implements Serializable {
    public static final String ORDERS = "orders";
    private static final long serialVersionUID = -5907589926883016200L;
    private static final Order.Direction DEFAULT_DIRECTION;
    private String property;
    private Order.Direction direction;

    public Order() {
        this.direction = DEFAULT_DIRECTION;
    }

    public Order(String property, Order.Direction direction) {
        this.direction = DEFAULT_DIRECTION;
        this.property = property;
        this.direction = direction;
    }

    public static Order asc(String property) {
        return new Order(property, Order.Direction.ASC);
    }

    public static Order desc(String property) {
        return new Order(property, Order.Direction.DESC);
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Order.Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Order.Direction direction) {
        this.direction = direction;
    }

    public int hashCode() {

        int result = 1;
        result = 31 * result + (this.direction == null?0:this.direction.hashCode());
        result = 31 * result + (this.property == null?0:this.property.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            Order other = (Order)obj;
            if(this.direction != other.direction) {
                return false;
            } else {
                if(this.property == null) {
                    if(other.property != null) {
                        return false;
                    }
                } else if(!this.property.equals(other.property)) {
                    return false;
                }

                return true;
            }
        }
    }

    static {
        DEFAULT_DIRECTION = Order.Direction.DESC;
    }

    public static enum Direction {
        ASC,
        DESC;

        private Direction() {
        }

        public static Order.Direction fromString(String value) {
            try {
                return valueOf(value.toUpperCase(Locale.US));
            } catch (Exception var2) {
                return ASC;
            }
        }
    }
}

