package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ssm.domain.Traveller;
import ssm.domain.UserInfo;

import java.util.List;

public interface ITravellerDao {
    @Select("select * from traveller")
    List<Traveller> findAll() throws Exception;

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(int ordersId) throws Exception;

    @Insert("insert into traveller(name,sex,phoneNum,credentialsType,credentialsNum,travellerType) values(#{name},#{sex},#{phoneNum},#{credentialsType},#{credentialsNum},#{travellerType})")
    void save(Traveller traveller) throws Exception;

    @Select("select * from traveller where id=#{travellerId}")
    Traveller findById(Integer travellerId) throws Exception;

    @Update("update traveller set NAME=#{name},sex=#{sex},phoneNum=#{phoneNum},credentialsType=#{credentialsType},credentialsNum=#{credentialsNum},travellerType=#{travellerType} where id=#{id}")
    void alter(Traveller traveller);
}
