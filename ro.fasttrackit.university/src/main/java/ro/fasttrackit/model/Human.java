package ro.fasttrackit.model;

import java.util.Objects;

public class Human {
    private Long id;
    private String cnp;
    private String lastname;
    private String firstname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", cnp='" + cnp + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id) && Objects.equals(cnp, human.cnp) &&
                Objects.equals(lastname, human.lastname) &&
                Objects.equals(firstname, human.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnp, lastname, firstname);
    }
}
