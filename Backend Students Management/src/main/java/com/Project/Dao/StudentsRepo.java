package com.Project.Dao;

import com.Project.StudentsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository// annotate that it is a repository
// creating an interface because we don't want to create an abstract class, and we created this to access the database methods for CRUD operations
public interface StudentsRepo extends JpaRepository<StudentsData,Integer>//jpa basically create the database with student fields and Integer is an primary key
{

}
