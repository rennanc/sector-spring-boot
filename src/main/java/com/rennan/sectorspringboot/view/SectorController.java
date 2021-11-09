package com.rennan.sectorspringboot.view;

import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.service.SectorService;
import com.rennan.sectorspringboot.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/index")
    public String index(Model model){
        return "sector/index";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Sector> get() {
        return sectorService.getAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody Sector sector) throws DomainException {
        sectorService.create(sector);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
