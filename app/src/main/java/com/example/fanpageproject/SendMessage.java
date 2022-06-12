package com.example.fanpageproject;

import com.google.firebase.auth.FirebaseAuth;

public class SendMessage {
    private String sendMessage;
    private String receiver;

    public SendMessage(String receiver) {
        this.receiver = receiver;
    }

    public SendMessage() {
        this.sendMessage = sendMessage;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String toString() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid().replaceAll("gfFXHshb3YdNxDm5MWzuJ5BmHPj1", "enesbatuhanay").replaceAll("QUSCnpZiI1NNSBDQjtiqp6cayik2", "onurataasar");

        return "\n"+ user + ": \n \n" + sendMessage+ " \n";
    }

    public String toString2() {
        return receiver + ": " + sendMessage;
    }
}
