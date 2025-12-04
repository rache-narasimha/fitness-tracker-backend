package com.fitness.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDate date;
    private String mealType;   // breakfast, lunch, dinner, snack
    private Integer calories;
    private String notes;

    public Meal() {}

    public Meal(Long userId, LocalDate date, String mealType, Integer calories, String notes) {
        this.userId = userId;
        this.date = date;
        this.mealType = mealType;
        this.calories = calories;
        this.notes = notes;
    }

    // getters & setters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getMealType() { return mealType; }
    public void setMealType(String mealType) { this.mealType = mealType; }
    public Integer getCalories() { return calories; }
    public void setCalories(Integer calories) { this.calories = calories; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
