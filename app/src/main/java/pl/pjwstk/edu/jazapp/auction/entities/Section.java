package pl.pjwstk.edu.jazapp.auction.entities;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Section(){}

    public Section(String name){
        this.name = name;
    }
}
