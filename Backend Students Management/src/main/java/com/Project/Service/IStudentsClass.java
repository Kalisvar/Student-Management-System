package com.Project.Service;

import com.Project.Dao.StudentsRepo;
import com.Project.StudentsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service // mentioning ist as a service component and also framework will automatically register as a spring bean for dependency injection
public class IStudentsClass implements IStudents
{
    @Autowired//(automatic dependency injection)
    private StudentsRepo repoStudent;//creating a reference variable to access the jpa methods.

    @Override
    public StudentsData saveStudents(StudentsData students)//implementing the istudent interface methods the process called as loose coupling
    {
        ///database operation or persistence layer(DAO)
        repoStudent.save(students);//saving the students objects in the h2 database
        return students;
    }

    @Override
    public List<StudentsData> getAllStudents()
    {
        return repoStudent.findAll();/// getting data from the database and returning to the controller
    }

    @Override
    public StudentsData getStudent(Integer id)
    {

        StudentsData student = repoStudent.findById(id).get();
        return student;
    }

    @Override
    public void DeleteStudent(Integer id) {
      StudentsData studentsData =  repoStudent.findById(id).get();
      repoStudent.delete(studentsData);
    }

    @Override
    public void updateStudent(Integer id,StudentsData studentsData) {
       StudentsData existStudents = repoStudent.findById(id).get();
       existStudents.setName(studentsData.getName());
        existStudents.setEmail(studentsData.getEmail());
        existStudents.setAddress(studentsData.getAddress());
        existStudents.setPhoneNumber(studentsData.getPhoneNumber());
        existStudents.setClassName(studentsData.getClassName());
        existStudents.setFathersName(studentsData.getFathersName());
        repoStudent.save(existStudents);

    }
}
