public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public boolean isTeen(){
        return (this.age > 12) && (this.age < 20);
    }

    public String getFullName(){
        if ((firstName.isEmpty()) && (lastName.isEmpty())){
            return "";
        }
        if (firstName.isEmpty()){
            return lastName;
        }
        if (lastName.isEmpty()){
            return firstName;
        }
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ((age<0) || (age>100)){
            age = 0;
        }
        this.age = age;
    }
}
