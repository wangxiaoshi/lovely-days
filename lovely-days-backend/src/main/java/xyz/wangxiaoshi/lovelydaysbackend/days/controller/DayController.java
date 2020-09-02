package xyz.wangxiaoshi.lovelydaysbackend.days.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.service.DayTypeService;
import xyz.wangxiaoshi.lovelydaysbackend.days.exception.DayNotFoundException;
import xyz.wangxiaoshi.lovelydaysbackend.days.model.Day;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.model.DayType;
import xyz.wangxiaoshi.lovelydaysbackend.days.service.DayService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "day")
public class DayController {

    private final DayService dayService;
    private final DayTypeService dayTypeService;

    @Autowired
    public DayController(DayService dayService, DayTypeService dayTypeService) {
        this.dayService = dayService;
        this.dayTypeService = dayTypeService;
    }

    @PostMapping
    @ResponseBody
    public Day addDay(@RequestBody Day day) {
        return dayService.addDay(day);
    }

    @GetMapping
    @ResponseBody
    public List<Day> getAllDay() {
        return dayService.getAllDays();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Day getDay(@PathVariable("id") long id) throws DayNotFoundException {
        return dayService.getDayById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteDay(@PathVariable("id") long id) throws DayNotFoundException {
        Day day = dayService.getDayById(id);
        dayService.deleteDay(day);
    }

    @PostMapping(value = "test")
    @ResponseBody
    public List<Day> saveSomeMock() {

        if (dayTypeService.getAllDayType().isEmpty()) {
            ArrayList<DayType> dayTypes = new ArrayList<>();
            dayTypes.add(new DayType("birthday"));
            dayTypes.add(new DayType("love"));
            dayTypes.add(new DayType("reminder"));
            dayTypes.add(new DayType("event"));
            dayTypes.forEach(dayTypeService::addDayType);
        }
        List<DayType> currentDayTypes = dayTypeService.getAllDayType();

        int count = 10;

        while (count > 0) {
            Day day = new Day();
            day.setName("测试" + RandomStringUtils.random(3));
            day.setDescription(RandomStringUtils.random(30));
            day.setDate(LocalDateTime.now().minusDays(new Random().nextInt(200)));
            day.setImageUrl("https://raw.githubusercontent.com/wangxiaoshi/" +
                    "image-host-xiaoshi/master/blog_files/imgD6792CD6-E155-488F-95B0-9C149C2DC8FF.jpeg");
            /**
             * TODO: 1. Change all response to DayDTO
             *       2. Set model mappper
             *       3. Frontend
             */
            day.setType(currentDayTypes.get(new Random().nextInt(4)));
            dayService.addDay(day);
            count--;
        }
        return dayService.getAllDays();
    }

}
