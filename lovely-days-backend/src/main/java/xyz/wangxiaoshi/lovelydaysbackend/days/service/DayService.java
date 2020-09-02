package xyz.wangxiaoshi.lovelydaysbackend.days.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wangxiaoshi.lovelydaysbackend.days.exception.DayNotFoundException;
import xyz.wangxiaoshi.lovelydaysbackend.days.model.Day;
import xyz.wangxiaoshi.lovelydaysbackend.days.repository.DayRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DayService {

    private final DayRepository dayRepository;

    private final Day emptyDay;

    public static final String ERROR_IMG = "https://raw.githubusercontent.com/wangxiaoshi/" +
            "image-host-xiaoshi/master/blog_files/imgD6792CD6-E155-488F-95B0-9C149C2DC8FF.jpeg";

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
        this.emptyDay = new Day();
        this.emptyDay.setName("小错误");
        this.emptyDay.setDate(LocalDateTime.now());
        this.emptyDay.setImageUrl(ERROR_IMG);
        this.emptyDay.setDescription("Oops, 你可能在找一个不存在的事件呦！");
    }

    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    public Day getDayById(long id) throws DayNotFoundException {
        return dayRepository.findById(id).orElseThrow(()
                -> new DayNotFoundException("The Day with id [" + id + "] is not found! "));
    }

    public Day addDay(Day day) {
        return dayRepository.save(day);
    }

    public void deleteDay(Day day) {
        dayRepository.delete(day);
    }

    public Day changeDay(Day day) throws DayNotFoundException {
        Day dayInDb = dayRepository.findById(day.getId()).orElseThrow(()
                -> new DayNotFoundException("The Day is not found! " + day.toString()));
        dayInDb.setDate(day.getDate());
        dayInDb.setDescription(day.getDescription());
        dayInDb.setImageUrl(day.getImageUrl());
        dayInDb.setType(day.getType());
        return dayRepository.save(dayInDb);
    }

}
