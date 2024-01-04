package com.app.ao.Service.Impl;

import com.app.ao.Entities.Partner;
import com.app.ao.Persistence.IPartnerDAO;
import com.app.ao.Service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements IPartnerService {

    @Autowired
    private IPartnerDAO partnerDAO;

    @Override
    public Optional<Partner> findById(Long id) {
        return partnerDAO.findById(id);
    }

    @Override
    public List<Partner> findAll() {
        return partnerDAO.findAll();
    }

    @Override
    public void save(Partner partner) {
        partnerDAO.save(partner);
    }

    @Override
    public void deleteById(Long id) {
        partnerDAO.deleteById(id);
    }
}
