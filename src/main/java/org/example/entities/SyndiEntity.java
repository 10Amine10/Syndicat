package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SyndiEntity {
    @Id
@Column(name = "id_syndi")
    private long id;
    @Column(name = "name_syndi")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SyndiEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
