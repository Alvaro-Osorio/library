package com.app.ao.Controllers;

import com.app.ao.Controllers.DTO.PartnerDTO;
import com.app.ao.Entities.Partner;
import com.app.ao.Service.IPartnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {

    @Autowired
    private IPartnerService partnerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
         Optional<Partner> partnerOptional = partnerService.findById(id);

         if (partnerOptional.isPresent()){
             Partner partner = partnerOptional.get();

             PartnerDTO partnerDTO = PartnerDTO.builder()
                     .id(partner.getId())
                     .name(partner.getName())
                     .lastName(partner.getLastName())
                     .address(partner.getAddress())
                     .loanList(partner.getLoanList())
                     .build();
            return ResponseEntity.ok(partnerDTO);
         }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Partner> partners = partnerService.findAll();

        List<PartnerDTO> partnersDTO = partners.stream()
                .map(partner -> PartnerDTO.builder()
                        .id(partner.getId())
                        .name(partner.getName())
                        .lastName(partner.getLastName())
                        .address(partner.getAddress())
                        .build())
                .toList();
        return ResponseEntity.ok(partnersDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid PartnerDTO partnerDTO) throws URISyntaxException {

        Partner partner = Partner.builder()
                                .name(partnerDTO.getName())
                                .lastName(partnerDTO.getLastName())
                                .address(partnerDTO.getAddress())
                                        .build();
        partnerService.save(partner);

        return ResponseEntity.created(new URI("/api/partner/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PartnerDTO partnerDTO){
        Optional<Partner> partnerOptional = partnerService.findById(id);

        if (partnerOptional.isPresent()){
            Partner partner = partnerOptional.get();
            partner.setName(partnerDTO.getName());
            partner.setLastName(partnerDTO.getLastName());
            partner.setAddress(partnerDTO.getAddress());

            partnerService.save(partner);
            return ResponseEntity.ok("Actulizado");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Partner> partnerOptional = partnerService.findById(id);

        if (partnerOptional.isPresent()){
            partnerService.deleteById(id);

            return ResponseEntity.ok("Eliminado");
        }

        return ResponseEntity.notFound().build();
    }
}
