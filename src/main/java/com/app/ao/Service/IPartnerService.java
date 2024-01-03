package com.app.ao.Service;

import com.app.ao.Entities.Partner;

import java.util.List;
import java.util.Optional;

public interface IPartnerService {

    Optional<Partner> findById(Long id);

    List<Partner> findAll();

    void save(Partner partner);

    void deleteById(Long id);
}
