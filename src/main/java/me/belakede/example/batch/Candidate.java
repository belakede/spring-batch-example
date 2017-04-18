package me.belakede.example.batch;

public class Candidate {

    private String fullName;
    private Integer age;
    private String town;
    private String jobTitle;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (fullName != null ? !fullName.equals(candidate.fullName) : candidate.fullName != null) return false;
        if (age != null ? !age.equals(candidate.age) : candidate.age != null) return false;
        if (town != null ? !town.equals(candidate.town) : candidate.town != null) return false;
        return jobTitle != null ? jobTitle.equals(candidate.jobTitle) : candidate.jobTitle == null;
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", town='" + town + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
