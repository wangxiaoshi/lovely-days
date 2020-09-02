package xyz.wangxiaoshi.lovelydaysbackend.days.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.wangxiaoshi.lovelydaysbackend.days.model.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
}
