package org.example.org.example.solid_dip_interfaces;

import java.io.IOException;

//this class violates the SRP. It should be focused on creating purchases and deciding which object to be made, while
// is not the job of this class to determine which instances of the logger should be used.


public class CustomerOrder {

    private final Logger logger;

    public CustomerOrder(Logger logger) {
        this.logger = logger;
    }

    public void create() throws IOException {
        try {
            //DB goes here
        } catch (Exception ex) {
            logger.createLogEntry(ex.getLocalizedMessage());
        }

    }


    // The biggest problem is related to the new keyword. This is an extra responsibility of making the decision which
    // objects to be created, so if we delegate this responsibility to someone other than the CustomerOrder class, that will
    // solve the problem.
    //The logger can be passed as dependency rather than creating it in the method itself.
    /*public void create (OrderType orderType) throws IOException {
        try {
            //DB goes here
        }
        catch (Exception ex){
            switch(orderType){
                case Normal:
                    new SmsLogger().createLogEntry(ex.getMessage());
                    break;
                case Silver:
                case Gold:
                    new EmailLogger().createLogEntry(ex.getMessage());
                    break;
                case Platinum:
                    new FileLogger().createLogEntry(ex.getMessage());
                    break;
            }
            fileLogger.createLogEntry(ex.getLocalizedMessage());
        }

    }*/
}
