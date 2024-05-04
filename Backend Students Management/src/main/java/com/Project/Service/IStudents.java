package com.Project.Service;

import com.Project.StudentsData;
import java.util.List;


public interface IStudents
{
    public StudentsData saveStudents(StudentsData students);/// declaring  methods to save the students data
    public List<StudentsData> getAllStudents();// declaring a method which is used to get all the list of student records
    public StudentsData getStudent(Integer id);// declaring a methods to get a single student by id
    public void DeleteStudent(Integer id);
    public void updateStudent(Integer id,StudentsData students);
}
