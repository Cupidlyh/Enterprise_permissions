package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ssm.domain.Product;

import java.util.List;

public interface IProductDao {
    // 根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(int id) throws Exception;


    // 查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Update("update product set productName=#{productName},cityName=#{cityName},DepartureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where productNum=#{productNum}")
    void alter(Product product);


}
