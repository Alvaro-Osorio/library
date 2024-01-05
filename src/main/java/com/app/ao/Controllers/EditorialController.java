package com.app.ao.Controllers;

import com.app.ao.Service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/editorial")
public class EditorialController {

    @Autowired
    private IEditorialService editorialService;
}
