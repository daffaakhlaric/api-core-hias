package com.hias.apps.repository;
import com.hias.apps.domain.Product;
import com.hias.apps.domain.UserRegister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findAllByOrderByIdDesc();

    Optional<Product> findById(Long productId);

    List<Product> findTop10ByOrderByQuantityDesc();

    List<Product> findTop10ByOrderByQuantityAsc();

    @Query("Select c from Product c where category_id = :id ORDER BY id ASC ")
    List<Product> findAllByOrderByIdAsc(@Param("id") Long Id);

//    @Query("SELECT c FROM Product c WHERE category_id = :id ORDER BY c.color = red")
//    List<Product> findAllColorRed(@Param("id") Long Id);



    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='red'",
            nativeQuery=true
    )
    public List<Product> findAllColorRed(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='green'",
            nativeQuery=true
    )
    public List<Product> findAllColorGreen(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='wihte'",
            nativeQuery=true
    )
    public List<Product> findAllColorWhite(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='black'",
            nativeQuery=true
    )
    public List<Product> findAllColorBlack(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='yellow'",
            nativeQuery=true
    )
    public List<Product> findAllColorYellow(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='grey'",
            nativeQuery=true
    )
    public List<Product> findAllColorGrey(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='blue'",
            nativeQuery=true
    )
    public List<Product> findAllColorBlue(@Param("id") Long Id);

    @Query(
            value = "SELECT * FROM product ur where ur.category_id = :id AND ur.color='brown'",
            nativeQuery=true
    )
    public List<Product> findAllColorBrown(@Param("id") Long Id);

    List<Product> findAllByOrderBySellCountAsc();

    List<Product> findFirst8ByOrderByIdDesc();

    List<Product> findFirst8ByOrderBySellCountAsc();

    List<Product> findTop8ByOrderByNameAsc();

    @Query("Select c from Product c where category_id = :id ORDER BY name ASC ")
    List<Product> findAllByOrderByNameAsc(@Param("id") Long Id);

    @Query("Select c from Product c where category_id = :id ORDER BY color ASC ")
    List<Product> findAllColorAsc(@Param("id") Long Id);

    @Query("Select c from Product c where category_id = :id ORDER BY name DESC ")
    List<Product> findAllByOrderByNameDesc(@Param("id") Long Id);

    @Query("Select c from Product c where category_id = :id ORDER BY price ASC ")
    List<Product> findAllByOrderByPriceAsc(@Param("id") Long Id);

    @Query("Select c from Product c where category_id = :id ORDER BY price DESC ")
    List<Product> findAllByOrderByPriceDesc(@Param("id") Long Id);

    @Query("Select c from Product c where category_id = :id ORDER BY id DESC ")
    List<Product> findAllByOrderByIdDesc(@Param("id") Long Id);

    @Query("Select c from Product c where c.name like %:name%")
    Page<Product> findByName(@Param("name") String name,Pageable pageable);

    @Query("Select c from Product c where id = :id")
    Optional<Product> findAllOrderById(@Param("id") Long Id);

    @Query("Select c from Product c where is_banner='1'")
    List<Product> findAllProductBanner();

//
//    @Query("Select c from Product c where sub_category_id = :id")
//    Optional<Product> findBySubCategoryId(Long id);

    @Query("Select c from Product c where category_id = :id")
    Page<Product> findByCategoryId(Long id, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product WHERE id = :id", nativeQuery = true)
    public void deleteProduct(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "insert into product (name,category_id,discount,overview,description,thumbnail_url,hash_tag,color,dimensions,price,product_code,quantity,weight,picture_1,picture_2,picture_3,picture_4,picture_5,picture_6,courier_1,courier_2,courier_3,courier_4) values (:productName, :categoryId,:discount,:overview, :description, :thumbnail,:hashTag, :color, :dimen , :price, :productCode, :quantity, :weight, :picture1, :picture2, :picture3,:picture4,:picture5,:picture6,:courier1,:courier2,:courier3,:courier4)",
            nativeQuery = true)

    public void insertProduct(String productName, Long categoryId, Long discount,String overview, String description, String thumbnail,String hashTag,String color, String dimen,Long price, String productCode, Long quantity, String weight, String picture1,String picture2,String picture3,String picture4,String picture5,String picture6,String courier1,String courier2,String courier3, String courier4);



//    @Modifying
//    @Transactional
//    @Query("UPDATE Product SET name = :productName, category_id = :categoryId, overview = :overview, :description = :description, thumbnail_url = :thumbnail, hash_tag = :hashTag, color = :color , dimensions = :dimensions , price = :price, product_code = :productCode  WHERE id = :id")
//    public void updateProduct(Long status, Long id);
}


