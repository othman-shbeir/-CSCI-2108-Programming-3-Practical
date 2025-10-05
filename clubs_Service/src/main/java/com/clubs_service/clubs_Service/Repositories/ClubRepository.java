package com.clubs_service.clubs_Service.Repositories;

import com.clubs_service.clubs_Service.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
