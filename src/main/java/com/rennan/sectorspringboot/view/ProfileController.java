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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileFormValidator profileFormValidator;

    @GetMapping("/create")
    public String index(Model model){
        return "profile/create";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Profile> getList(){
        return profileService.getAll();
    }

    @GetMapping("/getProfile/{id}")
    @ResponseBody
    public Optional<Profile> getProfile(@PathVariable long id){
        return profileService.get(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Profile> post(@RequestBody ProfileDto profile) throws DomainException, ValidationException {
        ValidatorUtils.validate(profile, profileFormValidator);
        Profile profileCreated = profileService.create(profile.getEntity());
        return new ResponseEntity<Profile>(profileCreated, HttpStatus.CREATED);
    }
}
