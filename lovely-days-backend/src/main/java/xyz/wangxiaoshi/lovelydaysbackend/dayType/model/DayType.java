package xyz.wangxiaoshi.lovelydaysbackend.dayType.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DayType implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(unique = true)
    private String type;

    public DayType() {
    }

    public DayType(String type) {
        super();
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
