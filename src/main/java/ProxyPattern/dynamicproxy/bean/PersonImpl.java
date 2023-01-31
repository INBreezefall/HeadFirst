package ProxyPattern.dynamicproxy.bean;

public class PersonImpl implements Person {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0)
            return 0;
        return (rating / ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
        System.out.println("Set name = " + name);
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
        System.out.println("Set gender = " + gender);
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
        System.out.println("Set interests = " + interests);
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
        ratingCount++;
        System.out.println("Set HotOrNotRating = " + rating);
    }
}
