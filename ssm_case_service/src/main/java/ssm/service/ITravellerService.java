package ssm.service;

import ssm.domain.Traveller;
import ssm.domain.UserInfo;

import java.util.List;

public interface ITravellerService {
    List<Traveller> findAll(int page, int size) throws Exception;

    void save(Traveller traveller) throws Exception;

    Traveller findById(Integer travellerId) throws Exception;

    void alter(Traveller traveller);
}
