package mk.domain;

public class Card {

    private String pan;
    private String date;

    public Card(String pan, String date) {
        this.pan = pan;
        this.date = date;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
