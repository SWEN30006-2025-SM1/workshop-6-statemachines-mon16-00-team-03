package com.unimelb.swen30006.workshops;

public class Account {
    State state;
    int currentCardNumber;

    private State accountState;

    public void onboard() {
        State state = State.PENDING;
    }

    //public void activateCard(){}


    public void closeAccount(){
        accountState = State.CLOSED;
    }

    public void activateAccount(){
        accountState = State.ACTIVE;
    }
    public void inactivateAccount(){
        accountState = State.INACTIVE;
    }
    public void suspendAccount(){
        accountState = State.SUSPENDED;
    }
}


