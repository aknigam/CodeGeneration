
package code.gen.written.repository.mapper;

import code.gen.written.entities.DeliveryAgent;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//@Mapper
public interface DeliveryAgentMapper {

    @Update("Update deliveryAgent set name = ")
    DeliveryAgent update(@Param("deliveryAgentId") int deliveryAgentId, @Param("deliveryAgent") DeliveryAgent deliveryAgent);

    @Select("Select id from deliveryAgent where id =")
    DeliveryAgent get(@Param("deliveryAgentId") int deliveryAgentId);

    @Insert("Insert into deliveryAgent () values () ")
    void create(@Param("deliveryAgent") DeliveryAgent deliveryAgent);

    @Delete("Delete from deliveryAgent where id = ")
    void delete(@Param("deliveryAgentId") int deliveryAgentId);
}
