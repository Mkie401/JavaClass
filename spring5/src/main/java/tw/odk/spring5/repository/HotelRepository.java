package tw.odk.spring5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring5.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
