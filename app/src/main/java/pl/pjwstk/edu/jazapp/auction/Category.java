package pl.pjwstk.edu.jazapp.auction;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;

    public Category(){}
    public Category(String name, Section section){
        this.name = name;
        this.section = section;
    }
}
