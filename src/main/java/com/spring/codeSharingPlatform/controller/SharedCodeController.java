package com.spring.codeSharingPlatform.controller;

import com.spring.codeSharingPlatform.dto.SharedCodeResponseDTO;
import com.spring.codeSharingPlatform.model.SharedCode;
import com.spring.codeSharingPlatform.service.SharedCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class SharedCodeController {

    private SharedCodeService sharedCodeService;


    @Autowired
    public SharedCodeController(SharedCodeService sharedCodeService) {
        this.sharedCodeService = sharedCodeService;
    }

    @PostMapping("/add")
    public SharedCode addSharedCode(@RequestBody SharedCode sharedCode) {
        return sharedCodeService.addSharedCode(sharedCode);
    }

    @GetMapping("/{codeId}")
    public SharedCodeResponseDTO getSharedCode(@PathVariable Long codeId) {
       return sharedCodeService.getSharedCode(codeId);
    }

    @GetMapping("/latest")
        public List<SharedCode> getLatestFivePublicSharedCodes() {
        return sharedCodeService.getLatestFivePublicSharedCodes();
    }
}
