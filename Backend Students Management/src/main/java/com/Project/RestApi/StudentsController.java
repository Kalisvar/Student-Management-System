package com.Project.RestApi;

import com.Project.Service.IStudents;
import com.Project.StudentsData;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // creating a rest controller which is the one going to communicate with frontend and getting files from frontend in json format
@RequestMapping("/api") //creating an overall point before the endpoints
@CrossOrigin(origins = "http://localhost:5173/")// connecting the frontend and backend

public class StudentsController
{
    @Autowired//(is an automatic dependency injection) which is explained the controller that it has some classes which have implemented this interface just inject those objects
    private IStudents service;//declaring a reference variable for interface to use the methods

    @PostMapping("/Student")// creating an end point for this method and post mapping is used to send the data to the server
    public StudentsData registerStudent(@RequestBody StudentsData studentsData)//request body is requesting a data in json format and  changing in student object format
    {

      StudentsData student = service.saveStudents(studentsData);/// Transmit the data to service layer to perform operations and storage purpose and  also get the data in the student object format from the service layer
      return student;//responding the http with response body
    }


    @PutMapping("/Student/{id}")
    public ResponseEntity<StudentsData> UpdateStudents(@PathVariable Integer id,@RequestBody StudentsData studentsData)
    {
        service.updateStudent(id,studentsData);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Students")/// (get mapping is used to retrieve the data from the api)creating an end point where the api is sending a list students to the client side

    public List<StudentsData> getAllStudents()        // getting multiple student from a service layer and sending to  the client side
    {
        List<StudentsData> listOfStudents = service.getAllStudents();// getting the list of objects from the service layer
        return listOfStudents ;//responding the http with response body

    }

    @GetMapping("/Student/{id}")// id we have mentioned in curly braces because of fetching from url

    public ResponseEntity<StudentsData> getStudent(@PathVariable Integer id ) // getting a single students by id and pathvarible is used to get the id from the url
    {
      StudentsData student = service.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/Student/{id}")
    public ResponseEntity<StudentsData> deleteStudent(@PathVariable Integer id)// deleting a students by id and responding back with response entity which is a having both url and response body
    {

        service.DeleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
