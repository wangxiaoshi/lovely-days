package xyz.wangxiaoshi.lovelydaysbackend.days.model;

import xyz.wangxiaoshi.lovelydaysbackend.dayType.model.DayType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Day implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(unique = true)
    private String name;

    private LocalDateTime date;

    private String description;

    private String imageUrl;

    @ManyToOne
    private DayType type;

    public Day() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DayType getType() {
        return type;
    }

    public void setType(DayType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type=" + type +
                '}';
    }
}
