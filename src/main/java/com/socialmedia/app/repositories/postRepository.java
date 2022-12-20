package com.socialmedia.app.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;


public interface postRepository extends JpaRepository<post,Integer> {

	
	public List<post> findByUser(user u);

//	@Query(value="SELECT p FROM Product p WHERE CONCAT(p.catid, p.subcat, p.Cat_img_path, p.Cat_Name,p.pid,p.prod_short_desc,p.prod_long_desc,p.MRP_Price,p.Cardholders_price,points_redeem) LIKE %?1%")
//	List<Product> findBySearch(@Param("Cat_Name") String cat_Name);
//	
//	
}
