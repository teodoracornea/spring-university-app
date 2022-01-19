package ro.fasttrackit.model;

import java.time.Year;
import java.util.Date;
import java.util.Objects;

public class Semester {
    private Long id;
    private String universityDept;
    private String universityYear;
    private String semesterNo;
    private Date startDate;
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityDept() {
        return universityDept;
    }

    public void setUniversityDept(String universityDept) {
        this.universityDept = universityDept;
    }

    public String getUniversityYear() {
        return universityYear;
    }

    public void setUniversityYear(String universityYear) {
        this.universityYear = universityYear;
    }

    public String getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(String semesterNo) {
        this.semesterNo = semesterNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id=" + id +
                ", universityDept='" + universityDept + '\'' +
                ", universityYear='" + universityYear + '\'' +
                ", semesterNo='" + semesterNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return Objects.equals(id, semester.id) && Objects.equals(universityDept, semester.universityDept) && Objects.equals(universityYear, semester.universityYear) && Objects.equals(semesterNo, semester.semesterNo) && Objects.equals(startDate, semester.startDate) && Objects.equals(endDate, semester.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, universityDept, universityYear, semesterNo, startDate, endDate);
    }
}






