package com.spring.codeSharingPlatform.service;

import com.spring.codeSharingPlatform.dto.SharedCodeResponseDTO;
import com.spring.codeSharingPlatform.model.SharedCode;
import com.spring.codeSharingPlatform.repository.SharedCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharedCodeService {

    private SharedCodeRepository sharedCodeRepository;


    @Autowired
    public SharedCodeService(SharedCodeRepository sharedCodeRepository) {
        this.sharedCodeRepository = sharedCodeRepository;
    }


    public SharedCode addSharedCode(SharedCode sharedCode) {
        sharedCode.setCreatedDate(LocalDateTime.now());
        return sharedCodeRepository.save(sharedCode);
    }

    public SharedCodeResponseDTO getSharedCode(Long codeId) {
        SharedCode foundSharedCode = sharedCodeRepository.findById(codeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "shared code not found"));

        if (foundSharedCode.isPublic()) {
            return new SharedCodeResponseDTO(foundSharedCode, 0L, false);
        }

        if (foundSharedCode.isExpired()) {
            sharedCodeRepository.delete(foundSharedCode);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "shared code cannot be viewed anymore");
        }

        foundSharedCode.setViews(foundSharedCode.getViews() - 1);
        SharedCodeResponseDTO sharedCodeResponseDTO = new SharedCodeResponseDTO(foundSharedCode, foundSharedCode.getTimeLeft(), true);
        sharedCodeRepository.save(foundSharedCode);
        return sharedCodeResponseDTO;
    }

    //ultimele 5 bucati de cod publice adaugate (in functie de data crearii), impreuna cu celelalte detalii:
    public List<SharedCode> getLatestFivePublicSharedCodes() {
        List<SharedCode> foundLatestFiveSharedCodes = sharedCodeRepository.findAll();
        return foundLatestFiveSharedCodes.stream()
                .sorted(Comparator.comparing(SharedCode::getCreatedDate).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

     /*.sorted(Comparator.comparing(SharedCode::getCreatedDate))
                .limit(5) //arata primele 5
                .collect(Collectors.toList()); */

}
