package ro.fasttrackit.service.model;

import java.util.Objects;
import java.util.Set;

public class AssignDto {
    Set<Long> studentIdSet;
    String universityDept;
    String universityYear;
    String semesterNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignDto assignDto = (AssignDto) o;
        return Objects.equals(studentIdSet, assignDto.studentIdSet) && Objects.equals(universityDept, assignDto.universityDept) && Objects.equals(universityYear, assignDto.universityYear) && Objects.equals(semesterNo, assignDto.semesterNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentIdSet, universityDept, universityYear, semesterNo);
    }

    public Set<Long> getStudentIdSet() {
        return studentIdSet;
    }

    public void setStudentIdSet(Set<Long> studentIdSet) {
        this.studentIdSet = studentIdSet;
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






