package com.app.ao.Controllers;

import com.app.ao.Service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;
}
