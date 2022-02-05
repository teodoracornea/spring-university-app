package ro.fasttrackit.service.model;

import java.util.Date;
import java.util.Objects;

public class MessageDto {
    private Date date;
    private String professorName;
    private String universityDept;
    private String universityYear;
    private String semesterNo;

    @Override
    public String toString() {
        return "MessageDto{" +
                "date=" + date +
                ", professorName='" + professorName + '\'' +
                ", universityDept='" + universityDept + '\'' +
                ", universityYear='" + universityYear + '\'' +
                ", semesterNo='" + semesterNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDto that = (MessageDto) o;
        return Objects.equals(date, that.date) && Objects.equals(professorName, that.professorName) && Objects.equals(universityDept, that.universityDept) && Objects.equals(universityYear, that.universityYear) && Objects.equals(semesterNo, that.semesterNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, professorName, universityDept, universityYear, semesterNo);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
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
}
