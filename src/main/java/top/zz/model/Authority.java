package top.zz.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by X-man on 2017/4/8.
 */
@Entity
@Table(name = "xx_authority")
public class Authority implements Serializable {


    private static final long serialVersionUID = 271555957152486192L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
