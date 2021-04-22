package org.example.org.example.solid_dip_interfaces;

public class PlatinumCustomerOrder extends CustomerOrder {
    public PlatinumCustomerOrder() {
        super(new SmsLogger());
    }
}
