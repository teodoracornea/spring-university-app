package ro.fasttrackit.service.model;

import java.util.Objects;

/*
DTO = Data Transmission Object (is a plain old java object)
 */
public class HumanDto {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanDto humanDto = (HumanDto) o;
        return Objects.equals(id, humanDto.id) && Objects.equals(cnp, humanDto.cnp) && Objects.equals(lastname, humanDto.lastname)
                && Objects.equals(firstname, humanDto.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnp, lastname, firstname);
    }


}
