package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Fruit {
    private String name;
    private Long amount;
}
