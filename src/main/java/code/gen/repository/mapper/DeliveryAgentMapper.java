
package code.gen.repository.mapper;

import code.gen.entities.*;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryAgentMapper {

    @Update(" UPDATE delivery_agent" + 
		" SET first_name = #{deliveryAgent.firstName}, last_name = #{deliveryAgent.lastName}" + 
		" WHERE (id = #{deliveryAgentId})")
    void update(@Param("deliveryAgentId") int deliveryAgentId, @Param("deliveryAgent") DeliveryAgent deliveryAgent);

    @Select(" SELECT id, first_name, last_name" + 
		" FROM delivery_agent" + 
		" WHERE (id = #{deliveryAgentId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "first_name", property = "firstName"),
		 @Result(column = "last_name", property = "lastName")
	})
    DeliveryAgent get(@Param("deliveryAgentId") int deliveryAgentId);

    @Insert(" INSERT INTO delivery_agent" + 
		"  (first_name, last_name)" + 
		" VALUES (#{deliveryAgent.firstName}, #{deliveryAgent.lastName})")
    @Options(useGeneratedKeys=true, keyProperty="deliveryAgent.id")
    void create(@Param("deliveryAgent") DeliveryAgent deliveryAgent);

    @Delete(" DELETE FROM delivery_agent" + 
		" WHERE (id = #{deliveryAgentId})")
    void delete(@Param("deliveryAgentId") int deliveryAgentId);








}
