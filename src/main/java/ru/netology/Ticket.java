package ru.netology;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private String from;
    private String to;
    private int prise;
    private int time;

    public Ticket(int id, String from, String to, int prise, int time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.prise = prise;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrise() {
        return prise;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (prise < o.getPrise()) {
            return -1;
        }
        if (prise > o.getPrise()) {
            return 1;
        }
        return 0;
    }
}
