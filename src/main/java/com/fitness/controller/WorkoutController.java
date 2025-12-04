package com.fitness.controller;

import com.fitness.model.Workout;
import com.fitness.repository.WorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    // POST /api/workouts
    @PostMapping("/workouts")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout saved = workoutRepository.save(workout);
        return ResponseEntity.ok(saved);
    }

    // GET /api/users/{userId}/workouts
    @GetMapping("/users/{userId}/workouts")
    public ResponseEntity<List<Workout>> getWorkoutsForUser(@PathVariable Long userId) {
        List<Workout> list = workoutRepository.findByUserIdOrderByDateDesc(userId);
        return ResponseEntity.ok(list);
    }
}
