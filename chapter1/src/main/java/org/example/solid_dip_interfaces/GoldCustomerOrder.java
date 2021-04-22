package org.example.org.example.solid_dip_interfaces;

public class GoldCustomerOrder extends CustomerOrder {
    public GoldCustomerOrder() {
        super(new EmailLogger());
    }
}
