package com.app.ao.Controllers;

import com.app.ao.Service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {

    @Autowired
    private IPartnerService partnerService;
}
