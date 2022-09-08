package br.com.mdsdev.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private Double salary;
    private List<String> projects;

}
