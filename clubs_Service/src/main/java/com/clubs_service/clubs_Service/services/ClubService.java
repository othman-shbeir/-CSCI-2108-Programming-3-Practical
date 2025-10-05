package com.clubs_service.clubs_Service.services;

import com.clubs_service.clubs_Service.Repositories.ClubRepository;
import com.clubs_service.clubs_Service.models.Club;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
    
    @Autowired
    private ClubRepository clubRepository;
    
    public List<Club> getAllClubs() {
        return this.clubRepository.findAll();
    }
    
    public Club getClubById(Integer id) {
        return this.clubRepository.findById(id).get();
    }
    
    public Club addClub(Club club) {
        return this.clubRepository.save(club);
    }
    
    public Club updateClub(Club club) {
        return this.clubRepository.save(club);
    }
    
    public void deleteClub(Integer id) {
        this.clubRepository.deleteById(id);
    }
    
}
