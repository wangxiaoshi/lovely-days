package xyz.wangxiaoshi.lovelydaysbackend.days.dto;

import java.time.LocalDateTime;

public class DayDTO {

    private long id;

    private String name;

    private LocalDateTime date;

    private String description;

    private String imageUrl;

    private String type;

    public DayDTO() {
    }

    public DayDTO(long id, String name, LocalDateTime date, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
