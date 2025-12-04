package com.fitness.controller;

import com.fitness.model.Meal;
import com.fitness.repository.MealRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MealController {

    private final MealRepository mealRepository;

    public MealController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    // POST /api/meals
    @PostMapping("/meals")
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        // if date not provided, default to today
        if (meal.getDate() == null) {
            meal.setDate(LocalDate.now());
        }
        Meal saved = mealRepository.save(meal);
        return ResponseEntity.ok(saved);
    }

    // GET /api/users/{userId}/meals
    @GetMapping("/users/{userId}/meals")
    public ResponseEntity<List<Meal>> getMealsForUser(@PathVariable Long userId) {
        List<Meal> list = mealRepository.findByUserIdOrderByDateDesc(userId);
        return ResponseEntity.ok(list);
    }

    // Optional quick filter: GET /api/users/{userId}/meals?date=2025-12-03
    @GetMapping(value = "/users/{userId}/meals", params = "date")
    public ResponseEntity<List<Meal>> getMealsForUserByDate(@PathVariable Long userId, @RequestParam String date) {
        LocalDate d = LocalDate.parse(date);
        List<Meal> list = mealRepository.findByUserIdAndDate(userId, d);
        return ResponseEntity.ok(list);
    }
}

