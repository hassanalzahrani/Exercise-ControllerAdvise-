package com.example.demo.Modell;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
       @Column(nullable = false)

    @NotNull
    private int customerId;
        @Column(nullable = false)

    @NotNull
    private int craftsmanId;

    @Min(0)
    @Max(5)
    private int rating;
    @Column(nullable = false)

    @Size(max = 255)
    private String reviewText;
}
