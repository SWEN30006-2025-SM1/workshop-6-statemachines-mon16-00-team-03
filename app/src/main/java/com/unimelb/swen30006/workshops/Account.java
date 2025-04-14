package com.unimelb.swen30006.workshops;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Account {
    State state;
    boolean missedPaymentHistory = false;

    public void onboard() {
        state = State.PENDING;
    }

    public void outstanding_bill() {
        // superstate: DEFAULT
        if (missedPaymentHistory) { // guard
            paymentPlan();
        } else {
            state = State.GRACE_PERIOD;
        }
    }

    public void failedToPayInGracePeriod() {
        if (state == State.GRACE_PERIOD) {
            paymentPlan();
        }
    }

    public void paymentPlan() {
        state = State.PAYMENT_PLAN;
        System.out.println("Do you want a payment plan? Also, you now owe us $20. Yes?\n");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        scanner.close();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (response.equals("Yes")) {
            acceptsPaymentPlan();
        } else {
            rejectsPaymentPlan();
        }
    }

    public void acceptsPaymentPlan() {
        state = State.HEALTHY_DEBT;
    }
    public void rejectsPaymentPlan() {
        state = State.UNHEALTHY_DEBT;
    }

    public void missedPaymentOnPlan() {
        state = State.UNHEALTHY_DEBT;
    }

    public void referToCollections() {
        state = State.COLLECTIONS;
    }

    public void debtSettled() {
        // either written off or collected
        state = State.CLOSED;
    }

    public void debtPaid() {
        state = State.ACTIVE;
    }

}
