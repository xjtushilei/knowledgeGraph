package com.xjtu.datainput.repository;

import com.xjtu.datainput.domain.Relation;
import com.xjtu.datainput.domain.RelationCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by shilei on 2017/3/13.
 */
public interface RelationRepository extends JpaRepository<Relation, Long> {

    List<Relation> findByCatalogIDAndTermID(Long catalogID, Long termID);

    List<Relation> findByCatalogID(Long catalogID);

    List<Relation> findByTermID(Long termID);

    @Query("select new com.xjtu.datainput.domain.RelationCatalog(r.relationID, r.catalogID, r.termID, r.termName, r.classID, r.className," +
            " c.parentChapterID, c.parentChapterName, c.chapterID, c.chapterName, c.childrenChapterID, c.childrenChapterName) " +
            "from Relation r ,Catalog c where  " +
            "r.catalogID=c.catalogID and r.classID=?1")
    List<RelationCatalog> findRelationByClassID(String ClassID);


    List<Relation> findByClassID(String ClassID);
}
