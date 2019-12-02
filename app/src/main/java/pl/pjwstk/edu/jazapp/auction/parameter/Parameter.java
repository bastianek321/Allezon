package pl.pjwstk.edu.jazapp.auction.parameter;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Parameter(){}
    public Parameter(String name){
        this.name= name;
    }
}
