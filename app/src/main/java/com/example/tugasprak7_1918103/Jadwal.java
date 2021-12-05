package com.example.tugasprak7_1918103;

public class Jadwal {
    private String _id, _jadwal, _tim;
    public Jadwal (String id, String jadwal, String tim) {
        this._id = id;
        this._jadwal = jadwal;
        this._tim = tim;
}
    public Jadwal() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_jadwal() {
        return _jadwal;
    }
    public void set_jadwal(String _jadwal) {
        this._jadwal = _jadwal;
    }
    public String get_tim() {
        return _tim;
    }
    public void set_tim(String _tim) {
        this._tim = _tim;
    }
}


