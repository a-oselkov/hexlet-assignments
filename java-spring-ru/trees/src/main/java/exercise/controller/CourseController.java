package exercise.controller;

import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping(path = "/{id}/previous")
    public List<Optional<Course>> getRequiredCourses(@PathVariable long id) {
        String path = courseRepository.findById(id).getPath();
        List<Optional<Course>> previous = new ArrayList<>();
        if (path == null) {
            return previous;
        }
        String[] prev = path.split("\\.");
        for (int i = 0; i < prev.length; i++) {

            if (prev[i] != null && !prev[i].isEmpty()) {
                Long courseNumber = Long.parseLong(prev[i]);
                previous.add(courseRepository.findById(courseNumber));
            }
        }
        return previous;
    }
    // END

}
