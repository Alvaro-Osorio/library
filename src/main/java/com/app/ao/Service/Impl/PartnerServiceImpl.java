package com.app.ao.Service.Impl;

import com.app.ao.Entities.Partner;
import com.app.ao.Repository.PartnerRepository;
import com.app.ao.Service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements IPartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Optional<Partner> findById(Long id) {
        return partnerRepository.findById(id);
    }

    @Override
    public List<Partner> findAll() {
        return (List<Partner>) partnerRepository.findAll();
    }

    @Override
    public void save(Partner partner) {
        partnerRepository.save(partner);
    }

    @Override
    public void deleteById(Long id) {
        partnerRepository.deleteById(id);
    }
}
