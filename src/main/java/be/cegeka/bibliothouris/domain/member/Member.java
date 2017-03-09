package be.cegeka.bibliothouris.domain.member;

public class Member {

    private String INSS;
    private String firstName;
    private String lastName;
    private String street;
    private int number;
    private int postalCode;
    private String city;

    public Member(String INSS, String firstName, String lastName, String street, int number, int postalCode, String city) {
        this.INSS = INSS;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getINSS() {
        return INSS;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return INSS.equals(member.INSS);
    }

    @Override
    public int hashCode() {
        return INSS.hashCode();
    }
}
