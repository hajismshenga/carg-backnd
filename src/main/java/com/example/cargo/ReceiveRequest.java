package com.example.cargo;

public class ReceiveRequest {
    private String recipientName;
    private String recipientPhone;
    private boolean receivedBy;
    private String identificationNumber;

    // Getters and Setters


    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public boolean getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(boolean receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
