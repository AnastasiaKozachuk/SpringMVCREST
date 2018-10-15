package com.test.controller;

import com.test.model.PersonLoan;
import com.test.repository.IFileRepository;
import com.test.service.IPersonLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    IPersonLoanService personLoanService;
    @Autowired
    IFileRepository fileRepository;

    @GetMapping(path = "/db",produces ={
            MediaType.APPLICATION_JSON_UTF8_VALUE
    })
    public List<PersonLoan> extractFromDB(@RequestParam(required = false) String gender, @RequestParam(required = false) String year, @RequestParam(required = false) String state) {

        return personLoanService.findFilteredRows(year, state, gender);
    }

    @GetMapping("/file")
    public List<PersonLoan> extractFromFile(@RequestParam(required = false) String gender, @RequestParam(required = false) String year, @RequestParam(required = false) String state) throws Exception {
        return fileRepository.findFilteredRows(year, state, gender);
    }

    @PostMapping("/data/sync")
    public void saveIntoDB() throws Exception {
        personLoanService.importAll();
    }

}
