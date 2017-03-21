package com.xjtu.spider.repository;

import com.xjtu.spider.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 图片数据库的操作：增删改查
 * Created by yuanhao on 2017/3/16.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByImageID(Long imageID);

    List<Image> findByTermID(Long termID);

    List<Image> findByTermName(String termName);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("delete from Image i where i.imageContent = ?1")
    void deleteEmpty(byte[] imageContent);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Image i set i.imageAPI = ?1 where i.imageID = ?2")
    void updateByImageID(String api, Long imageID);

}