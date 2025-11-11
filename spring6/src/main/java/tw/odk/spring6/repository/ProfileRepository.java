package tw.odk.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring6.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
