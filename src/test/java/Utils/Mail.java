package Utils;

import java.util.Date;

public class Mail {
    private String sender;
    private String subject;
    private String body;
    private Date date;

    public Mail(String sender, String subject, String body,Date date) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
