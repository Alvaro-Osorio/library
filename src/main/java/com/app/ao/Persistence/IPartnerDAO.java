package com.app.ao.Persistence;

import com.app.ao.Entities.Partner;

import java.util.List;
import java.util.Optional;

public interface IPartnerDAO {

    Optional<Partner> findById(Long id);

    List<Partner> findAll();

    void save(Partner partner);

    void deleteById(Long id);
}
