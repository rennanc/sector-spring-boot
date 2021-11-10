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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileFormValidator profileFormValidator;

    @GetMapping("/index")
    public String index(Model model){
        return "profile/index";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Profile> get(){
        return profileService.getAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody ProfileDto profile) throws DomainException, ValidationException {
        ValidatorUtils.validate(profile, profileFormValidator);
        //profileService.create(profile);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
