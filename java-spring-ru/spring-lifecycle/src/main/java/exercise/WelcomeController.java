package exercise;

import exercise.daytimes.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {

    @Autowired
    Meal meal;

    @Autowired
    Daytime daytime;

    @GetMapping("/daytime")
    public String root() {
        String time = daytime.getName();
        String mealTime = meal.getMealForDaytime(time);

        return String.format("It is %s now. Enjoy your %s", time, mealTime);
    }
}
// END
