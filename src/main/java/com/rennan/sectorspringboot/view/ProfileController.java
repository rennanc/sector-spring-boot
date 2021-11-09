package com.rennan.sectorspringboot.view;

import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.service.ProfileService;
import com.rennan.sectorspringboot.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/")
    @ResponseBody
    public List<Profile> get(){
        return profileService.getAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody Profile profile) throws DomainException {
        profileService.create(profile);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
