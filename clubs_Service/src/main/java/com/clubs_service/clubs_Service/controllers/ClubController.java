package com.clubs_service.clubs_Service.controllers;

import com.clubs_service.clubs_Service.models.Club;
import com.clubs_service.clubs_Service.services.ClubService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs/")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/")
    public ResponseEntity<List<Club>> showAll() {
        List<Club> clubs = this.clubService.getAllClubs();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer id) {
        Club club = this.clubService.getClubById(id);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Club> add(@RequestBody Club club) {
        Club newClub = this.clubService.addClub(club);
        return new ResponseEntity<>(club, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Club> update(@RequestBody Club club) {
        Club updatedClub = this.clubService.updateClub(club);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.clubService.deleteClub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
