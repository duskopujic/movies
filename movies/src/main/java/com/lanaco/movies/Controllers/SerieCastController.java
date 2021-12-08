package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.SerieCastDto;
import com.lanaco.movies.Models.SerieCast;
import com.lanaco.movies.Services.SerieCastService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/serie-cast")
public class SerieCastController {
    private final SerieCastService serieCastService;

    public SerieCastController(SerieCastService serieCastService){
        this.serieCastService = serieCastService;
    }
    @GetMapping("")

    public ResponseEntity<List<SerieCast>>findAll(){
        List<SerieCast>allSerieCast = serieCastService.findAll();
        return ResponseEntity.ok(allSerieCast);
    }
    @PostMapping("")

    public ResponseEntity<SerieCast>createSerieCast(@RequestBody SerieCastDto serieCastParam){
        SerieCast createdSerieCast = serieCastService.create(serieCastParam.toSerieCast());
        return ResponseEntity.ok(createdSerieCast);
    }
}
