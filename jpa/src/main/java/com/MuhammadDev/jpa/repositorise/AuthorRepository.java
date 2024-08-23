package com.MuhammadDev.jpa.repositorise;

import com.MuhammadDev.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository <Author ,Integer> , JpaSpecificationExecutor<Author> {



   List<Author> findByNamedQuery(@Param("age") int age);

   @Modifying
   @Transactional
   @Query("update Author a set a.age=:age where a.id = :id")
   int updateAuthor(int age , int id);

   @Modifying
   @Transactional
   @Query("update Author a set a.age=:age")
   int updateAllAuthorsAges(int age );








//   select * from Author where first_name = "anything"

   List<Author> findAllByFirstName(String FN);




   //   select * from Author where first_name = "anything"
   List<Author> findAllByFirstNameIgnoreCase(String FN);


   //   select * from Author where first_name like "%anything%"

   List<Author> findAllByFirstNameContainingIgnoreCase(String FN);

   //   select * from Author where first_name like "anything%"

   List<Author> findAllByFirstNameStartsWithIgnoreCase(String FN);


   //   select * from Author where first_name like "%anything"

   List<Author> findAllByFirstNameEndsWithIgnoreCase(String FN);



   //   select * from Author where first_name like "%anything"

   List<Author> findAllByFirstNameInIgnoreCase(List <String> fn);
}
