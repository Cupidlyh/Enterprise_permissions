package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.ITravellerDao;
import ssm.domain.Traveller;
import ssm.service.ITravellerService;

import java.util.List;

@Service("travellerService")
@Transactional
public class TravellerServiceImpl implements ITravellerService {
    @Autowired
    private ITravellerDao travellerDao;

    @Override
    public List<Traveller> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return travellerDao.findAll();
    }

    @Override
    public void save(Traveller traveller) throws Exception {
        travellerDao.save(traveller);
    }

    @Override
    public Traveller findById(Integer travellerId) throws Exception {
        return travellerDao.findById(travellerId);
    }

    @Override
    public void alter(Traveller traveller) {
        travellerDao.alter(traveller);
    }
}
