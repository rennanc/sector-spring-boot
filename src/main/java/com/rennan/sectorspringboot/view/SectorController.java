package com.rennan.sectorspringboot.view;

import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.service.SectorService;
import com.rennan.sectorspringboot.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/")
    @ResponseBody
    public List<Sector> get() {
        return sectorService.getAll();
    }

    @PostMapping
    @ResponseBody
    public String post(@RequestBody Sector sector) throws DomainException {
        sector.setName("Manufacturing");
        sectorService.create(sector);
        return "ok";
    }
}
