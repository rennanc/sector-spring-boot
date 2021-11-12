package com.rennan.sectorspringboot.view;

import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.service.ProfileService;
import com.rennan.sectorspringboot.util.ValidatorUtils;
import com.rennan.sectorspringboot.util.exception.DomainException;
import com.rennan.sectorspringboot.util.exception.ValidationException;
import com.rennan.sectorspringboot.view.dto.ProfileDto;
import com.rennan.sectorspringboot.view.validator.ProfileFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileFormValidator profileFormValidator;

    @GetMapping("/")
    public String index(){
        return "profile/form";
    }

    @GetMapping("/list")
    public String getList(){
        return "profile/list";
    }

    @GetMapping("/getProfiles")
    @ResponseBody
    public List<ProfileDto> getProfiles(){
        List<ProfileDto> profileDtos = new ArrayList<>();
        profileService.getAll().forEach(x -> profileDtos.add(new ProfileDto(java.util.Optional.ofNullable(x))));
        return profileDtos;
    }

    @GetMapping("/getProfile/{id}")
    @ResponseBody
    public ProfileDto getProfile(@PathVariable long id){
        return new ProfileDto(profileService.get(id));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Profile> post(@RequestBody ProfileDto profile) throws DomainException, ValidationException {
        ValidatorUtils.validate(profile, profileFormValidator);
        Profile profileSaved = profileService.save(profile.getEntity());
        return new ResponseEntity<Profile>(profileSaved, HttpStatus.CREATED);
    }
}
