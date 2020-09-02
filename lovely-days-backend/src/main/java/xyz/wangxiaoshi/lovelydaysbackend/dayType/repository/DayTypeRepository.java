package xyz.wangxiaoshi.lovelydaysbackend.dayType.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.wangxiaoshi.lovelydaysbackend.dayType.model.DayType;

@Repository
public interface DayTypeRepository extends JpaRepository<DayType, Long> {
}
