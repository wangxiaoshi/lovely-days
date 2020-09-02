package xyz.wangxiaoshi.lovelydaysbackend.dayType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.exception.DayTypeNotFoundException;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.model.DayType;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.repository.DayTypeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DayTypeService {

    private final DayTypeRepository dayTypeRepository;

    @Autowired
    public DayTypeService(DayTypeRepository dayTypeRepository) {
        this.dayTypeRepository = dayTypeRepository;
    }

    public List<DayType> getAllDayType() {
        return dayTypeRepository.findAll();
    }

    public DayType getDayTypeById(long id) throws DayTypeNotFoundException {
        return dayTypeRepository.findById(id).orElseThrow(() ->
                new DayTypeNotFoundException("The Day-type with id [" + id + "] is not found! "));
    }

    public DayType addDayType(DayType dayType) {
        return dayTypeRepository.save(dayType);
    }

}
